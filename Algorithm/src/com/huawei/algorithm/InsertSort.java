package com.huawei.algorithm;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[]args){

    }

    public static void insertSort(){
        int arr[]={112,34,56,113,116};
        //设置索引下表为1的值,也就是即将插入的数值--34
        for(int i=1;i<arr.length;i++){
            int indexValue=arr[i];
            int index=i-1;//设置即将插入数据的前一个索引
            /**
             * index>=0 防止指针越界
             * indexValue<arr[index] 表示即将插入的数据小于前面的数值，说明位置没有找到
             */
            while(index>=0 && indexValue<arr[index]){
                arr[index+1]=arr[index];//将前面大的值交换到后面去
                index--;//这是将移到插入的数据的位置
            }
            if(index+1!=i){
                arr[index+1]=indexValue;//若果找到了位置，则指针后移赋值
            }
        }
    }
}
