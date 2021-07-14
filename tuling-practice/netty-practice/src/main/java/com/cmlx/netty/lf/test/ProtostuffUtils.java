package com.cmlx.netty.lf.test;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import lombok.experimental.UtilityClass;
import io.protostuff.runtime.RuntimeSchema;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author CMLX
 * @Date -> 2021/7/14 18:17
 * @Desc ->
 **/
@UtilityClass
public class ProtostuffUtils {

    // 避免每次序列化都重新申请buffer空间
    private static LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);

    // 缓存Scheme
    private static Map<Class<?>, Schema<?>> schemaCache = new ConcurrentHashMap<>();

    /**
     * 序列化方法，把指定对象序列化成功字节数组
     *
     * @param obj
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> byte[] serialize(T obj) {
        Class<T> tClass = (Class<T>) obj.getClass();
        Schema<T> schema = getSchema(tClass);
        byte[] data;
        try {
            data = ProtostuffIOUtil.toByteArray(obj, schema, buffer);
        } finally {
            buffer.clear();
        }
        return data;
    }

    /**
     * 反序列化方法，将字节数组反序列化成指定成指定Class类型
     *
     * @param data
     * @param tClass
     * @param <T>
     * @return
     */
    public <T> T deserialize(byte[] data, Class<T> tClass) {
        Schema<T> schema = getSchema(tClass);
        T obj = schema.newMessage();
        ProtostuffIOUtil.mergeFrom(data, obj, schema);
        return obj;
    }

    @SuppressWarnings("unchecked")
    private static <T> Schema<T> getSchema(Class<T> tClass) {
        Schema<T> schema = (Schema<T>) schemaCache.get(tClass);
        if (Objects.isNull(schema)) {
            // 这个schema通过RuntimeSchema进行懒创建并缓存
            // 所以可以一直调用RuntimeSchema.getSchema()，这个方法是线程安全的
            schema = RuntimeSchema.getSchema(tClass);
            if (Objects.nonNull(schema)) {
                schemaCache.put(tClass, schema);
            }
        }
        return schema;
    }

}
