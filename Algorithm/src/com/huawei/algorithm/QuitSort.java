package com.huawei.algorithm;

public class QuitSort {
    public static void main(String[]args){
        int arr[]={123,-1,-3,11,23,21,12,231};
    }
    public static void quitSort(int[] arr,int left,int right){
        int l=left;
        int r=right;
        int privot=arr[(left+right)/2];
        int temp=0;
        while(l<r){
            while(arr[l]<privot){
                l+=1;//如果中轴左边的数据<中轴值，则索引向右+1，继续寻找比中轴值大的数据
            }
            while(arr[r]>privot){
                r-=1;//如果中轴的右边值>中轴值，则继续向左寻找
            }
            if(l>r){
                break;//防止左边的指针跑到右边指针去了
            }
            //找到左边的值大于中轴值，则与右边的值交换
            temp=arr[r];
            arr[r]=arr[l];
            arr[l]=temp;
            //如果左边的值==privot
            if(arr[l]==privot){
                r-=1;//若果左边的值==privot,则跳过
            }
            //如果右边的值==privot
            if(arr[r]==privot){
                l+=1;
            }

        }
        if(l==r){
            l+=1;
            r-=1;
        }
        if(left<r){
            quitSort(arr,left,r);
        }
        if(right>l){
            quitSort(arr,l,right);
        }

    }
}
