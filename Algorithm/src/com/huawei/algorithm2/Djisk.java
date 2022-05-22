package com.huawei.algorithm2;

import java.util.Arrays;

/**
 * 迪杰斯特拉算法
 *
 */
public class Djisk {
    public static void main(String[]args){

    }
}
//创建图
class Graphdata{
    //图里面的顶点个数
    private char[] vertix;
    private int[][] matrix;
    VisitedVertix vi;
    public Graphdata(char[] vertix,int[][] matrix){
        this.vertix=vertix;
        this.matrix=matrix;

    }

    public void showGraph(){
        for(int[] link:matrix){
            System.out.print(Arrays.toString(link));
        }
    }
    public void djs(int index){
        vi=new VisitedVertix(vertix.length,index);

    }
    //更新当前节点作为下一个节点的前驱，更新出发点到当前节点的距离
    public void update(int index){
        int len=0;
        for(int i=0;i<matrix.length;i++){
            len=vi.getDis(index)+matrix[index][i];
            if(!vi.in(index) && len<vi.getDis(index)){
                vi.updatePre(i,index);//更新index作为i的前驱
                vi.updateDis(i,len);//更新出发顶点到i节点的最短路径
            }
        }
    }

}
class VisitedVertix{
    private int[] arr_visited;//已访问的节点集合
    private int[] pre_vertix;//前驱节点集合
    private int[] dis;//出发点到当前节点的集合

    public VisitedVertix(int length,int index){
        this.arr_visited=new int[length];
        this.pre_vertix=new int[length];
        this.dis=new int[length];
        //初始化dis，最开始里面数据全为65535；
        Arrays.fill(dis,65536);
        //对出发这个点进行设置已访问
        arr_visited[index]=1;
        this.dis[index]=0;//设置出发点的距离为0
    }
    //判断当前的节点是否被访问过
    public boolean in(int index){
        return arr_visited[index]==1;//1 表示为访问，0 表示为没有访问
    }
    //更新出发点到当前节点的距离
    public void updateDis(int index,int len){
        dis[index]=len;
    }
    //更新前驱节点
    public void  updatePre(int pre,int index){
        pre_vertix[pre]=index;//将当前节点设置为下一个节点的前驱
    }
    //获取出发点到当前节点的距离
    public int  getDis(int index){
        return dis[index];
    }
    //跟新下一个节点
    public int updateArr(){
        int min=65535;
        int index=0;
        for(int i=0;i<arr_visited.length;i++){
            if(arr_visited[i]!=0 && dis[index]<min){
                min=dis[index];
                index=i;
            }
        }
        arr_visited[index]=1;
        return index;
    }

}
