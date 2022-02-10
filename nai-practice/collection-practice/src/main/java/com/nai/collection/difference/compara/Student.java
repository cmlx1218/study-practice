package com.nai.collection.difference.compara;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author CMLX
 * @Data -> 2022/02/09/15:35
 * @Desc ->
 */
public class Student implements Comparable {

    private String name;
    private Integer age;

    public Student() {
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        // return > 0 对象大于参数对象， == 0  对象等于参数对象，  < 0 对象小于参数对象
        Student student = (Student) o;
        return student.age.compareTo(age);
    }
}
