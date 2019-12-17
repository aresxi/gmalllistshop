package com.atguigu.day10;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class  Cache{
  private volatile  Map<String,String> map =new HashMap<>();
  //private Lock lock =new ReentrantLock();
  ReentrantReadWriteLock rwl= new ReentrantReadWriteLock();
  public  void put(String key, String value){
      rwl.writeLock().lock();
      try{
          System.out.println(Thread.currentThread().getName()+"\t"+"写入操作");
          map.put(key, value);
          System.out.println(Thread.currentThread().getName()+"\t"+"写入结束");
      }catch(Exception e){
      e.printStackTrace();
      }finally{
          rwl.writeLock().unlock();
      }
    }
    public  void get(String key){
      rwl.readLock().lock();
      try{
          System.out.println(Thread.currentThread().getName()+"\t"+"读操作");
          String result= map.get(key);
          System.out.println(Thread.currentThread().getName()+"\t"+"读结束"+result);
      }catch(Exception e){
      e.printStackTrace();
      }finally{
          rwl.readLock().unlock();
      }
    }

}
public class ReadWriteLock {
    public static void main(String[] args) {
        Cache cache= new Cache();
        for (int i = 0; i <=10 ; i++) {
            final  int templ=i;
            new Thread(()->{
               cache.put(templ+"",templ+"");
            },String.valueOf(i)).start();
        }
        for (int i = 0; i <=10 ; i++) {
            final  int templ=i;
            new Thread(()->{
                cache.get(templ+"");
            },String.valueOf(i)).start();
        }
    }
}
