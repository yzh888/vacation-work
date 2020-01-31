package com.java.study;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;


public class JFrameTest extends JFrame{
    static MyJPanel mp;
    private JTextField jTextField;
    SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
    int index;
    ImageIcon[] imgs = {
            new ImageIcon("./src/img/1.jpg"),
            new ImageIcon("./src/img/2.jpg"),

    };

    public JFrameTest(){
        jTextField = new JTextField();
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        /*系统当前时间*/
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    jTextField.setText(df.format(new Date()));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        thread2.run();
        mp = new MyJPanel();
        mp.add(jTextField);
        this.add(mp);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("窗口");
        this.setVisible(true);
        thread1.run();

    }

    /*定义JPanel面板用于放图片轮播*/
    class MyJPanel extends JPanel{
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            /*将图片加入到jpanel中*/
            g.drawImage(imgs[index%imgs.length].getImage(), 0, 0,this);
            index++;
        }
    }

    /*每5秒图片轮播一次*/
    static class Thread1 implements Runnable{
        @Override
        public void run() {
            while (true) {
                mp.repaint();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*播放音乐*/
    static class Thread2 implements Runnable{
        @Override
        public void run() {
            playMusic();
        }
    }

    static void playMusic(){//背景音乐播放
        try {
            URL cb;
            File f = new File("D:\\你的答案.mp3"); // 引号里面的是音乐文件所在的路径
            cb = f.toURI().toURL();
            System.out.println(cb);
            AudioClip aau = null;
            aau = Applet.newAudioClip(cb);
            aau.play();
            /*aau.loop();//循环播放
            // 循环播放 aau.play()
            //单曲 aau.stop()停止播放*/
            System.out.println("可以播放");

        } catch (MalformedURLException e) {

            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        JFrameTest frame = new JFrameTest();

    }
}
