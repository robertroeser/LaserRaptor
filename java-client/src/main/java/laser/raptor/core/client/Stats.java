package laser.raptor.core.client;

/**
 * Stats about a ReactiveSocket connection
 */
public interface Stats {
    long getOutstandingRequests();

    long getTotalRequests();

    long getTotalFailures();

    double getAverageTimeNanos();


}
