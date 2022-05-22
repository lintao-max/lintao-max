package com.huawei.algorithm;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ShellSort {
    public static void main(String[]args){
        int arr[]={1,2,3};
        AtomicInteger atomicInteger;
        Lock lock=new ReentrantLock();
    }
    //交换法
    public static  void shelSort(int[] arr){
        //第一轮排序
        int temp=0;
        for(int gap=arr.length/2;gap>0;gap/=2){
            for(int i=gap;i<arr.length;i++){
                for(int j=i-gap;j>=0;j-=gap){
                    if(arr[j]>arr[j+gap]){
                        temp=arr[j];
                        arr[j]=arr[j+gap];
                        arr[j+gap]=arr[j];
                    }
                }
            }
        }
    }
    //移位法
    public static void shellSort2(int[]arr){
        for(int gap=arr.length/2;gap>0;gap/=2) {
            for (int i = gap; i < arr.length; i++) {
                int j=i;
                int temp=arr[j];
                if(arr[j]<arr[j-gap]){
                    while(j-gap>0 && temp<arr[j-gap]){
                        arr[j]=arr[j-gap];
                        j-=gap;
                    }
                    arr[j]=temp;
                }
            }
        }
    }
}
