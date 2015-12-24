package laser.raptor.test;


import com.google.common.collect.ImmutableSet;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelOption;
import io.reactivesocket.ConnectionSetupHandler;
import io.reactivesocket.ConnectionSetupPayload;
import io.reactivesocket.RequestHandler;
import io.reactivesocket.exceptions.SetupException;
import io.reactivesocket.websocket.rxnetty.server.ReactiveSocketWebSocketServer;
import io.reactivex.netty.protocol.http.server.HttpServer;
import laser.raptor.core.server.LaserRaptorRequestHandler;

public class Pong {
    public static void main(String... args) {
        ReactiveSocketWebSocketServer serverHandler =
            ReactiveSocketWebSocketServer.create(new ConnectionSetupHandler() {
                @Override
                public RequestHandler apply(ConnectionSetupPayload setupPayload) throws SetupException {
                    return new LaserRaptorRequestHandler(ImmutableSet.of("laser.raptor.test.TestService_foo"), "laser.raptor.test");
                }
            });


        HttpServer<ByteBuf, ByteBuf> server = HttpServer.newServer(8888)
            .clientChannelOption(ChannelOption.AUTO_READ, true)
            //.enableWireLogging(LogLevel.ERROR)
            .start((req, resp) -> {
                return resp.acceptWebSocketUpgrade(serverHandler::acceptWebsocket);
            });

        server.awaitShutdown();
    }
}