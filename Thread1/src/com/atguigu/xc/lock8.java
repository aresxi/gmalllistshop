package com.atguigu.xc;

class Phone{
public  synchronized  void sendEmail()throws Exception{
    System.out.println("*********Email*********");
}
    public  synchronized  void sendSms()throws Exception{
        System.out.println("*********Sms*********");
    }
}
public class lock8 {
    public static void main(String[] args)throws  Exception {
        Phone phone = new Phone();
 new Thread(()->{
     try {
         phone.sendEmail();
     } catch (Exception e) {
         e.printStackTrace();
     }
 }, "A").start();
    Thread.sleep(300);

        new Thread(()->{
            try {
                phone.sendSms();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "B").start();
    }
}
