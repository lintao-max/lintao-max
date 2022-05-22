package com.huawei.algorithm;

/**
 * 插值查找算法
 */
public class insertArithSearch {
    public static void main(String[]args){
        int[] arr=new int[100];
        for(int i=0;i<100;i++){
            arr[i]=i+1;
        }
    }
    //二分查找算法必须前提是有序的
    public static int insertSearch(int[]arr,int left,int right,int findvalue){
        if(left>right||findvalue<arr[0]||findvalue>arr[arr.length-1]){
            return -1;
        }
        int mid=left+(right-left)*(findvalue-arr[left])/arr[right]-arr[left];
        int midValue=arr[mid];
        if(findvalue<midValue){
            return insertSearch(arr,left,mid-1,findvalue);
        }else if(findvalue>midValue){
            return insertSearch(arr,mid+1,right,findvalue);
        }else{
            return mid;
        }
    }
}
