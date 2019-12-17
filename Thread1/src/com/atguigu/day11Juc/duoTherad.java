package com.atguigu.day11Juc;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket{
    //把变量和方法封装在对象里面
    private int numbs=30;
    private Lock lock =new ReentrantLock();
    public void sole(){
        lock.lock();
        try {
            if (numbs>0){
                System.out.println(Thread.currentThread().getName()+"当前卖出第："+(numbs--)+"票，还剩下"+numbs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class duoTherad {
    public static void  main (String[]args) {

        // Thread(Runnable target, String name)分配一个新的 Thread对象。

        Ticket ticket =new Ticket();
//        new Thread(()->{ for (int i = 1; i <= 35; i++) ticket.sole();}, "Z").start();
//        new Thread(()->{ for (int i = 1; i <= 35; i++) ticket.sole();}, "X").start();
//        new Thread(()->{ for (int i = 1; i <= 35; i++) ticket.sole();}, "V").start();
        ExecutorService threadpool = Executors.newFixedThreadPool(3);
        try{
            for (int i = 1; i <=30 ; i++) {
              threadpool.execute(()->{ticket.sole();});
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            threadpool.shutdown();
        }
//       new Thread(new Runnable() {
//           @Override
//           public void run() {
//               for (int i = 1; i <= 35; i++) {
//                   ticket.sole();
//               }
//           }
//       }, "A").start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 1; i <= 35; i++) {
//                    ticket.sole();
//                }
//            }
//        }, "B").start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 1; i <= 35; i++) {
//                    ticket.sole();
//                }
//            }
//        }, "C").start();
        //List<String> list =new CopyOnWriteArrayList<>();
    }
}

