package com.java.study;

import java.io.*;

/**
 * @author zh_yan
 * @ClassName FileCopy
 * @Description TODO
 * @Date 2020/1/14
 * @Version 1.0
 **/
public class FileCopy {
    public static void main(String[] args) {
        File file1 = new File("E:/vacation-work/Random.txt");
        File file2 = new File("E:/vacation-work/FileCopy.txt");
        if (!file2.exists()){
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileInputStream in = null;
        FileOutputStream out = null;
        byte[] bytes = new byte[1024];
        int length = 0;
        try {
            in = new FileInputStream(file1);
            out = new FileOutputStream(file2);
            try {
                while ((length = in.read(bytes)) != -1){
                    out.write(bytes,0,length);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
