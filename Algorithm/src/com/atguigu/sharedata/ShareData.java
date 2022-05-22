package com.atguigu.sharedata;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者
 */
public class ShareData {
    public static void main(String[]args){
        Data data=new Data();
        new Thread(()->{
            for(int i=0;i<5;i++){
                data.increment();
            }
        }).start();

        new Thread(()->{
            for(int i=0;i<5;i++){
                data.increment();
            }
        }).start();
    }
}
class Data{
    private int number=0;
    private Lock lock=new ReentrantLock();
    Condition condition=lock.newCondition();
    //生产产品
    public void increment(){
        lock.lock();
        try{
            while(number!=0){
                //等待，不生产
                condition.await();
            }
            //开始生产
            number++;
            //唤醒消费者
            condition.signalAll();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    //消费产品
    public void decrement(){
        lock.lock();
        try{
           while(number==0){
               //无产品了，等待生产者生产
               condition.await();
           }
           number--;
           condition.signalAll();//唤醒生产者生产
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
}
