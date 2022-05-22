package com.huawei.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Graph {
    int[][] edge;
    List<String> vertextlist;
    private int numofegges;
    boolean[] isvisited;
    public static void main(String[]args){
        int n=5;
        Graph graph=new Graph(5);
        String[] vertex={"A","B","C","D","E"};
        for(String ver:vertex){
            graph.insertVertex(ver);
        }
        graph.addEdges(0,1,1);//a-b
        graph.addEdges(0,2,1);//a-c
        graph.addEdges(1,2,1);//b-c
        graph.addEdges(1,3,1);//b-d
        graph.addEdges(1,4,1);//b-e
        graph.getArr();
    }
    public Graph(int n){
        edge=new int[n][n];
        vertextlist =new ArrayList<String>(n);
        numofegges=0;
        isvisited=new boolean[5];

    }
    //获取第一个邻节点
    public int getFirstNeightbor(int index){
        for(int i=0;i<vertextlist.size();i++){
            if(edge[index][i]>0){
                return i;
            }
        }
        return -1;
    }
    //根据前一个节点继续获取下一个节点
    public int getNextNeightbor(int v1,int v2){
        for(int i=v2+1;i<vertextlist.size();i++){
            if(edge[v1][i]>0){
                return i;
            }
        }
        return -1;
    }
    //深度优先遍历
    public void dfs(boolean[] isvisited,int i){
        System.out.println(getValueByindex(i)+"->");
        isvisited[i]=true;
        int w=getFirstNeightbor(i);
        while(w!=-1){
            if(!isvisited[w]){
                dfs(isvisited,w);
            }
            w=getNextNeightbor(i,w);
        }
    }
    public void dfs(){
        for(int i=0;i<getVertexNumbers();i++){
            if(!isvisited[i]){
                dfs(isvisited,i);
            }
        }
    }
    //广度有限遍历
    public void bfs(boolean[] isvisited,int i){
        int u;
        int w;
        LinkedList queue=new LinkedList();
        System.out.println(getValueByindex(i));
        isvisited[i]=true;
        queue.addLast(i);
        while(!queue.isEmpty()){
            u=(Integer)queue.removeFirst();
            w=getFirstNeightbor(u);
            while(w!=-1){
                if(!isvisited[w]){
                    System.out.println(getValueByindex(w));
                    isvisited[w]=true;
                    queue.addLast(w);
                }
                w=getNextNeightbor(u,w);
            }
        }

    }
    //广度优先遍历
    public void bfs(){
        for(int i=0;i<getVertexNumbers();i++){
            if(!isvisited[i]){
                bfs(isvisited,i);
            }
        }
    }
    //插入一个节点
    public  void insertVertex(String vertex){
        vertextlist.add(vertex);
    }

    /**
     *
     * @param v1 为节点的下标
     * @param v2 为节点的下标
     * @param weight 为节点的权重
     */
    //添加一个边
    public void addEdges(int v1,int v2,int weight){
        edge[v1][v2]=weight;
        edge[v2][v1]=weight;
        numofegges++;
    }
    //获取节点数
    public int getVertexNumbers(){
        return vertextlist.size();
    }
    //获取边
    public int getEdges(){
        return numofegges;
    }
    //根据下标获取权值
    public String getValueByindex(int i){
        return vertextlist.get(i);
    }
    //获取权值
    public int getWeight(int v1,int v2){
        return edge[v1][v2];
    }
    //获取二维数组
    public void getArr(){
        for(int[] link:edge){
            System.out.println(Arrays.toString(link));
        }
    }
}
