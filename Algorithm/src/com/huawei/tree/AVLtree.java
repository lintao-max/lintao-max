package com.huawei.tree;

/**
 * avl树
 */
public class AVLtree {
    public static void main(String[]args){

    }
}
class Node2{
    int value;
    Node2 left;
    Node2 right;
    public Node2(int value){
        this.value=value;
    }
    //获取左子树的高度
    public int leftHeight(){
        if(left==null){
            return 0;
        }
        return left.height();
    }
    //获取右子树高度
    public int rightHeight(){
        if(right==null){
            return 0;
        }
        return right.height();
    }
    //获取树的高度
    public int height(){
        return Math.max(left==null?0:left.height(),right==null?0:left.height())+1;
    }
    //坐旋转二叉树的节点
    public void leftRatio(){
        Node2 newnode=new Node2(value);
        newnode.left=left;
        newnode.right=right.left;
        value=right.value;
        right.left=newnode;
        right=right.right;
    }
    //右旋转
    public void rightRatio(){
        Node2 newnode=new Node2(value);
        newnode.right=right;
        newnode.left=left.right;
        value=left.value;
        left=left.left;
        right=newnode;

    }
    public void addNode(Node2 node){
        if(node==null){
            return;
        }
        if(node.value<this.value){
            if(this.left==null){
                this.left=node;
            }else{
                this.left.addNode(node);
            }
        }else{
            if(this.right==null){
                this.right=node;
            }else{
                this.right.addNode(node);
            }
        }
        if(rightHeight()-leftHeight()>1){
            if(right!=null && right.leftHeight()>right.rightHeight()){
                right.rightRatio();
                leftRatio();
            }else{
                leftRatio();
            }
            return;
        }
        if(leftHeight()-rightHeight()>1){
            if(left!=null&& left.rightHeight()>left.leftHeight()){
                left.leftRatio();
                rightRatio();
            }
            rightRatio();
        }
    }
    //查找想要删除的节点
    public Node2 searchNode(int value){
        if(this.value==value){
            return this;
        }
        if(value<this.value){
            if(this.left!=null){
                return this.left.searchNode(value);
            }
            return null;
        }else if(value>this.value){
            if(this.right!=null){
                return this.right.searchNode(value);
            }
            return null;
        }else{
            return null;
        }
    }
    //查找要删除节点的父节点
    public Node2 searchParent(int value){
        if((this.left!=null&&this.left.value==value) ||(this.right!=null&&this.right.value==value)){
            return this;
        }else{
            if(value<this.value && this.left!=null){
                return this.left.searchParent(value);
            }else if(value>this.value && this.right!=null){
                return this.right.searchParent(value);
            }else{
                return null;
            }
        }
    }
    public void infixOrder(){
        if(this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right!=null){
            this.right.infixOrder();
        }
    }
}

