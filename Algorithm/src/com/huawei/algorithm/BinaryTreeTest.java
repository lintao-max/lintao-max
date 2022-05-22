package com.huawei.algorithm;

/**
 * 树结构
 */
public class BinaryTreeTest {
    public static void main(String[]args){

    }

}
class BinaryTree{
    private Node1 root;
    private Node1 pre=null;
    public Node1 getRoot() {
        return root;
    }

    public void setRoot(Node1 root) {
        this.root = root;
    }
    //遍历线索化二叉树
    public void threadBinarylist(){
        Node1 node=root;//获取根节点
        while(node!=null){
            while(node.getLeftType()==0){
                node=node.getLeft();//通过递归找到树的最左子节点
            }
            System.out.println(node);//打印出左子节点
            while(node.getRightType()==1){
                node=node.getRight();//找出左子节点的下一个节点，也就是中序遍历中的中节点
                System.out.println(node);//打印出节点--中节点
            }
            node=node.getRight();//找出中节点的下一个节点也就是右子节点
        }

    }
    //线索化二叉树
    public void threadBinaryTree(Node1 node){
        if(node==null){//如果node节点为空，则无法线索化
            return;
        }
        //先线索化左子树、
        threadBinaryTree(node.getLeft());

        if(node.getLeft()==null){
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if(pre!=null&& pre.getRight()==null){
            node.setRight(node);
            node.setRightType(1);
        }
        pre=node;//移动pre将当前节点成为下一个节点的前驱
        //线索化右子树
        threadBinaryTree(node.getRight());
    }
    //前序遍历
    public void preOrder(){
        if(this.root!=null){
            this.root.preOrder();
        }else{
            System.out.println("根节点为空");
        }
    }
    //中序
    public void indexOrder(){
        if(this.root!=null){
            this.root.indexOrder();
        }else{
            System.out.println("根节点为空");
        }
    }
    //后序遍历
    public void suffixOrder(){
        if(this.root!=null){
            this.root.suffixOrder();
        }else{
            System.out.println("根节点为空");
        }
    }
    //先序查找
    public Node1 findPreOrder(int no){
        if(this.root!=null){
            return this.root.findPreOrder(no);
        }else{
            return null;
        }
    }
    //中序遍历查找
    public Node1 findIndexrder(int no){
        if(this.root!=null){
            return this.root.findIndexOrder(no);
        }else{
            return null;
        }
    }
    //后序遍历
    public Node1 findSuffixOrder(int no){
        if(this.root!=null){
            return this.root.findSuffixOrder(no);
        }else{
            return null;
        }
    }
    //删除节点
    public void deleteNode(int no){
        if(root!=null){
            if(root.getId()==no){
                this.root=null;
            }
            root.deleteNode(no);
        }else{
            System.out.println("数列为空");
        }
    }

}
class Node1{
    private int id;
    private String name;
    private Node1 left;
    private Node1 right;
    private int leftType;//0表示指向左子树，1表示指向前趋节点
    private int rightType;//0表示指向右子树，1表示指向后节点

    public Node1 getLeft() {
        return left;
    }

    public void setLeft(Node1 left) {
        this.left = left;
    }

    public Node1 getRight() {
        return right;
    }

    public void setRight(Node1 right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public Node1(int id, String name){
        this.id=id;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    //前序遍历
    public void preOrder(){
        System.out.println(this);//首先输出当前的父节点

        if(this.left!=null){ //输出左节点
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }

    }
    //中序遍历
    public void indexOrder(){
        if(this.left!=null){
            this.left.indexOrder();
        }
        System.out.println(this);
        if(this.right!=null){
            this.right.indexOrder();
        }
    }

    //后序遍历
    public void suffixOrder(){
        if(this.left!=null){
            this.left.suffixOrder();
        }
        if(this.right!=null){
            this.right.suffixOrder();
        }
        System.out.println(this);
    }
    //先序查找
    public Node1 findPreOrder(int id){
        if(this.id==id){
            return this;
        }
        Node1 resNode=null;
        if(this.left!=null){
            resNode=this.left.findPreOrder(id);
        }
        if(resNode!=null){
            return resNode;
        }

        if(this.right!=null){
            resNode=this.right.findPreOrder(id);
        }
        return resNode;
    }
    //中序查找
    public Node1 findIndexOrder(int id){
        Node1 resNode=null;
        if(this.left!=null){
            resNode=this.left.findIndexOrder(id);
        }
        if(resNode!=null){
            return resNode;
        }
        if(this.id==id){
            return this;
        }
        if(this.right!=null){
            resNode=this.right.findIndexOrder(id);
        }
        return resNode;

    }
    //后序遍历查找
    public Node1 findSuffixOrder(int id){
        Node1 resNode=null;
        if(this.left!=null){
            resNode=this.left.findSuffixOrder(id);
        }
        if(resNode!=null){
            return resNode;
        }
        if(this.right!=null){
            resNode=this.right.findSuffixOrder(id);
        }
        if(resNode!=null){
            return resNode;
        }
        if(this.id==id){
            return this;
        }

        return resNode;
    }
    //删除节点
    public void deleteNode(int no){
        if(this.left!=null && this.left.id==no){
            this.left=null;
            return;
        }
        if(this.right!=null && this.right.id==no){
            this.right=null;
            return;
        }
        if(this.left!=null){
            this.left.deleteNode(no);
        }
        if(this.right!=null){
            this.right.deleteNode(no);
        }
    }

}
