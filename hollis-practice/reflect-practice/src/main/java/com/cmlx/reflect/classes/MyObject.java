package com.cmlx.reflect.classes;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author CMLX
 * @Date -> 2021/9/29 12:05
 * @Desc ->
 **/
@Data
@Slf4j
@TestAnnotation
public class MyObject extends MySupperObjec implements MyObjectInterface1, MyObjectInterface2 {

    @TestAnnotation
    private String name;
    public Integer age;

    public MyObject() {

    }

    public MyObject(String name) {
        this.name = name;
    }

    @TestAnnotation
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
