package com.lintao.algorithm;

public class Sparsarr {
    public static void main(String[]args){
        //创建原始的二维数组11*11
        int arr[][]=new int[11][11];
        arr[0][1]=1;
        arr[1][2]=2;
        //循环遍历二维数组
        for(int[] row :arr){
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //遍历二维数组
        int sum=0;
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if(arr[i][j]!=0){
                    sum++;
                }
            }
        }
        //创建稀疏数组
        int sparsarr[][]=new int[sum+1][3];
        sparsarr[0][0]=11;
        sparsarr[0][1]=11;
        sparsarr[0][2]=sum;

        //在此遍历稀疏数组
        int count=0;
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if(arr[i][j]!=0){
                    count++;
                    sparsarr[count][0]=i;//稀疏数组中第一列表示的是二维数组中的行数
                    sparsarr[count][1]=j;//稀疏数组中的第二列表示的是二维数组中的列值
                    sparsarr[count][2]=sparsarr[i][j];//稀疏数组中的第三列表示的是二维数组中的数值
                }
            }
        }
        //将稀疏数组转化为二维数组
        //创建二维数组
        int chessarr2[][]=new int[sparsarr[0][0]][sparsarr[0][1]];
        for(int i=0;i<sparsarr.length;i++){
            //二维数组中行数就是稀疏数组第一列的值，二维数组中的列数就是稀疏数组第二列值，
            // 二维数组中的数值便是稀疏数组的第三列的值
            chessarr2[sparsarr[i][0]][sparsarr[i][1]]=sparsarr[i][2];
        }

    }
}
