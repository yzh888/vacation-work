package com.java.study;

/**
 * @author zhy
 * @create 2020/1/21
 * @description TODO
 */
public class Max {
    private static int max;
    public int getMax(int a, int b){
        max = Math.max(a,b);
        return max;
    }

    public void print(){
        System.out.println("最大值=" + max);
    }
}
