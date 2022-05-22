package com.lintao.quern8;

public class Quern8 {
    //创建一个8位数组
    int array[]=new int[8];
    public static void main(String[]args){

    }
    //检查
    public void put(int n){
        if(n==8){
            prinf();
            return;
        }
        for(int i=0;i<n;i++){
            array[n]=i;//首先尝试放进去，再做判断
            if(judge(n)){ //判断OK的情况，再继续放
                put(n+1);
            }
        }

    }

    //判断
    public boolean judge(int n){
        for(int i=0;i<n;i++){
            //array[i]==array[n] 判断是不是在同一列
            //Math.abs(n-i)==Math.abs(array[n]-array[i]) 判断是不是在同一斜线上
            if(array[i]==array[n]||Math.abs(n-i)==Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }
    //打印
    public void prinf(){
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]+"");
        }
        System.out.println();
    }
}
