package com.nai.collection.difference.compara;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.*;

/**
 * @Author CMLX
 * @Data -> 2022/02/09/15:33
 * @Desc ->
 */
public class CompareMain {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("hello2");
        list.add("hello3");
        list.add("hello1");
        Collections.sort(list);

        System.out.println(list);

        List<Student> studentList = new ArrayList<>();
        Student student = new Student("cmlx2", 1);
        studentList.add(student);
        studentList.add(new Student("cmlx1", 2));
        studentList.add(new Student("cmlx3", 3));

        Collections.sort(studentList);
        System.out.println(studentList);
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student next = iterator.next();
            int i = next.getAge().compareTo(student.getAge());
            System.out.println(next);
            if (i == 0) {
                System.out.println(next);
                iterator.remove();
                System.out.println(studentList);
            }
        }



    }


}
