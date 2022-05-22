package com.atguigu.sharedata;

import java.util.Currency;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//打印A:12345 B12345678910 c:12345...
public class ResourceDemon {
    public static void main(String[]args){
        Resource resource=new Resource();
        new Thread(()->{
            resource.print5();
        },"A").start();

        new Thread(()->{
            resource.print10();
        },"B").start();

        new Thread(()->{
            resource.print15();
        },"C").start();
    }
}

class Resource{
    private int number=1;//A线程表示1，B线程表示2，C线程表示3

    private Lock lock=new ReentrantLock();
    Condition c1=lock.newCondition();
    Condition c2=lock.newCondition();
    Condition c3=lock.newCondition();

    public void print5(){
        lock.lock();
        try{
            while(number!=1){//若果不是A线程，则需要等待
                c1.await();
            }
            //若是A线程则开始打印
            for(int i=0;i<5;i++){
                System.out.println(i);
            }
            //打印结束后，改变number=2
            number=2;
            //唤醒线程B
            c2.signal();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print10(){
        lock.lock();
        try{
            while(number!=2){//若果不是B线程，则需要等待
                c2.await();
            }
            //若是A线程则开始打印
            for(int i=0;i<10;i++){
                System.out.println(i);
            }
            //打印结束后，改变number=3
            number=3;
            //唤醒线程C
            c3.signal();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void print15(){
        lock.lock();
        try{
            while(number!=3){//若果不是C线程，则需要等待
                c3.await();
            }
            //若是A线程则开始打印
            for(int i=0;i<15;i++){
                System.out.println(i);
            }
            //打印结束后，改变number=1
            number=1;
            //唤醒线程A
            c1.signal();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
