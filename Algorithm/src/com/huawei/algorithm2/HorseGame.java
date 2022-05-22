package com.huawei.algorithm2;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 马踏棋盘算法-骑士周游算法
 */
public class HorseGame {
    private static int X;
    private static int Y;
    private static boolean visited[];
    private static boolean finished;//true false
    public static void main(String[]args){

    }

    /**
     *
     * @param chessBoard 棋盘
     * @param row 棋盘行数  --X
     * @param column 棋盘的列数--Y
     * @param step 步数 --初始化为1
     */
    public static void chessBoard(int[][]chessBoard,int row,int column,int step){
        chessBoard[row][column]=step;
        visited[row*X+column]=true;//标记这个点已经被访问
        //获取该节点下一个节点（下一个节点有多个）
        List<Point> list=next(new Point(row,column));
        sort(list);
        if(!list.isEmpty()){//若果该集合中有下一个节点
            //从集合中移除下一个节点
            Point ps=list.remove(0);
            //判断该节点是否被访问过
            if(!visited[ps.y*X+ps.x]){
                chessBoard(chessBoard,ps.y,ps.x,step+1);
            }
        }

        //判断棋盘中棋子是否完成
        if(step<X*Y && !finished){//如果没有完成任务
            chessBoard[row][column]=0;
            visited[row*X+column]=false;
        }else{
            finished=true;
        }
    }

    public static List<Point> next(Point curPoint){
        List<Point> list=new ArrayList<Point>();//用于装当前节点的下一个节点
        Point p1=new Point();
        if((p1.x=curPoint.x-2)>=0 && (p1.y=curPoint.y-1)>=0){
            list.add(new Point(p1));
        }
        if((p1.x=curPoint.x-1)>=0 && (p1.y=curPoint.y-2)>=0){
            list.add(new Point(p1));
        }
        if((p1.x=curPoint.x+1)<=X && (p1.y=curPoint.y-1)>=0){
            list.add(new Point(p1));
        }
        if((p1.x=curPoint.x+2)<=X && (p1.y=curPoint.y-1)>=0){
            list.add(new Point(p1));
        }
        if((p1.x=curPoint.x+2)<=X && (p1.y=curPoint.y+1)<=Y){
            list.add(new Point(p1));
        }
        if((p1.x=curPoint.x+1)<=X && (p1.y=curPoint.y+2)<=Y){
            list.add(new Point(p1));
        }
        if((p1.x=curPoint.x-1)>=0 && (p1.y=curPoint.y+2)<=Y){
            list.add(new Point(p1));
        }
        if((p1.x=curPoint.x-2)>=0 && (p1.y=curPoint.y+1)<=Y){
            list.add(new Point(p1));
        }
        return list;

    }

    //优化
    public static void sort(List<Point> ps){
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int count1=next(o1).size();
                int count2=next(o2).size();
                if(count1<count2){
                    return -1;
                }else if(count1>count2){
                    return 1;
                }else{
                    return 0;
                }
            }
        });
    }
}
