package com.huawei.algorithm2;

/**
 * 背包问题
 */
public class BeibaoProblems {
    public static void main(String[]args){
        //物品重量
        int[] w={1,4,3};
        int[] val={1500,3000,2000};//物品的价值量
        int m=4;
        int n=val.length;
        int[][] v=new int[n+1][m+1];
        int[][] path=new int[n+1][m+1];//记录放入的商品数
        for(int i=0;i<v.length;i++){
            v[i][0]=0;//将第一行设置为0
        }
        for(int i=0;i<v[0].length;i++){
            v[0][i]=0;//将第一列设值为0
        }
        for(int i=1;i<v.length;i++){//跳过第一行
            for(int j=1;j<v[0].length;j++){//跳过第一行
                if(w[j]>j){//如果第j个物品的商品重量>背包的总容量
                    v[i][j]=v[i-1][j];//将上一行的数据设置为单前行
                }else{
                    //v[i][j]=Math.max(v[i-1][j],v[i-1][j-w[j]]+val[i-1]);
                    if(v[i-1][j]<v[i-1][j-w[j]]+val[i-1]){
                        v[i][j]=Math.max(v[i-1][j],v[i-1][j-w[j]]+val[i-1]);
                        path[i][j]=1;
                    }else{
                        v[i][j]=v[i-1][j];
                    }
                }
            }

        }
        int i=path.length-1;
        int j=path[0].length-1;
        while(i>0&&j>0){
            if(path[i][j]==1){
                System.out.printf("输出\n",i);
                j-=w[i-1];
            }
            i--;
        }

    }

}
