package com.huawei.algorithm2;

public class ViloiceMatch {
    public static void main(String[]args){

    }
    public static int viloiceMatch(String str1,String str2){
        char[] len1=str1.toCharArray();
        char[] len2=str2.toCharArray();
        int i=0;
        int j=0;
        while(i<len1.length && j< len2.length){
            if(len1[i]==len2[j]){
                i++;
                j++;
            }else{
                i=i-(j-1)+1;
                j=0;
            }
        }
        if(j==len2.length){
            return i-j;
        }else{
            return -1;
        }
    }

}
