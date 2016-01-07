package laser.raptor.core.client;

import io.reactivesocket.ReactiveSocket;
import org.HdrHistogram.Histogram;
import uk.co.real_logic.agrona.LangUtil;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Implementation of the {@link Stats} that holds an instance of ReactiveSocket.
 */
class ReactiveSocketStatsHolder implements Stats {
    ReactiveSocket reactiveSocket;
    AtomicLong outstandingRequests;
    AtomicLong totalFailures;
    AtomicLong totalRequests;

    Histogram histogram;

    public ReactiveSocketStatsHolder(ReactiveSocket reactiveSocket) {
        this.reactiveSocket = reactiveSocket;
        outstandingRequests = new AtomicLong();
        totalRequests = new AtomicLong();
        totalFailures = new AtomicLong();
        this.histogram = new Histogram(TimeUnit.MINUTES.toNanos(1), 2);
    }

    public long getOutstandingRequests() {
        return outstandingRequests.get();
    }

    public long getTotalRequests() {
        return totalRequests.get();
    }

    public double getAverageTimeNanos() {
        return histogram.getMean();
    }

    @Override
    public long getP90TimeNanos() {
        return histogram.getValueAtPercentile(0.90);
    }

    @Override
    public long getP99_9TimeNanos() {
        return histogram.getValueAtPercentile(0.99_9);
    }

    @Override
    public long getP75TimeNanos() {
        return histogram.getValueAtPercentile(0.75);
    }

    @Override
    public long getP99_99TImeNanos() {
        return histogram.getValueAtPercentile(0.99_99);
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
        histogram.recordValue(System.nanoTime() - startTime);
    }

    public void recordSuccess(long startTime) {
        outstandingRequests.decrementAndGet();
        histogram.recordValue(System.nanoTime() - startTime);
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

    @Override
    public String toString() {
        return "ReactiveSocketStatsHolder{" +
            ", outstandingRequests=" + outstandingRequests +
            ", totalFailures=" + totalFailures +
            ", totalRequests=" + totalRequests +
            '}';
    }
}
