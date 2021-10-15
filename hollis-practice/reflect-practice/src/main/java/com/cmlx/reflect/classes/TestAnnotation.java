package com.cmlx.reflect.classes;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author CMLX
 * @Date -> 2021/9/29 12:20
 * @Desc ->
 **/
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Component //代表可以被Spring扫描
public @interface TestAnnotation {
}
