package com.java.study;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhy
 * @create 2020/1/21
 * @description TODO
 */
public class MaxTest {
    public static void main(String[] args) {
        Class<?> cla = null;
        try {
            cla = Class.forName("com.java.study.Max");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            assert cla != null;
           /* Method getMaxMethod = cla.getMethod("getMax", int.class);*/
            Method printMethod = cla.getMethod("print");

            try {
               /* getMaxMethod.invoke(cla.getDeclaredConstructor().newInstance(),3,5);*/
                printMethod.invoke(cla.getDeclaredConstructor().newInstance());
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
