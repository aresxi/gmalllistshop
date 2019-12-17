package com.atguigu.xc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class  Airconditioner{

    //现在有两个线程 可以操作资源类为0的一个变量
    private int numbs=0;//资源类
    private Lock lock = new ReentrantLock();
    private Condition condition =lock.newCondition();
    public void increment() throws InterruptedException {
        lock.lock();
        //1判断
        try {
            while (numbs != 0){
             condition.await();
             //this.wait();
            }
            //2干活
            ++numbs;
            System.out.println(Thread.currentThread().getName()+"     "+numbs);
            //  System.out.println("现在我要进行生产者模式"+numbs);
            //3通知
            condition.signalAll();
            //this.notifyAll();//将其他等待的线程唤醒，自动释放锁和线程给其他线程
            //当一个线程notify了之后，自动释放锁以及控制权给其他线程调度
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }
    public  void decrement() throws InterruptedException {
        lock.lock();
        //1判断
        try {
            while (numbs == 0){
                condition.await();//this.wait();
            }
            //2干活
            --numbs;
            System.out.println(Thread.currentThread().getName()+"     "+numbs);
            // System.out.println("现在我要进行消费者模式"+numbs);
            //3通知
            condition.signalAll();
            //this.notifyAll();//将其他等待的线程唤醒，自动释放锁和线程给其他线程
            //当一个线程notify了之后，自动释放锁以及控制权给其他线程调度
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
        }

public class whatNotify {
    public static void main(String[] args) {
        Airconditioner airconditioner =new Airconditioner();
        new Thread(()->{
            for (int i = 0; i <=10 ; i++) {
                try {
                    airconditioner.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(()->{
            for (int i = 0; i <=10 ; i++) {
                try {
                    airconditioner.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
        new Thread(()->{
            for (int i = 0; i <=10 ; i++) {
                try {
                    airconditioner.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();
        new Thread(()->{
            for (int i = 0; i <=10 ; i++) {
                try {
                    airconditioner.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();


    }
}
