package com.huawei.algorithm;

public class BubbleSort {
    public static void main(String[]args){
        int arr[]={1,3,73,2,35,65,32};

        int temp=0;
        boolean flag=false;
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    flag=true;
                    temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
            if(!flag){
                break;
            }else{
                flag=false;
            }
        }
    }
    public void selectSort(){
        int arr[]={1,32,42,2,21,235,3,6,7};
        for(int i=0;i<arr.length-1;i++){
            //假设最小索引为0
            int minIndex=i;
            //假设最小值为索引为0的值
            int min=arr[i];
            for(int j=i+1;j<arr.length-1;j++){
                if(min>arr[j]){//若果min不是最小的值，还存在比min大的值
                    min=arr[j];
                    minIndex=j;
                }
                if(minIndex!=i){
                    arr[minIndex]=arr[i];
                    arr[i]=min;
                }
            }
        }

    }
}
