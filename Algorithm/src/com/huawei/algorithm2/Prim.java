package com.huawei.algorithm2;

import java.util.Arrays;

/**
 * 普利姆算法，从一个顶点到其他各个顶点的最短路径
 * 最小生成树
 */
public class Prim
{
    public static void main(String[]args){

    }
}
class Mintree{
    //创建树
    public void createMinTree(Graph graph,int vertix,char[] data,int[][]weight){
        for(int i=0;i<vertix;i++){
            graph.data[i]=data[i];
            for(int j=0;j<vertix;j++){
                graph.weight[i][j]=weight[i][j];
            }

        }
    }
    //打印
    public void print(Graph graph){
        for(int[] link:graph.weight){
            System.out.print(Arrays.toString(link));
        }
    }

    /**
     *
     * @param graph 节点的二维图
     * @param v 定义某个顶点
     */
    public void prim(Graph graph,int v){
        int[] visited=new int[graph.vertix];
        visited[v]=1;//表示第v个节点被标识访问过
        int h1=-1;
        int h2=-1;
        int minWeight=10000;
        for(int k=1;k<graph.vertix;k++){//查找边数，意思就是多少条边
            for(int i=0;i<graph.vertix;i++){
                for(int j=0;j<graph.vertix;j++){
                    if(visited[i]==1 && visited[j]==0 && graph.weight[i][j]<minWeight){
                        minWeight=graph.weight[i][j];
                        h1=i;
                        h2=j;
                    }
                }
            }
            System.out.print("边"+graph.data[h1]+"--->"+graph.data[h2]);
            visited[h2]=1;
            minWeight=10000;
        }
    }
}
//创建图
class Graph{
    int vertix;//一共有多少顶点，也就是节点
    char[] data;//节点里面的数据
    int[][]weight; //定义边的权值
    public Graph(int vertix){
        this.vertix=vertix;
        data=new char[vertix];
        weight=new int[vertix][vertix];
    }
}
