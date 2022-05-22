package com.huawei.threadLock;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Threadlock {
    public static void main(String[]args){
        ThreadLockA threadLockA=new ThreadLockA();
        ThreadLockA threadLockB=new ThreadLockA();
        new Thread(()->{
            try {
                threadLockA.A();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            threadLockB.B();
        }).start();
//        new Thread(()->{
//            threadLockA.C();
//        }).start();
    }
}
class ThreadLockA{
    public static synchronized  void A() throws InterruptedException {
        sleep(1);
        System.out.println("1");
    }
    public static synchronized  void B(){
        System.out.println("2");
    }

    public void C(){
        System.out.println("3");
    }
}




