package com.huawei.algorithm;
public class HeapSort {
    public static void main(String[]args){

    }
    public static void heapSort(int[]arr){
       // adjustHeap(arr,1,arr.length);//第一次调整
        //adjustHeap(arr,0,arr.length);//第二次调整
        for(int i= arr.length/2-1;i>=0;i--){
            adjustHeap(arr,i, arr.length);
        }
        //对已经调整的堆再一次调整，使得最大的元素沉到数组末端
        for(int j=arr.length-1;j>0;j--){
            int temp=arr[j];
            arr[j]=arr[0];//此时0指定的是最大的值
            arr[0]=temp;
            adjustHeap(arr,0,j);
        }
    }
    public static void adjustHeap(int[]arr,int i,int length){
        int temp=arr[i];//获取第i个节点
        for(int k=i*2+1;k<length;k=k*2+1){
            if(k+1<length && arr[k]< arr[k+1]){
                k++;//若谷左子节点小于右子节点，指针右移动致右子节点
            }
            if(arr[k]>temp){//此时如果右子节点大于之前的保存的节点的值
                arr[i]=arr[k];//把右节点值赋予给第i个节点
                i=k;//把指针指向k
            }else{
                break;//如果右子树节点小于临时节点，则break
            }
        }
        arr[i]=temp;//退出循环后，把临时节点赋给已经更改的右子树
    }
}
