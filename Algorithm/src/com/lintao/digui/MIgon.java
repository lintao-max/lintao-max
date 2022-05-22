package com.lintao.digui;

public class MIgon {
    public static void main(String[]args){
        //创建一个二维数组作为地图
        int[][] map=new int[8][7];
        for(int i=0;i<8;i++){
            map[0][i]=1;
            map[8][i]=1;
        }

        for(int j=0;j<7;j++){
            map[j][0]=1;
            map[j][7]=1;
        }

        for(int i=0;i<8;i++){
            for(int j=0;j<7;j++){
                System.out.println(map[i][j]+"");
            }
            System.out.println();
        }

    }

    public boolean setMap(int[][]map,int i,int j){
        if(map[6][5]==2){//若果是=2的时候，就认为已经找到了目标地址
            return true;
        }else{
            if(map[i][j]==0){//0 表示当前路还没有走过
                map[i][j]=2;//2 表示可以走通(假设)
                if(setMap(map,i,j+1)){ //表示向右走，能走通
                    return true;
                }else if(setMap(map,i,j-1)){
                    return true;
                }else if(setMap(map,i+1,j)){
                    return true;
                }else if(setMap(map,i-1,j)){
                    return true;
                }else{
                    map[i][j]=3;
                    return false;
                }
            }else{//若果map的值不为0情况下 有可能1,2,3
                return false;
            }
        }

    }
}
