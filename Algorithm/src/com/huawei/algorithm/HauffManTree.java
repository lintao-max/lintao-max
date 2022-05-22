package com.huawei.algorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 赫夫曼树
 */
public class HauffManTree {
    public static void main(String[]args){
        int[] arr={2,34,3,56};
        Node2 node=createHuffTree(arr);
        preOrder(node);

    }
    public static  void preOrder(Node2 root){
        if(root!=null){
            root.preOrder();
        }else{
            System.out.println("节点不存在");
        }
    }

    public static Node2 createHuffTree(int[] arr) {
        List<Node2> list = new ArrayList<Node2>();
        for(int value:arr){
            list.add(new Node2(value));
        }
        while(list.size()>1){
            Collections.sort(list);//对list从小到大的顺序排序
            Node2 leftNode=list.get(0);
            Node2 rightNode=list.get(1);
            Node2 parent=new Node2(leftNode.value+rightNode.value);
            parent.left=leftNode;
            parent.right=rightNode;
            list.remove(0);
            list.remove(1);
            list.add(parent);
        }
        return list.get(0);
    }
}


class Node2 implements Comparable<Node2>{
    int value;
    Node2 left;
    Node2 right;
    public Node2(int value){
        this.value=value;
    }
    @Override
    public int compareTo(Node2 o) {
        return this.value-o.value;
    }
    public  void preOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }
}
