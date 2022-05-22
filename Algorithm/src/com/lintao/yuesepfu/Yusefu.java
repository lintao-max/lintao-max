package com.lintao.yuesepfu;

public class Yusefu {
}

//循环链表
class CircleLinkList{
    //创建头结点
    Boy head=null;
    //添加节点
    public  void addNode(int num){
        if(num<1){
            System.out.println("添加的数无效，单向循环链表至少为1个节点");
            return;
        }
        Boy curBoy=null;
        for(int i=0;i<num;i++){
            Boy boy=new Boy(i);
            if(i==1){//编号为1的设置为头结点
                head=boy;
                boy.next=head;
                curBoy=head;
            }else{
                head.next=boy;
                boy.next=head;
                curBoy=boy;
            }
        }
    }
    //展示链表
    public  void showList(){
        if(head==null){
            System.out.println("出现空链表");
            return;
        }
        Boy curBoy=null;
        while(true){
            if(curBoy.next==head){
                System.out.println("已经遍历到最后一个节点了");
                break;
            }
            System.out.println("节点"+curBoy);
            curBoy=curBoy.next;
        }
    }
    //出圈
    public void OutCircle(int startno,int countNO,int num){
        if(startno<1||head==null||startno>num){
            System.out.println("参数有误，不符合要求");
            return;
        }
        Boy help=head;
        while(true){
            if(help.next==head){//已经遍历到最后一个节点了
                break;
            }
            help=help.next;
        }
        for(int i=0;i<startno-1;i++){
            head=head.next;
            help=help.next;
        }
        while(true){
            if(help==head){//只有一个节点
                break;
            }
            for(int j=0;j<countNO-1;j++){
                help=help.next;
                head=head.next;
            }
            System.out.println(head.no);
            head=head.next;
            help.next=head;
        }
    }
}
class Boy{
    int no;
    Boy next;
    public Boy(int no){
        this.no=no;
    }
}
