package com.java.study;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author zhy
 * @create 2020/1/21
 * @description TODO
 */
public class ReflectTest {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("com.java.study.User");
            System.out.println("——————获取类名——————");
            System.out.println(clazz.toString());
            System.out.println(clazz.getSimpleName());
            System.out.println("——————获取类名中声明的构造方法");
            Constructor[] cons = clazz.getDeclaredConstructors();
            for(Constructor con : cons){
                System.out.println("构造方法名：" + con.getName() + "————");
                System.out.println("，修饰类型:" + con.getModifiers());
            }
            System.out.println("————获取类中定义的方法————");
            Method[] methods = clazz.getDeclaredMethods();
            for(Method method : methods){
                System.out.println("方法名:" + method.getName());
                System.out.println(",修饰符类型：" + method.getModifiers());
            }
            System.out.println("——————获取所有的属性——————");
            Field[] fields = clazz.getDeclaredFields();
            for(Field field : fields){
                System.out.println("属性名：" + field.getName());
                System.out.println(",修饰符类型: " + field.getModifiers());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
