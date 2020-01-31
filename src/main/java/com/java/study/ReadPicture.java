package com.java.study;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zh_yan
 * @ClassName ReadPicture
 * @Description TODO
 * @Date 2020/1/18
 * @Version 1.0
 **/
public class ReadPicture {
    String path = null;
    List<File> list = new ArrayList<File>();

    public List<File> printFile(File file){
        if(!file.isDirectory()) {

        }else {
            File[] fs = file.listFiles();
            int len = fs.length;
            for (int i = 0; i < len; i++) {
                File file1 = fs[i];
                list.add(file1);
                printFile(file1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        File file = new File("E:\\vacation-work");
        List<File> files = new ArrayList<File>();
        List<File> list1 = new ArrayList<File>();
        list1 = new ReadPicture().printFile(file);
        Collections.reverse(list1);
        int len = list1.size();
        for(int i = 0; i < len; i++){
            int position = list1.get(i).getName().lastIndexOf(".");
            if(position <= 0){
                continue;
            }
            String suffix = list1.get(i).getName().substring(position+1);
            if(suffix.equals("jpg")){
                files.add(list1.get(i));
            }
        }
        System.out.println(files);

    }
}