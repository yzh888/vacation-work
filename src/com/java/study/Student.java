package com.java.study;

import java.io.Serializable;

/**
 * @author zh_yan
 * @ClassName Student
 * @Description TODO
 * @Date 2020/1/17
 * @Version 1.0
 **/
public class Student implements Serializable {

    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}