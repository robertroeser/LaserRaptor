package laser.raptor.core.client;

import io.reactivesocket.ReactiveSocket;
import uk.co.real_logic.agrona.LangUtil;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Implementation of the {@link Stats} that holds an instance of ReactiveSocket.
 */
class ReactiveSocketStatsHolder implements Stats {
    ReactiveSocket reactiveSocket;
    AtomicLong outstandingRequests;
    AtomicLong totalFailures;
    AtomicLong totalRequests;
    AtomicLong totalNanos;

    public ReactiveSocketStatsHolder(ReactiveSocket reactiveSocket) {
        this.reactiveSocket = reactiveSocket;
        outstandingRequests = new AtomicLong();
        totalRequests = new AtomicLong();
        totalFailures = new AtomicLong();
        totalNanos = new AtomicLong();
    }

    public long getOutstandingRequests() {
        return outstandingRequests.get();
    }

    public long getTotalRequests() {
        return totalRequests.get();
    }

    public double getAverageTimeNanos() {
        return totalNanos.get() / totalRequests.get();
    }

    @Override
    public long getTotalFailures() {
        return totalFailures.get();
    }

    public long recordStart() {
        outstandingRequests.incrementAndGet();
        totalRequests.incrementAndGet();
        return System.nanoTime();
    }

    public void recordFailure(long startTime) {
        outstandingRequests.decrementAndGet();
        totalFailures.incrementAndGet();
        totalNanos.addAndGet(System.nanoTime() - startTime);
    }

    public void recordSuccess(long startTime) {
        outstandingRequests.decrementAndGet();
        totalNanos.addAndGet(System.nanoTime() - startTime);
    }

    /**
     * Gets the held ReactiveSocket instance as an Observable that will update stats.
     * @return observable that returns the ReactiveSocket
     */
    public ReactiveSocket getReactiveSocket() {
        return reactiveSocket;
    }

    public void close() {
        try {
            reactiveSocket.close();
        } catch (Exception e) {
            LangUtil.rethrowUnchecked(e);
        }
    }
}
