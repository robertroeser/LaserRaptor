package laser.raptor.core.serialization;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/**
 * Implementation of an {@link java.io.InputStream} that acts as a wrapper on top of a ByteBuffer. THe code is almost
 * the same code as the one Jackson provides except it lets you re-wrap on another ByteBuffer.
 */
public class ByteBufferBackedInputStreamWrapper extends InputStream {
    protected ByteBuffer _b;

    public ByteBufferBackedInputStreamWrapper() {}

    public ByteBufferBackedInputStreamWrapper(ByteBuffer buf) { _b = buf; }

    public void wrap(ByteBuffer buf) {
        this._b = buf;
    }

    @Override public int available() { return _b.remaining(); }

    @Override
    public int read() throws IOException { return _b.hasRemaining() ? (_b.get() & 0xFF) : -1; }

    @Override
    public int read(byte[] bytes, int off, int len) throws IOException {
        if (!_b.hasRemaining()) return -1;
        len = Math.min(len, _b.remaining());
        _b.get(bytes, off, len);
        return len;
    }
}