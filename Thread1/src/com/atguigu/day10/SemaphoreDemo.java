package com.atguigu.day10;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
    //多个线程抢多个资源：停车场抢车位
    /**
    在信号量上我们定义两种操作：
     * acquire（获取） 当一个线程调用acquire操作时，它要么通过成功获取信号量（信号量减1），
     *       要么一直等下去，直到有线程释放信号量，或超时。
     * release（释放）实际上会将信号量的值加1，然后唤醒等待的线程。
     *
     * 信号量主要用于两个目的，一个是用于多个共享资源的互斥使用，另一个用于并发线程数的控制。
     */
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);//模拟三个车位
        for (int i = 1; i <=6 ; i++)//模拟6部汽车
            new Thread(() -> {
                boolean flag = false;//标志位，说明我还没有抢到这个车位
                try {
                    //获取或者占有
                    semaphore.acquire();
                    flag = true;// 说明我抢到车位 占有是为true
                    System.out.println(Thread.currentThread().getName() + "\t" + "抢到车位");
                    //停几秒
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "\t" + "离开车位");
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if(flag ==true){
                        semaphore.release();
                    }
                }

            },String.valueOf(i)).start();

    }
}
