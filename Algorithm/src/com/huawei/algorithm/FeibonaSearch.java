package com.huawei.algorithm;

import java.util.Arrays;

public class FeibonaSearch {
    public static void main(String[] args) {
        int[] arr = {83, 2, 5, 3, 4, 67, 13, 45, 14};
    }

    public static int[] fib() {
        int f[] = new int[20];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < f.length - 1; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    public static int getSearch(int[]arr,int key){
        int low=0;
        int mid=0;
        int k=0;
        int heigh=arr.length-1;
        int f[]=fib();
        while(heigh>f[k]-1){
            k++;
        }
        int[] temp= Arrays.copyOf(arr,f[k]);
        for(int i=heigh+1;i<temp.length;i++){
            temp[i]=arr[heigh];
        }
        while(low<=heigh){
            mid=low+f[k-1]-1;
            if(key<temp[mid]){
                heigh=mid-1;
                k--;
            }else if(key>temp[mid]){
                low=mid+1;
                k-=2;
            }else{
                if(mid<=heigh){
                    return mid;
                }else{
                    return heigh;
                }
            }
        }
        return -1;
    }
}