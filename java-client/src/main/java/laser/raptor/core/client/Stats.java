package laser.raptor.core.client;

/**
 * Stats about a ReactiveSocket connection
 */
public interface Stats {
    long getOutstandingRequests();

    long getTotalRequests();

    long getTotalFailures();

    double getAverageTimeNanos();

    long getP90TimeNanos();

    long getP99_9TimeNanos();

    long getP75TimeNanos();

    long getP99_99TImeNanos();
}
