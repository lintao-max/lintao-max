package com.lintao.arrqueue;

public class ArrQueue {
}
class Queue{
    int maxsize;
    int front;
    int rear;
    int arr[];

    public  Queue(int maxsize){
        this.maxsize=maxsize;
        front=-1;
        rear=-1;
        arr=new int[maxsize];
    }

    //判断数组是否为空数组
    public boolean isEmpty(){
        return rear==front;
    }
    //判断数组是否满
    public boolean isFull(){
        return rear==maxsize-1;
    }
    //向数组中添加元素
    public void addQueue(int n){
        //判断是数组是否满
        if(isFull()){
            System.out.println("数组已经为满");
            return;
        }
        rear++;
        arr[rear]=n;
    }
    //从数组中获取元素
    public int getQueue(){
        //判断是否是空数组
        if(isEmpty()){
            throw new RuntimeException("数组已空");
        }
        front++;
        return arr[front];
    }

}
class CireQueue{
    int maxsize;
    int rear;
    int front;
    int arr[];

    public CireQueue(int maxsize){
        this.maxsize=maxsize;
        this.arr=new int[maxsize];
    }
    public boolean isEmpty(){
        return rear==front;
    }
    public boolean isFull(){
        return (rear+1)%maxsize==front;
    }
    public void addQueue(int n){
        if (isFull()) {
            System.out.println("数组已经满");
            return;
        }
        arr[rear]=n;
        rear=(rear+1)%maxsize;
    }

    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("数组为空");
        }
        int value=arr[front];
        front=(front+1)%maxsize;
        return value;
    }
    public void showQueue(){
        if(isEmpty()){
            System.out.println("没有数组可以展示");
            return;
        }
        for(int i=front;i<front+size();i++){
            System.out.printf("%d\t",i%maxsize,arr[i%maxsize]);
        }
    }
    public int size(){
        return (rear+maxsize-front)%maxsize;
    }
    public int headQueue(){
        if(isEmpty()){
            System.out.println("数组为空");
        }
        return arr[front];
    }
}
