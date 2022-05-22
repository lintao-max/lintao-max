package com.lintao.doublelink;

public class DoubleLinkListDemon {

}
class DoubleLink{
    //创建头结点
    DoubleNode head=new DoubleNode(0,"","");
    //添加节点
    public void addNode(DoubleNode newNode){
        DoubleNode temp=head.next;
        while(true){
            if(temp.next==null){
                System.out.println("链表节点已经遍历到最后一步了");
                break;
            }
            temp=temp.next;
        }
        temp.next=newNode;
        newNode.pre=temp;

    }
    public void updateNode(DoubleNode newNode){
        DoubleNode temp=head.next;
        boolean flag=false;
        while(true){
            if(temp==null){
                System.out.println("链表为空");
                break;
            }
            if(temp.no==newNode.no){
                flag=true;
                break;
            }
            temp=temp.next;

        }
        if(flag){
            temp.name=newNode.name;
            temp.nicname=newNode.nicname;
        }else{
            System.out.println("数组为空");

        }

    }
    public void delNode(int no){
        DoubleNode temp=head.next;
        boolean flag=false;
        if(temp==null){
            System.out.println("链表为空");
            return;
        }
        while(true){
            if(temp.next==null){
                System.out.println("已经遍历数组最后一节点了");
                break;
            }
            if(temp.no==no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag){
            temp.pre.next=temp.next;
            if(temp.next!=null){
                temp.next.pre=temp.pre;
            }
        }else{
            System.out.println("节点不存在"+no);
        }
    }
    //显示节点数
    public void showList(){
        //判断节点是否为空
        DoubleNode temp=head.next;
        if(head.next==null){
            System.out.println("节点数为空");
            return;
        }
        while(true){
            if(temp.next==null){
                System.out.println("数组已经到最后节点了");
                break;
            }
            System.out.println("shuzu"+temp);
            temp=temp.next;
        }

    }
}



class DoubleNode{
    int no;
    String name;
    String nicname;
    DoubleNode next;
    DoubleNode pre;

    public DoubleNode(int no,String name,String nicname){
        this.no=no;
        this.name=name;
        this.nicname=nicname;

    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nicname='" + nicname + '\'' +
                ", next=" + next +
                ", pre=" + pre +
                '}';
    }
}
