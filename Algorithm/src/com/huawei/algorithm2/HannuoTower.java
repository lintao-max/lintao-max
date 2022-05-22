package com.huawei.algorithm2;

public class HannuoTower {
    public static void main(String[]args){
        hannuoTower(5,'A','B','C');
    }
    public static void hannuoTower(int num,char a,char b,char c ){
        if(num==1){
            System.out.println("第一个盘从"+a+"->"+c);
        }else{
            hannuoTower(num-1,a,c,b);
            System.out.println("第"+num+"个盘"+a+"->"+b);
            hannuoTower(num-1,b,a,c);
        }
    }
}
