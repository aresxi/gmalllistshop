package com.atguigu.day11Juc;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class FixedThread {
    public static void main(String[] args) throws InterruptedException {
      // ExecutorService threadPool = Executors.newFixedThreadPool(3);
//        for (int i = 0; i <30 ; i++) {
//            threadPool.execute(()->{
//                System.out.println();
//            });
//        }
        LinkedBlockingQueue bk = new LinkedBlockingQueue(3);
//        System.out.println(bk.add("a"));
//        System.out.println(bk.add("b"));
//        System.out.println(bk.add("c"));
        bk.offer("a",3L, TimeUnit.SECONDS);
        bk.offer("a",3L, TimeUnit.SECONDS);
        bk.offer("a",3L, TimeUnit.SECONDS);
        System.out.println("************111");
        bk.offer("a",5L, TimeUnit.SECONDS);
       // bk.offer("a",3L, TimeUnit.SECONDS);
   //     bk.put("x");


        //System.out.println(bk.add("d"));
//        System.out.println(bk.take());
//        System.out.println(bk.take());
//        System.out.println(bk.take());
//        System.out.println(bk.take());
//        System.out.println("*********22222");



    }
}
