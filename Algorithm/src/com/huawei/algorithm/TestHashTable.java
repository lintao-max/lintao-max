package com.huawei.algorithm;

public class TestHashTable {
    public static void main(String[]args){

    }
}
class Node{
    int id;
    String name;
    Node next;
    public Node(int id,String name){
        this.id=id;
        this.name=name;
    }

}
class HashtTable{
    public Linklist linklist[];
    public int size;
    public HashtTable(int size){
        this.size=size;
        linklist=new Linklist[size];
        for(int i=0;i<size;i++){
            linklist[i]=new Linklist();
        }
    }
    public void add(Node node){
        int nodeNo=testHashSolt(node.id);
        linklist[nodeNo].add(node);
    }
    public int testHashSolt(int id){
        return id%size;
    }

    public void list(){
        for(int i=0;i<size;i++){
            linklist[i].list();
        }
    }
    public void findNode(int id){
        int NodeNo=testHashSolt(id);
        Node node=linklist[NodeNo].findValue(id);
        if(node!=null){
            System.out.println("数组列表不为空"+node.id);
        }else{
            System.out.println("数组列表为空");
        }

    }

}
class Linklist{
    Node head;
    public void add(Node node){
        if(head==null){
            head=node;
            return;
        }
        Node curNode=head;
        while(true){
            if(curNode.next==null){
                break;
            }
            curNode=curNode.next;
        }
        curNode.next=node;
    }

    public void list(){
        if(head==null){
            System.out.println("为空");
            return;
        }
        Node curNode=head;
        while(true){
            System.out.println("节点名字"+curNode.name);
            if(curNode.next==null){
                break;
            }
            curNode=curNode.next;
        }
    }

    public Node findValue(int id){
        if(head==null){
            return null;
        }
        Node curNode=head;
        while(true) {
            if (curNode.next == null) {
                curNode = null;
                break;
            }
            if (curNode.id == id) {
                break;
            }
            curNode=curNode.next;
        }
        return curNode;
    }
}