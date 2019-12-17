package com.atguigu.day10;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class  MyThread  implements Callable<Integer> {
//futureTask.get方法获得 callable 线程处理后台处理业务逻辑返回的结果集
    @Override
    public Integer call() throws Exception {
        System.out.println("********欢迎 call");
        return 666;
    }
}
public class CallableDemo {
    public static void main(String[] args) throws  InterruptedException,ExecutionException{
       // FutureTask futureTask = new FutureTask(new  MyThread());
        FutureTask futureTask = new FutureTask(new MyThread());
        new Thread(futureTask, "A").start();
        System.out.println(futureTask.get());
    }
}
