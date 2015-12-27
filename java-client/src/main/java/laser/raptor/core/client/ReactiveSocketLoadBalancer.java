package laser.raptor.core.client;

import com.gs.collections.impl.map.mutable.ConcurrentHashMapUnsafe;
import io.reactivesocket.ConnectionSetupPayload;
import io.reactivesocket.ReactiveSocket;
import io.reactivesocket.websocket.rxnetty.WebSocketDuplexConnection;
import io.reactivex.netty.protocol.http.client.HttpClient;
import io.reactivex.netty.protocol.http.ws.WebSocketConnection;
import io.reactivex.netty.protocol.http.ws.client.WebSocketResponse;
import org.reactivestreams.Publisher;
import rx.Observable;
import rx.RxReactiveStreams;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.functions.Func2;

import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

class ReactiveSocketLoadBalancer {

    private SocketAddressFactory socketAddressFactory;

    private ClosedConnectionsProvider closedConnections;

    private Func1<SocketAddress, ReactiveSocketStatsHolder> reactiveSocketFactory;

    private StatsSelector statsSelector;

    private Map<SocketAddress, ReactiveSocketStatsHolder> reactiveSocketStatsHolders = new ConcurrentHashMapUnsafe<>();

    /**
     * Creates a new instances a ReactiveSocketLoadBalander
     *
     * @param socketAddressFactory  Func0 that returns an observable of list of sockets
     * @param closedConnections     Func0 that gives a diff in the closed connections
     * @param reactiveSocketFactory Factory to create reactive sockets
     * @param statsSelector         Func2 that takes two stats are returns the one that is preferable
     */
    public ReactiveSocketLoadBalancer(
        SocketAddressFactory socketAddressFactory,
        ClosedConnectionsProvider closedConnections,
        ReactiveSocketFactory reactiveSocketFactory,
        StatsSelector statsSelector) {
        this.socketAddressFactory = socketAddressFactory;
        this.statsSelector = statsSelector;
        this.reactiveSocketFactory = (SocketAddress socketAddress) -> {
            ReactiveSocket reactiveSocket = reactiveSocketFactory.call(socketAddress);
            return new ReactiveSocketStatsHolder(reactiveSocket);
        };
        this.closedConnections = closedConnections;
    }

    public Observable<ReactiveSocketStatsHolder> nextAvailableSocket() {
        return socketAddressFactory
            .call()
            .map(socketAddresses -> {
                final int size = socketAddresses.size();
                ReactiveSocketStatsHolder reactiveSocketStatsHolder;
                if (size == 1) {
                    SocketAddress socketAddress = socketAddresses.get(0);
                    reactiveSocketStatsHolder = reactiveSocketStatsHolders.computeIfAbsent(socketAddress, reactiveSocketFactory::call);
                } else {
                    XORShiftRandom random = XORShiftRandom.getInstance();

                    int first = Math.abs(random.randomInt()) % size;
                    int second = Math.abs(random.randomInt()) % size;

                    SocketAddress firstSocket = socketAddresses.get(first);
                    SocketAddress secondSocket = socketAddresses.get(second);

                    ReactiveSocketStatsHolder firstReactiveSocketHolder = reactiveSocketStatsHolders.computeIfAbsent(firstSocket, reactiveSocketFactory::call);
                    ReactiveSocketStatsHolder secondReactiveSocketHolder = reactiveSocketStatsHolders.computeIfAbsent(secondSocket, reactiveSocketFactory::call);

                    reactiveSocketStatsHolder = (ReactiveSocketStatsHolder) statsSelector.call(firstReactiveSocketHolder, secondReactiveSocketHolder);
                }
                return reactiveSocketStatsHolder;
            })
            .finallyDo(() -> {
                List<SocketAddress> call = closedConnections.call();
                if (call != null) {
                    call.forEach(socketAddress -> {
                        ReactiveSocketStatsHolder reactiveSocketStatsHolder = reactiveSocketStatsHolders.remove(socketAddress);
                        reactiveSocketStatsHolder.close();
                    });
                }
            });
    }

    /*
     * Interfaces
     */
    public interface SocketAddressFactory extends  Func0<Observable<List<SocketAddress>>> {}
    public interface ClosedConnectionsProvider extends Func0<List<SocketAddress>> {}
    public interface ReactiveSocketFactory extends Func1<SocketAddress, ReactiveSocket> {}
    public interface StatsSelector extends Func2<Stats, Stats, Stats> {}

    /*
     * Simple Implementations
     */
    public static class StaticListFactory implements SocketAddressFactory {
        private List<SocketAddress> socketAddresses;

        protected StaticListFactory(List<SocketAddress> socketAddresses) {
            this.socketAddresses = socketAddresses;
        }

        @Override
        public Observable<List<SocketAddress>> call() {
            return Observable.just(socketAddresses);
        }

        public static StaticListFactory newInstance(SocketAddress socketAddress, SocketAddress... socketAddresses) {
            List<SocketAddress> addressList  = new ArrayList<>();
            addressList.add(socketAddress);
            addressList.addAll(Arrays.asList(socketAddresses));
            return new StaticListFactory(addressList);
        }
    }

    public final static ClosedConnectionsProvider NO_CHANGE_PROVIDER = () -> null;

    public final static ReactiveSocketFactory WEB_SOCKET_FACTORY = (socketAddress) -> {
            Observable<WebSocketConnection> wsConnection = HttpClient.newClient(socketAddress)
                //.enableWireLogging(LogLevel.ERROR)
                .createGet("/rs")
                .requestWebSocketUpgrade()
                .flatMap(WebSocketResponse::getWebSocketConnection);

            Publisher<WebSocketDuplexConnection> connectionPublisher =
                WebSocketDuplexConnection.create(RxReactiveStreams.toPublisher(wsConnection));

            ReactiveSocket reactiveSocket = RxReactiveStreams
                .toObservable(connectionPublisher)
                .map(w -> ReactiveSocket.fromClientConnection(w, ConnectionSetupPayload.create("CBOR", "CBOR")))
                .toBlocking()
                .single();

            reactiveSocket.startAndWait();

            return reactiveSocket;
    };

    public final static StatsSelector LEAST_LOADED_SELECTOR = (Stats left, Stats right) -> {
        if (left == right) {
            return left;
        }

        long leftOutstandingRequests = left.getOutstandingRequests();
        long rightOutstandingRequests = right.getOutstandingRequests();

        if (leftOutstandingRequests <= rightOutstandingRequests) {
            return left;
        } else {
            return right;
        }
    };
}
