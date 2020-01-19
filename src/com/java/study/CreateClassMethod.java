package com.java.study;

import java.lang.reflect.Constructor;

/**
 * @author zh_yan
 * @ClassName CreateClassMethod
 * @Description TODO
 * @Date 2020/1/20
 * @Version 1.0
 **/
public class CreateClassMethod {
    public static void main(String[] args)throws Exception {

        // 使用new关键字创建对象
        Student student1 = new Student("小王",20);
        System.out.println(student1);

        Class c = Class.forName("Student");
        Student student = (Student) c.newInstance();
        System.out.println(student);

        // 调用对象的 clone() 方法创建对象
        /*Student student2 = (Student)student1.clone();
        System.out.println(student2);*/

        /*使用Constructor类的newInstance方法*/
        Class heroClass = Class.forName("Student"); //获取构造器
        Constructor constructor = heroClass.getConstructor();
        Student student3 =(Student) constructor.newInstance();
        System.out.println(student3);

    }
}
