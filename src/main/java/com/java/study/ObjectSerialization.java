package com.java.study;

import java.io.*;

/**
 * @author zh_yan
 * @ClassName ObjectSerialization
 * @Description TODO
 * @Date 2020/1/17
 * @Version 1.0
 **/
public class ObjectSerialization {
    public static void main(String[] args) throws Exception {
        SerializeStudent();//序列化Person对象
        Student student = DeserializeStudent();//反序列Perons对象
        System.out.println(student);
    }

    private static void SerializeStudent() throws FileNotFoundException,
            IOException {
        Student student = new Student();
        student.setName("汪峰锋疯");
        student.setAge(20);
        // ObjectOutputStream 对象输出流，将Person对象存储到E盘的Person.txt文件中，完成对Person对象的序列化操作
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("D:/student.txt")));
        out.writeObject(student);
        System.out.println("Person对象序列化成功！");
        out.close();
    }

    private static Student DeserializeStudent() throws Exception, IOException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(
                new File("D:/student.txt")));
        Student person = (Student) inputStream.readObject();
        System.out.println("Person对象反序列化成功！");
        inputStream.close();
        return person;
    }
}