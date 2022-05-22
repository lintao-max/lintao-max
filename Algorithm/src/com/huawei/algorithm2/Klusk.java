package com.huawei.algorithm2;

/**
 * 克鲁斯卡尔算法
 */
public class Klusk {
    private int endgeNumber;//统计边数
    private char[] vertix;//存放顶点的A,B,C,D,E,F
    private int[][] matrix;//存放的是二阶矩阵
    private final int INF=Integer.MAX_VALUE;
    public static void main(String[]args){

    }
    public Klusk(char[] vertix,int[][] matrix){
        this.vertix=vertix;
        this.matrix=matrix;

        //统计边数
        for(int i=0;i<vertix.length;i++){
            for(int j=i+1;j< vertix.length;j++){
                if(matrix[i][j]!=INF){
                    endgeNumber++;
                }
            }
        }

    }

    //获取这个边数
    public Edata[] getEdges(){
        int index=0;
        Edata edata[]=new Edata[endgeNumber];//用来存放边数的数组
        for(int i=0;i<vertix.length;i++){
            for(int j=i+1;j< vertix.length;j++){
                if(matrix[i][j]!=INF){
                    index++;
                    edata[index]=new Edata(vertix[i],vertix[j],matrix[i][j]);
                }
            }
        }
        return edata;
    }
    //对Edata数组内边按照权值大小排序---冒泡排序
    public void sortEdges(Edata[] edata){
        for(int i=0;i<edata.length;i++){
            for(int j=0;j<edata.length-1-i;j++){
                if(edata[j].weight>edata[j+1].weight){
                    Edata temp=edata[j];
                    edata[j]=edata[j+1];
                    edata[j+1]=temp;
                }
            }
        }
    }
    //核心
    public void kustr(){
        int index=0;
        Edata[] resedata=new Edata[endgeNumber];//保存最小生成树的结果
        int[] ends=new int[endgeNumber];//存放边节点的下一个终点
        Edata[] edges=getEdges();
        sortEdges(edges);
        for(int i=0;i<endgeNumber;i++){
            int p1=getPosition(edges[i].start);//获取边的起始节点
            int p2=getPosition(edges[i].end);//获取边的终点

            int m =getEnd(ends,p1);
            int n=getEnd(ends,p2);
            if(m!=n){
                ends[m]=n;
                resedata[index++]=edges[i];
            }
        }
    }
    //获取边的顶点位置
    public int getPosition(char ch){
        for(int i=0;i< vertix.length;i++){
            if(vertix[i]==ch){
                return i;
            }
        }
        return -1;
    }
    //获取边节点的下一个终点
    public int getEnd(int[] ends,int i){
        while(ends[i]!=0){
            i=ends[i];
        }
        return i;
    }

}

//定义一个边
class Edata{
    char start;//边的起点
    char end;//边的终点
    int weight;//权值
    public Edata(char start,char end,int weight){
        this.start=start;
        this.end=end;
        this.weight=weight;
    }

    @Override
    public String toString() {
        return "Edata{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}
