package com.cmlx.awaken.object;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author CMLX
 * @Data -> 2021/11/25/17:41
 * @Desc ->
 */
@Slf4j
@UtilityClass
public class ObjectUtils {

    public Map<String, Object> getNotNullProperties(Object object) throws Exception {
        Map<String, Object> map = new HashMap<>();
        Class<?> aClass = object.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            Object obj = field.get(object);
            if (null != obj) {
                map.put(field.getName(), obj);
            }
        }
        return map;
    }

}
