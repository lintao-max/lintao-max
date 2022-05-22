package com.huawei.algorithm2;

import java.util.Arrays;

/**
 * 弗洛伊德算法--找最小生成树
 */
public class Fuluoy {
    public static void main(String[]args){

    }
}
class Graph1{
    private char[] vertix;
    private int[][] dis;
    private int[][] pre;

    public Graph1(int length,int[][]dis,char[] vertix){
        this.dis=dis;
        this.vertix=vertix;
        this.pre=new int[length][length];
        for(int i=0;i<length;i++){
            Arrays.fill(pre[i],i);
        }
    }
    //展示
    public void show(){
        char[] vertix={'A','B','C','D','E','F','G'};
        for(int k=0;k< dis.length;k++){
            for(int i=0;i< dis.length;i++){
                System.out.print(pre[i][k]);
            }

            for(int j=0;j< dis.length;j++){
                System.out.print(vertix[k]+"---->"+vertix[j]+"---->"+dis[k][j]);
            }
        }

    }
    //算法核心
    public void flody(){
        int len=0;
        for(int k=0;k<dis.length;k++){//找出中节点
            for(int i=0;i<dis.length;i++){
                for(int j=0;j<dis.length;j++){
                   len=dis[i][k]+dis[k][j];
                   if(len<dis[i][j]){
                       dis[i][j]=len;
                       pre[i][j]=pre[k][j];
                   }
                }
            }

        }
    }

}