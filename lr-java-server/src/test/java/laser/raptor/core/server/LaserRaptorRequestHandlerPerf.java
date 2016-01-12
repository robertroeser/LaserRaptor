package laser.raptor.core.server;

import com.google.common.collect.ImmutableSet;
import io.reactivesocket.Payload;
import laser.raptor.core.MetadataFlyweight;
import laser.raptor.core.serialization.JacksonUtil;
import laser.raptor.test1.Func1Request;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
public class LaserRaptorRequestHandlerPerf {

    @State(Scope.Benchmark)
    public static class Input {
        LaserRaptorRequestHandler requestHandler;
        Payload payload;
        Blackhole bh;

        public Input() {
            requestHandler = new LaserRaptorRequestHandler();
            requestHandler.scanPackages(
                ImmutableSet.of("laser.raptor.test1.Func1"),
                "laser.raptor");

            Func1Request request = new Func1Request();
            request.setaString("Hello");

            MetadataFlyweight metadataFlyweight = new MetadataFlyweight();
            metadataFlyweight.setServiceId(100);
            metadataFlyweight.setMethodId(1);
            payload = new Payload() {
                @Override
                public ByteBuffer getData() {
                    return JacksonUtil.writeValueAsByteBuffer(request);
                }

                @Override
                public ByteBuffer getMetadata() {
                    return metadataFlyweight.getByteBuffer();
                }
            };

            bh = new Blackhole();
        }

    }

    @Benchmark
    public void testhandleRequestReply(Input input) {
        CountDownLatch latch = new CountDownLatch(1);

        input.requestHandler.handleRequestResponse(input.payload).subscribe(new Subscriber<Payload>() {
            @Override
            public void onSubscribe(Subscription s) {
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Payload payload) {
                input.bh.consume(payload);
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onComplete() {
                latch.countDown();
            }
        });

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
