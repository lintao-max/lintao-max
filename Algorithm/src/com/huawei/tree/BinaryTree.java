package com.huawei.tree;

public class BinaryTree {
    public static void main(String[]args){

    }
}
class CreateBinaryTree{
    public Node root;
    public void add(Node node){
        if(root==null){
            root=node;
        }else{
            root.addNode(node);
        }
    }
    public void infixOrder(){
        if(root!=null){
            root.infixOrder();
        }else{
            System.out.println("树节点为空");
        }
    }
    //查询要删除的节点
    public Node search(int value){
        if(root!=null){
            root.searchNode(value);
        }
        return null;
    }
    //查询要删除节点的父节点
    public Node searchParent(int value){
        if(root!=null){
            root.searchParent(value);
        }
        return null;
    }
    public int deRightNode(Node node){
        Node target=node;
        if(target.left!=null){
            target=target.left;
        }
        delNode(target.value);
        return target.value;
    }
    //删除节点--叶子节点
    public void delNode(int value){
        if(root==null){
            return;
        }else{
            if(root.left==null && root.right==null){
                root=null;
                return;
            }
            //获取要删除的节点
            Node targetNode=search(value);
            if(targetNode==null){
                return;
            }
            //获取删除节点的父节点
            Node parentNode=searchParent(value);
            if(targetNode.left==null && targetNode.right==null){
                if(parentNode.left!=null&&parentNode.left.value==value){
                    parentNode.left=null;
                }else if(parentNode.right!=null&& parentNode.right.value==value){
                    parentNode.right=null;
                }
            }else if(targetNode.left!=null && targetNode.right!=null){
                int min=deRightNode(targetNode.right);//不明白
                targetNode.value=min;
            }else{//删除只有一个子树的节点
                if(targetNode.left!=null){
                    if(parentNode.left.value==value){
                        parentNode.left=targetNode.left;
                    }else{
                        parentNode.right=targetNode.left;
                    }
                }else{
                    if(parentNode.left!=null){
                        parentNode.left=targetNode.right;
                    }else{
                        parentNode.right=targetNode.right;
                    }
                }
            }
        }
    }
}
class Node{
    int value;
    Node left;
    Node right;
    public Node(int value){
        this.value=value;
    }
    public void addNode(Node node){
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
    }
    //查找想要删除的节点
    public Node searchNode(int value){
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
    public Node searchParent(int value){
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
