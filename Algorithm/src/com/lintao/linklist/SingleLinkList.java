package com.lintao.linklist;

public class SingleLinkList {

}
class SingleLink{
    Node head=new Node(0,"","");
    public void addNode(Node newnode){
            Node temp=head;
            while(true){
                if(temp.next==null){
                    System.out.println("链表为空");
                    break;
                }
                temp=temp.next;
            }
           temp.next=newnode;
    }
    //按照顺序添加
    public void insertByorder(Node newNode){
        Node temp=head;
        boolean flag=false;
        while(true){
            if(temp.next==null){
                break;
            }
            if(temp.next.no>newNode.no){
                break;
            }else if(temp.next.no==newNode.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag){
            System.out.println("输入的编号已经存在"+temp.next.no);
        }else{
            newNode.next=temp.next;
            temp.next=newNode;
        }
    }
    //修改节点信息
    public void updateNode(Node newNode){
        Node temp=head.next;
        boolean flag=false;
        while(flag){
            if(temp==null){
                System.out.println("链表遍历结束了");
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
            System.out.println("没有找到编号，不能修改"+temp.no);
        }
    }
    //删除一个节点
    public void delNode(int no){
        Node temp=head;
        boolean flag=false;
        while(true){
            if(temp.next==null){
                System.out.println("链表队列为空");
                break;
            }
            if(temp.next.no==no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag){
            temp.next=temp.next.next;
        }else{
            System.out.println("链表为空");
        }
    }
    public void ShowList(){
        //判断是否为空
        if(head.next==null){
            System.out.println("链表数组为空");
            return;
        }
        Node temp=head.next;
        while(true){
            if(temp==null){
                System.out.println("链表数组为空");
                break;
            }
            System.out.println(temp);
            temp=temp.next;
        }
    }
}

class Node{
    int no;
    String name;
    String nicname;
    Node next;

    public Node(int no,String name,String nickname){
        this.no=no;
        this.name=name;
        this.nicname=nickname;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nicname='" + nicname + '\'' +
                ", next=" + next +
                '}';
    }
}
