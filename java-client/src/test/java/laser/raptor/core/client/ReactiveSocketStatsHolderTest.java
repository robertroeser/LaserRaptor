package laser.raptor.core.client;


import io.reactivesocket.ReactiveSocket;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ReactiveSocketStatsHolderTest {
    @Test
    public void testRecordStartAndSuccess() {
        ReactiveSocket socket = Mockito.mock(ReactiveSocket.class);
        ReactiveSocketStatsHolder reactiveSocketStatsHolder = new ReactiveSocketStatsHolder(socket);
        long start = reactiveSocketStatsHolder.recordStart();

        Assert.assertEquals(1, reactiveSocketStatsHolder.outstandingRequests.get());
        Assert.assertEquals(1, reactiveSocketStatsHolder.totalRequests.get());

        reactiveSocketStatsHolder.recordSuccess(start);

        Assert.assertEquals(0, reactiveSocketStatsHolder.outstandingRequests.get());
        Assert.assertNotEquals(0, reactiveSocketStatsHolder.getAverageTimeNanos());
    }

    @Test
    public void testRecordStartAndFailure() {
        ReactiveSocket socket = Mockito.mock(ReactiveSocket.class);
        ReactiveSocketStatsHolder reactiveSocketStatsHolder = new ReactiveSocketStatsHolder(socket);
        long start = reactiveSocketStatsHolder.recordStart();

        Assert.assertEquals(1, reactiveSocketStatsHolder.outstandingRequests.get());
        Assert.assertEquals(1, reactiveSocketStatsHolder.totalRequests.get());

        reactiveSocketStatsHolder.recordFailure(start);

        Assert.assertEquals(0, reactiveSocketStatsHolder.outstandingRequests.get());
        Assert.assertEquals(1, reactiveSocketStatsHolder.totalFailures.get());
        Assert.assertNotEquals(0, reactiveSocketStatsHolder.getAverageTimeNanos());
    }
}