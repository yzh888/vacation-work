package com.java.study;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import com.google.zxing.qrcode.encoder.QRCode;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;


public class TimerQRCode extends TimerTask {
    static int i = 0;
    @Override
    public void run() {
        /*调用hutool工具的QrCode工具直接生成二维码，第一个参数：url, 第二、三个参数：宽和高，第四个参数生成的地址*/
        QrCodeUtil.generate("http://hutool.cn/",
                300,300, FileUtil.file("d:/qrcode" + i++ +".jpg"));
        System.out.println("正在生成二维码");
        try {
            /*Timer睡眠的时间*/
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        /*实例化Timer*/
        Timer timer = new Timer();
        /*启动timer*/
        timer.schedule(new TimerQRCode(), 1);
        timer.schedule(new TimerQRCode(), 2);
        /*主线程睡眠时间*/
        TimeUnit.SECONDS.sleep(5);
        /*关闭线程*/
        timer.cancel();
    }
}
