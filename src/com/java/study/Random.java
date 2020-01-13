package com.java.study;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


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
        //判断是否有这个文件夹，若没有就创建
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Random.txt文件创建成功");
        } else {
            FileWriter randoms = new FileWriter(file);
            for (int i=0;i<99;i++)
            randoms.write(String.valueOf(rand[i])+" ");
            randoms.close();
            System.out.println("随机数生成成功");
        }
    }



}
