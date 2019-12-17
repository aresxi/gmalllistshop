package com.atguigu.day11Juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {


    public static void main(String[] args) {
        //线程池三个小用法
       // ExecutorService threadPool = Executors.newFixedThreadPool(3);//一池多固定线程
      //  ExecutorService threadPool = Executors.newSingleThreadExecutor(); //一池1线程
        ExecutorService threadPool = Executors.newCachedThreadPool();//一池N线程
        //自定义线程用法
//    ExecutorService threadPool = new ThreadPoolExecutor(
//
//    );
        //一个银行已经new好了五个受理窗口，有5个工作人员
//        try{
//            //一池5个工作人员(银行受理窗口),模拟20个客户(request)来银行实体店办理业务。
//            for (int i = 1; i <=20 ; i++) {
//                final int tem=i;
//            threadPool.execute(()->{
//             System.out.println(Thread.currentThread().getName()+"\t"+"办理业务"+"客户号是"+tem);
//         });
//            }
//        }catch(Exception e){
//        e.printStackTrace();
//        }finally{
//            threadPool.shutdown();
//        }
        //2.
        try{
            for (int i = 1; i <20 ; i++) {
                final  int tem=i;
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t办理业务"+"  客户号是"+tem);
                });
            }
        }catch(Exception e){
        e.printStackTrace();
        }finally{
            threadPool.shutdown();
        }
    }
}
