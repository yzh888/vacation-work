package com.java.study;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimedTask {

    public void ThreadMenthd(){
        // 每一秒钟执行一次
        final long timeInterval = 10000;
        Runnable runnable = new Runnable() {
            public void run() {
                while (true) {
                    // ------- 要运行的任务代码
                    System.out.println("10秒之后出现闹钟提醒");
                    try {
                        // sleep()：同步延迟数据，并且会阻塞线程
                        Thread.sleep(timeInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("叮叮叮！！！");
                }
            }
        };
        //创建定时器
        Thread thread = new Thread(runnable);
        //开始执行
        thread.start();
    }

    public void TimerTask(){
        /**
         * Timer：是一个定时器工具，用来执行指定任务
         * TimerTask：是一个抽象类，他的子类可以代表一个被Timer计划的任务
         */
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // 执行的输出的内容
                System.out.println("定时任务");
            }
        };
        Timer timer = new Timer();
        // 定义开始等待时间  --- 等待 5 秒
        long delay = 5000;
        // 定义每次执行的间隔时间
        long intevalPeriod = 5 * 1000;
        // 安排任务在一段时间内运行
        timer.scheduleAtFixedRate(task, delay, intevalPeriod);
        timer.cancel();
    }

    public void task3(){
        /**
         * Runnable：实现了Runnable接口
         */
        Runnable runnable = new Runnable() {
            //创建 run 方法
            public void run() {
                // task to run goes here
                System.out.println("闹钟响了，该起床啦！！！");
            }
        };
        // 做为并发工具类被引进的，这是最理想的定时任务实现方式。
        ScheduledExecutorService service = Executors
                .newSingleThreadScheduledExecutor();
        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
        // 第一次执行的时间为10秒，然后每隔五秒执行一次
        service.scheduleAtFixedRate(runnable, 10, 5, TimeUnit.SECONDS);

    }

    public static void main(String[] args) {
        TimedTask task = new TimedTask();
        task.task3();
        task.ThreadMenthd();
    }
}
