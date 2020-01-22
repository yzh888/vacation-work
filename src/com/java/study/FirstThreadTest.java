package com.java.study;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author zhy
 * @create 2020/1/23
 * @description TODO
 */
public class FirstThreadTest extends Thread{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SubThread st = new SubThread();
        SecondThreadTest st2 = new SecondThreadTest();
        CallableImpl callable = new CallableImpl();
        FutureTask<Integer> task = new FutureTask<>(callable);
        new Thread(task).start();
        /*调用get方法则阻塞主线程*/
        System.out.println("子线程的返回值：" + task.get());
        st2.run();
        st.start();
    }
/*
 *  定义子类,继承Thread
 *  重写方法run
 */
    public static class SubThread  extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("输出" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
    public static class SecondThreadTest implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i < 11; i++) {
                System.out.println("输出：" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /*继承callable接口*/
    public static class CallableImpl implements Callable<Integer> {

        public Integer call() throws Exception {
            System.out.println("当前线程名——" + Thread.currentThread().getName());
            int i = 0;
            for (; i < 5; i++) {
                System.out.println("循环变量i的值：" + i);
                /*任务阻塞一秒*/
                Thread.sleep(1000);
            }
            return i;
        }
    }
}
