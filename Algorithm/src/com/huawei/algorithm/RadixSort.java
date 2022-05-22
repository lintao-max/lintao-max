package com.huawei.algorithm;

/**
 * 基数排序
 */
public class RadixSort {
    public static void main(String[]args){

    }
    public static void radixSort(int[]arr){
        //创建二维数组
        int[][] blocket=new int[10][arr.length];
        //创建每个桶里面的数组
        int[] blocketElement=new int[10];
        //获取数组arr中最大数，以便获取数位数---》获取循环次数
        int max=arr[0];//假定数组下标为0的数为最大的数
        for(int i=0;i<arr.length;i++){//通过循环获取最大数
            if(arr[i]>max){
                max=arr[i];
            }
        }
        int length=max+"".length();//获取最大数的长度
        for(int s=0;s<length;s++){
            //针对数组arr进行遍历
            for(int j=0,n=0;j<arr.length;j++,n*=10){
                int arrElement=arr[j]/n%10;//计算出的是元素的个位231---1 35---5
                //放入二维数组中第5个桶里 第5位
                blocket[arrElement][blocketElement[arrElement]]=arr[j];
                blocketElement[arrElement]++;//将元素索引下移

            }
            //从桶里获取数据
            int index=0;
            for(int k=0;k<blocketElement.length;k++){
                if(blocketElement[k]!=0){
                    for(int l=0;l<blocketElement[k];l++){
                        arr[index]=blocket[k][l];
                        index++;
                    }
                }
                blocketElement[k]=0;
            }
        }
    }
}
