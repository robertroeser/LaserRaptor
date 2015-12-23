package laser.raptor.core;

import uk.co.real_logic.agrona.BitUtil;
import uk.co.real_logic.agrona.MutableDirectBuffer;
import uk.co.real_logic.agrona.concurrent.UnsafeBuffer;

import java.nio.ByteBuffer;

public class MetadataFlyweight {
    private MutableDirectBuffer metadata;

    public MetadataFlyweight() {
        metadata = new UnsafeBuffer(ByteBuffer.allocate(BitUtil.SIZE_OF_LONG));
    }

    public void wrap(ByteBuffer byteBuffer, int offset, int length) {
        metadata.wrap(byteBuffer, offset, length);
    }

    public void wrap(ByteBuffer byteBuffer) {
        metadata.wrap(byteBuffer);
    }

    public void setServiceId(int serviceId) {
        metadata.putInt(0, serviceId);
    }

    public int getServiceId() {
        return metadata.getInt(0);
    }

    public void setMethodId(int methodId) {
        metadata.putInt(BitUtil.SIZE_OF_INT, methodId);
    }

    public int getMethodId() {
        return metadata.getInt(BitUtil.SIZE_OF_INT);
    }

    public long getServiceMethodHash() {
        return metadata.getLong(0);
    }

    public ByteBuffer getByteBuffer() {
        ByteBuffer byteBuffer = metadata.byteBuffer().slice();
        byteBuffer.position(0);
        return byteBuffer;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("MetadataFlyWeight");

        sb.append("service id = ").append(getServiceId()).append('\n');
        sb.append("method id = ").append(getMethodId()).append('\n');
        sb.append("service method hash id = ").append(getServiceMethodHash()).append('\n');

        return sb.toString();
    }
}
