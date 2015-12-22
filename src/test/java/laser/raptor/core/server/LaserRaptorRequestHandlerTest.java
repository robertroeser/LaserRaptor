package laser.raptor.core.server;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import io.reactivesocket.Payload;
import laser.raptor.core.MetadataFlyweight;
import laser.raptor.core.serialization.JacksonUtil;
import laser.raptor.test1.Func1Request;
import org.junit.Assert;
import org.junit.Test;
import org.reactivestreams.Publisher;
import rx.RxReactiveStreams;
import rx.observers.TestSubscriber;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("unchecked")
public class LaserRaptorRequestHandlerTest {
    @Test
    public void testScanPackage() throws Exception {
        LaserRaptorRequestHandler requestHandler = new LaserRaptorRequestHandler();
        ClassPath classPath = ClassPath.from(Thread.currentThread().getContextClassLoader());
        requestHandler.scanPackage(classPath, ImmutableSet.of("laser.raptor.test1.Func1"), "laser.raptor");

        Assert.assertFalse(requestHandler.requestHandlerMetadata.isEmpty());

        requestHandler.requestHandlerMetadata.contains("laser.raptor.test1.Func1".hashCode());
    }

    @Test
    public void testScanPackages() throws Exception {
        LaserRaptorRequestHandler requestHandler = new LaserRaptorRequestHandler();
        requestHandler.scanPackages(
                ImmutableSet.of("laser.raptor.test1.Func1", "laser.raptor.test1.Func3"),
                "laser.raptor");

        Assert.assertFalse(requestHandler.requestHandlerMetadata.isEmpty());

        requestHandler.requestHandlerMetadata.contains("laser.raptor.test1.Func1".hashCode());
        requestHandler.requestHandlerMetadata.contains("laser.raptor.test1.Func3".hashCode());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testHandleChannel() {
        LaserRaptorRequestHandler requestHandler = new LaserRaptorRequestHandler();
        requestHandler.handleChannel(null);
    }


    @Test(expected = UnsupportedOperationException.class)
    public void testHandleMetadataPush() {
        LaserRaptorRequestHandler requestHandler = new LaserRaptorRequestHandler();
        requestHandler.handleMetadataPush(null);
    }

    @Test
    public void testHandleRequestResponse() {
        LaserRaptorRequestHandler requestHandler = new LaserRaptorRequestHandler();
        requestHandler.scanPackages(
                ImmutableSet.of("laser.raptor.test1.Func1"),
                "laser.raptor");

        Func1Request request = new Func1Request();
        request.setaString("Hello");

        MetadataFlyweight metadataFlyweight = new MetadataFlyweight();
        metadataFlyweight.setServiceId(100);
        metadataFlyweight.setMethodId(1);
        Payload payload = new Payload() {
            @Override
            public ByteBuffer getData() {
                return JacksonUtil.writeValueAsByteBuffer(request);
            }

            @Override
            public ByteBuffer getMetadata() {
                return metadataFlyweight.getByteBuffer();
            }
        };

        TestSubscriber testSubscriber = new TestSubscriber();

        Publisher<Payload> payloadPublisher = requestHandler.handleRequestResponse(payload);
        RxReactiveStreams
                .toObservable(payloadPublisher)
                .doOnError(Throwable::printStackTrace)
                .subscribe(testSubscriber);

        testSubscriber.awaitTerminalEvent(2, TimeUnit.SECONDS);
        testSubscriber.assertValueCount(1);
        testSubscriber.assertCompleted();
    }

    @Test
    public void testHandleFireForget() {
        LaserRaptorRequestHandler requestHandler = new LaserRaptorRequestHandler();
        requestHandler.scanPackages(
                ImmutableSet.of("laser.raptor.test1.Func4"),
                "laser.raptor");

        Func1Request request = new Func1Request();
        request.setaString("Hello");

        MetadataFlyweight metadataFlyweight = new MetadataFlyweight();
        metadataFlyweight.setServiceId(100);
        metadataFlyweight.setMethodId(2);
        Payload payload = new Payload() {
            @Override
            public ByteBuffer getData() {
                return JacksonUtil.writeValueAsByteBuffer(request);
            }

            @Override
            public ByteBuffer getMetadata() {
                return metadataFlyweight.getByteBuffer();
            }
        };

        TestSubscriber testSubscriber = new TestSubscriber();

        Publisher<Void> publisher = requestHandler.handleFireAndForget(payload);
        RxReactiveStreams
                .toObservable(publisher)
                .doOnError(Throwable::printStackTrace)
                .subscribe(testSubscriber);

        testSubscriber.awaitTerminalEvent(2, TimeUnit.SECONDS);
        testSubscriber.assertNoValues();
        testSubscriber.assertCompleted();
    }
}