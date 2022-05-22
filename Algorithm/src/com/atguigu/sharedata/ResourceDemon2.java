package com.atguigu.sharedata;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ResourceDemon2 {
    public static void mian(String[]args) throws InterruptedException {
        BlockingQueue<String> arrayBlockingQueue=new ArrayBlockingQueue<>(10);
        Resources2 resources2=new Resources2(arrayBlockingQueue);
        new Thread(()->{
            try{
                resources2.product();
            }catch(Exception e){
                e.printStackTrace();
            }finally {

            }
        },"生产者").start();
        new Thread(()->{
            try{
                resources2.consumner();
            }catch(Exception e){
                e.printStackTrace();
            }finally {

            }
        },"消费者").start();
        TimeUnit.SECONDS.sleep(2);
        resources2.stop();
    }

}
class Resources2{
    //设置标识符号，因为必须在多线程环境下，保持可见性
    private volatile boolean flag=true;
    //原子整型
    AtomicInteger atomicInteger=new AtomicInteger();
    //获取阻塞队列
    private BlockingQueue<String> blockingQueue;

    public Resources2(BlockingQueue<String> blockingQueue){
        this.blockingQueue=blockingQueue;
    }
    public void product() throws InterruptedException {
        String data=null;
        boolean resFlag;
        while(flag){
            data=atomicInteger.incrementAndGet()+"";
            resFlag=this.blockingQueue.offer(data,2,TimeUnit.SECONDS);
            if(resFlag){
                System.out.println("数据插入队列成功");
            }else{
                System.out.println("数据插入失败");
            }
            TimeUnit.SECONDS.sleep(2);
        }
        System.out.println("生产停止=====》");
    }

    public void consumner() throws InterruptedException {
        String result=null;
        while(flag){
            result=blockingQueue.poll(2,TimeUnit.SECONDS);
            if(result==null||result.equalsIgnoreCase("")){
                //没有数据可以消费，需要更改标识
                flag=false;
                TimeUnit.SECONDS.sleep(2);
                return;
            }
            System.out.println("消费成功");
        }
    }

    public void stop(){
        this.flag=false;//改变标识，表示停止
    }

}
