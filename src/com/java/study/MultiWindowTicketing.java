package com.java.study;

/**
 * @author zh_yan
 * @ClassName MultiWindowTicketing
 * @Description TODO
 * @Date 2020/1/30
 * @Version 1.0
 **/
     /*多线程模拟多窗口售票程序*/
    public class MultiWindowTicketing extends Thread{
        public MultiWindowTicketing(String name) {
            super(name);
        }

        /*票数要使用静态值，才能使多个线程共享*/
        static int tickers=20;
        static Object ob;//指定一个共用对象

        //重写run操作，实现卖票
        @Override
        public void run() {
            while(true){
                /*使用线程同步锁synchronized，保证多个线程按次序卖票*/
                synchronized (MultiWindowTicketing.class) {
                    if(tickers>0){
                        System.out.println(getName()+":卖出了第"+tickers+"张票");
                        tickers--;
                    }else{
                        System.out.println("票卖完了");
                        return;
                    }
                }
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        public static void main(String[] args) {
            /*实例化线程*/
            MultiWindowTicketing station1=new MultiWindowTicketing("窗口一");
            MultiWindowTicketing station2=new MultiWindowTicketing("窗口二");
            MultiWindowTicketing station3=new MultiWindowTicketing("窗口三");
            station1.start();
            station2.start();
            station3.start();
        }

    }