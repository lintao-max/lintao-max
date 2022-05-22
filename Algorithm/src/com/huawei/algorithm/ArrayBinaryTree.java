package com.huawei.algorithm;

public class ArrayBinaryTree {
    public static void main(String[] args) {
        int[]arr={1,2,3,4,56,6,7,9};
        ArrayBinary arrayBinary=new ArrayBinary(arr);
        arrayBinary.binaryTree(0);
    }
}
class ArrayBinary{
    private int[] arr;
    public ArrayBinary(int[]arr){
        this.arr=arr;
    }
    public  void binaryTree(int index){
        if(arr==null||arr.length==0){
            System.out.println("数组为空，不能遍历");
        }
        System.out.println(arr[index]);//输出这个节点
        if((index*2+1)<arr.length){
            binaryTree(index*2+1);
        }
        if((index*2+2)< arr.length){
            binaryTree(index*2+2);
        }
    }

}
