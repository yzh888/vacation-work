package com.java.study;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author zh_yan
 * @ClassName AccessRandomRW
 * @Description TODO
 * @Date 2020/1/18
 * @Version 1.0
 **/
public class AccessRandomRW {
    public static void main(String[] args) throws IOException {
        File file = new File("E:\\vacation-work\\data.txt");
        /*定义一个随机读取流*/
        RandomAccessFile ras = new RandomAccessFile(file, "rw");
        String line;
        /*逐行读取*/
        while ((line = ras.readLine()) != null){
            /*读到的Host长度多了1，因为将换行符也算在内了，所以需要减1才能匹配成功*/
            if (line.substring(0,line.length()-1).equals("Host")){
                System.out.println("主机地址为：" + ras.readLine());
            }else if(line.substring(0, line.length()-1).equals("Content-Type")){
                System.out.println("相应类型：" + ras.readLine());
            }
        }

    }
}
