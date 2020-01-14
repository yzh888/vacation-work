package com.java.study;

import java.io.*;
import java.util.UUID;
import java.util.prefs.Preferences;

/**
 * @author zh_yan
 * @ClassName FileCopy
 * @Description TODO
 * @Date 2020/1/14
 * @Version 1.0
 **/
public class FileCopy {
    public static void main(String[] args) throws IOException {
        BufferedReader file1 = new BufferedReader(new FileReader("E:/vacation-work/Random.txt"));
        BufferedWriter file2 = new BufferedWriter(new FileWriter("E:/vacation-work/FileCopy.txt"));
        char [] bytes = new char[1024];
        int length = 0;
        while ((length = file1.read(bytes)) != -1){
            file2.write(bytes,0,length);
            file2.flush();
        }
        file1.close();
        file2.close();

        File file3 = new File("D:\\fj.jpg");
        String FileName = file3.getName();
        String path = "E:\\vacation-work\\";
        BufferedInputStream input= new BufferedInputStream(new FileInputStream(file3));
        BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(path+FileName));
        byte[] file4 = new byte[1024];
        while (input.read(file4) != -1){
            output.write(file4);
        }
        input.close();
        output.close();
        }
    }

