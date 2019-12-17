package com.atguigu.day10;

import java.util.concurrent.CountDownLatch;

public class CountDwon {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 1; i <=5; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t离开教室");
                countDownLatch.countDown();//相当于--的操做
            },String.valueOf(i)).start();
        }
        countDownLatch.await();//教室里面的人没有走完，就不允许main线程走，堵塞 ，直到为0，才可以走，锁门
        System.out.println(Thread.currentThread().getName()+"\t班长离开教室锁门");
    }
}
