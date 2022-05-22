package com.huawei.algorithm;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[]args){
        int arr[]={3,4,612,3,123,135,67};
        int temp[]=new int[10];

    }

    /**
     *
     * @param arr 需要培训的数组
     * @param left 左边第一个索引下标
     * @param right 右边最后一个索引下标
     * @param temp 临时数组
     */
    public static void mergeSort(int arr[],int left,int right,int temp[]){
        if(left<right){
            int mid=(left+right)/2;//获取变动的中间索引下标
            mergeSort(arr,left,mid,temp);//从中间索引向左递归
            mergeSort(arr,mid,right,temp);//从中间向右递归
            merge(arr,left,mid,right,temp);//合并

        }
    }
    /**
     *
     * @param arr 初始数组
     * @param left 索引最左边的元素
     * @param mid 索引中间元素
     * @param right 索引最右边的元素
     * @param temp 临时的数组
     */
    public static void merge(int arr[],int left,int mid,int right,int[] temp){
        int i=left;
        int j=right;
        int t=0;
        while(i<mid && j<right){ //只要索引<mid j<right
            if(arr[i]<arr[j]){ //如果数组左边的元素<右边的元素，就把数组里的元素转存到临时数组中，同事索引下标右移步
                temp[t]=arr[i];
                t+=1;
                i+=1;
            }else{
                temp[t]=arr[j];////如果数组左边的元素>右边的元素，就把数组里的元素转存到临时数组中，同事索引下标右移步
                t+=1;
                j+=1;
            }

        }
        while(i<mid){//特殊情况，当元素<中间值，如果数组左边还剩余的元素，则必须把剩余的元素转到临时数组中
            temp[t]=arr[i];
            i+=1;
            t+=1;
        }
        while(j<right){//特殊情况，当元素<右边元素，如果数组右边还剩余的元素，则必须把剩余的元素转到临时数组中
            temp[t]=arr[j];
            j+=1;
            t+=1;
        }
        t=0;
        int tempLeft=left;
        while(tempLeft<=right){//如果左边的索引<右边的索引,则把临时数组中的元素转存到 之前的数组中
            arr[tempLeft]=temp[t];
            t+=1;
            tempLeft+=1;
        }
    }
}
