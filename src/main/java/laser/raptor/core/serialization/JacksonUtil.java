package laser.raptor.core.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.cbor.CBORFactory;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;
import uk.co.real_logic.agrona.DirectBuffer;
import uk.co.real_logic.agrona.LangUtil;
import uk.co.real_logic.agrona.concurrent.UnsafeBuffer;
import uk.co.real_logic.agrona.io.DirectBufferInputStream;

import java.io.IOException;
import java.nio.ByteBuffer;

public class JacksonUtil {
    private static final ObjectMapper cborMapper;
    private static final ObjectMapper jacksonMapper;

    private static final String mapperType = System.getProperty("api.metadata.json.mapper.type", "cbor");

    private static final ThreadLocal<DirectBufferInputStream> streamWrapper =
            ThreadLocal.withInitial(DirectBufferInputStream::new);

    private static final ThreadLocal<ByteBufferBackedInputStreamWrapper> byteBufferBackedInputStreamWrappers =
            ThreadLocal.withInitial(ByteBufferBackedInputStreamWrapper::new);

    public enum MapperType {
        cbor(cborMapper), jackson(jacksonMapper);

        final ObjectMapper mapper;

        MapperType(ObjectMapper mapper) {
            this.mapper = mapper;
        }
    }

    static {
        cborMapper = new ObjectMapper(new CBORFactory());
        jacksonMapper = new ObjectMapper();
        configureMapper(cborMapper);
        configureMapper(jacksonMapper);
    }

    private static void configureMapper(ObjectMapper mapper) {
        mapper.registerModule(new AfterburnerModule());
        mapper.configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        mapper.configure(com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT, true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        SimpleModule module = new SimpleModule(Version.unknownVersion());
        mapper.registerModule(module);
    }

    public static ObjectMapper getObjectMapper() {
        return getObjectMapper(MapperType.valueOf(mapperType));
    }

    public static ObjectMapper getObjectMapper(MapperType mapperType) {
        return mapperType.mapper;
    }

    public static <V> V readValueFromDirectBuffer(final DirectBuffer buffer, Class<V> clazz) {
        DirectBufferInputStream is = streamWrapper.get();
        is.wrap(buffer);

        V v = null;
        try {
            v = getObjectMapper().readValue(is, clazz);
        } catch (IOException e) {
            LangUtil.rethrowUnchecked(e);
        }

        return v;
    }

    public static <V> V readValueFromByteBuffer(final ByteBuffer byteBuffer, Class<V> clazz)  {
        ByteBufferBackedInputStreamWrapper bis = byteBufferBackedInputStreamWrappers.get();
        bis.wrap(byteBuffer);

        V v = null;
        try {
            v = getObjectMapper().readValue(bis, clazz);
        } catch (IOException e) {
            LangUtil.rethrowUnchecked(e);
        }

        return v;
    }

    public static <V> DirectBuffer writeValueAsDirectBuffer(final V v) {
        byte[] bytes = new byte[0];
        try {
            bytes = getObjectMapper().writeValueAsBytes(v);
        } catch (JsonProcessingException e) {
            LangUtil.rethrowUnchecked(e);
        }
        return new UnsafeBuffer(bytes);
    }

    public static <V> ByteBuffer writeValueAsByteBuffer(final V v) {
        byte[] bytes = new byte[0];
        try {
            bytes = getObjectMapper().writeValueAsBytes(v);
        } catch (JsonProcessingException e) {
            LangUtil.rethrowUnchecked(e);
        }
        return ByteBuffer.wrap(bytes);
    }
}