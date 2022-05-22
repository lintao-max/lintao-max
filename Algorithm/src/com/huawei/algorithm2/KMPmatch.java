package com.huawei.algorithm2;
/**
 * KMP算法
 */
public class KMPmatch {
    public static void main(String[]args){
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        int[] next = kmpNext(str2);
        searchKmp(str1,str2,next);
    }
    public static int searchKmp(String dest1,String dest2,int[]next){
        for(int i=1,j=0;i<dest1.length();i++){
            while(j>0 && dest1.charAt(i)!=dest2.charAt(j)){
                j=next[j-1];
            }
            if(dest1.charAt(i)==dest2.charAt(j)){
                j++;
            }
            if(j==dest1.length()){
                return i-j+1;
            }
        }
        return -1;
    }
    public static int[] kmpNext(String dest){
        //首先创建一个数组
        int[] next=new int[dest.length()];
        next[0]=0;//因为第一个字符的前后缀都没有，所以公共前后缀长度为0
        for(int i=1,j=0;j<dest.length();i++){
            if(j>0 && dest.charAt(i)!=dest.charAt(j)){
                j=next[j-1];
            }
            if(dest.charAt(i)==dest.charAt(j)){
                j++;
            }
            next[i]=j;
        }
        return next;
    }
}
