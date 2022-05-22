package com.huawei.algorithm;

import java.util.ArrayList;

/**
 * 线性查找/二分查找
 */
public class SelectElement {
    public static void main(String[]args){
        int arr[]={1,4,25,6};
        selectValue(arr,2);
    }
    public static int selectValue(int[] arr,int value){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==value){
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @param arr 要求数组必须为有序
     * @param left
     * @param right
     * @param findValue
     */
    public static int selectBinary(int[] arr,int left,int right,int findValue){
        if(left>right){
            return -1;
        }
        int mid=(left+right)/2;
        int minValue=arr[mid];
        if(findValue<minValue){
            return selectBinary(arr,left,mid,findValue);
        }else if(findValue>minValue){
            return selectBinary(arr,mid+1,right,findValue);
        }else{
            return mid;
        }
    }
    //升级版
    public static ArrayList<Integer> selectBinary2(int[] arr, int left, int right, int findValue){
        if(left>right){
            return new ArrayList<>();
        }
        int mid=(left+right)/2;
        int minValue=arr[mid];
        if(findValue<minValue){
            return selectBinary2(arr,left,mid,findValue);
        }else if(findValue>minValue){
            return selectBinary2(arr,mid+1,right,findValue);
        }else{
            //return mid;
            ArrayList<Integer>  list=new ArrayList<Integer>();
            int temp=mid-1;
            while(true){
                if(temp<0||arr[temp]!=findValue){
                    break;
                }
                list.add(temp);
                temp-=1;
            }
            list.add(mid);
            temp=mid+1;
            while(true){
                if(temp>arr.length-1||arr[temp]!=findValue){
                    break;
                }
                list.add(temp);
                temp+=1;
            }
            return list;

        }
    }

}
