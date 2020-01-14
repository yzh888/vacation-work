package com.java.study;

import java.io.*;
import java.util.Arrays;


/**
 * @author zh_yan
 * @ClassName Random
 * @Description TODO
 * @Date 2020/1/13
 * @Version 1.0
 **/
public class Random {
    public static void main(String[] args) throws IOException {
        int[] rand = new int[100];
        for (int i = 0; i <= 99; i++) {
            int number = (int) (Math.random() * 100);
            rand[i]=number;
        }
        //创建文件夹，将存放随机数的txt文件放入
        File file = new File("E:/vacation-work/Random.txt");
        Writer writer = new FileWriter(file);
        PrintWriter randoms = new PrintWriter(writer);
            randoms.print(Arrays.toString(rand));
            randoms.close();
            System.out.println("随机数生成成功");
        }
    }




