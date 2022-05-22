package com.huawei.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 赫夫曼编码
 */
public class HuffManCode {
    public static void main(String[]args){
        String str="huahuhuauhiu";
        byte[] bytes=str.getBytes();
        List<Node3> list=getNode(bytes);
        Node3 node=createHaffuManTree(list);
        preOrder(node);
        Map<Byte,String> hauffcodes=getCodes(node);//生成赫夫曼code
        zip(bytes,hauffcodes);
    }
    public static byte[] huffmanZip(byte[] bytes){
        List<Node3> list=getNode(bytes);
        Node3 node=createHaffuManTree(list);
        preOrder(node);
        Map<Byte,String> hauffcodes=getCodes(node);//生成赫夫曼code
        byte[] by=zip(bytes,hauffcodes);
        return by;
    }
    static Map<Byte,String> huffmancode=new HashMap<Byte,String>();
    static StringBuilder stringbuilder=new StringBuilder();
    public static Map<Byte,String> getCodes(Node3 root){
        if(root==null){
            return null;
        }
        getCodes(root.left,"0",stringbuilder);
        getCodes(root.right,"1",stringbuilder);

        return huffmancode;
    }

    public static byte[] zip(byte[]bytes,Map<Byte,String> huffmancode){
        StringBuilder stringBuilder=new StringBuilder();
        for(Byte b:bytes){
            stringBuilder.append(b);
        }
        System.out.println("stringbuilder="+stringBuilder.toString());
        int len;
        if(stringBuilder.length()%8==0){
            len=stringBuilder.length()/8;
        }else{
            len=stringBuilder.length()/8+1;
        }
        byte[] by=new byte[len];
        int index=0;
        for(int i=0;i<stringBuilder.length();i+=8){
            String strByte;
            if(i+8>stringBuilder.length()){
                strByte=stringBuilder.substring(i);
            }else{
                strByte=stringBuilder.substring(i,i+8);
            }
            by[index]=(byte)Integer.parseInt(strByte,2);
            index++;
        }
        return by;
    }

    public static Map<Byte,String> getCodes(Node3 node,String code,StringBuilder stringbuilder){
        StringBuilder stringBuilder2=new StringBuilder();
        stringBuilder2.append(code);
        if(node.data==null){
            getCodes(node.left,"0",stringBuilder2);
            getCodes(node.right,"1",stringBuilder2);
        }else{
            huffmancode.put(node.data,stringBuilder2.toString());
        }
        return huffmancode;
    }
    public static List<Node3> getNode(byte[] data){
        List<Node3> list=new ArrayList<>();
        Map<Byte,Integer> map=new HashMap<Byte,Integer>();
        for(Byte b:data){
            Integer count=map.get(b);//从map中获取K的次数
            if(count==null){
                map.put(b,1);
            }else{
                map.put(b,count+1);
            }
        }
        //遍历map
        for(Map.Entry<Byte,Integer> entry:map.entrySet()){
            list.add(new Node3(entry.getKey(),entry.getValue()));
        }
        return list;
    }
    //创建赫夫曼树
    public static Node3 createHaffuManTree(List<Node3> list){
        while(list.size()>1){
            Node3 node3Left=list.get(0);
            Node3 node3Right=list.get(1);
            Node3 parent=new Node3(null,node3Left.weight + node3Right.weight);
            list.remove(node3Left);
            list.remove(node3Right);
            list.add(parent);
        }
        return list.get(0);
    }
    public static void preOrder(Node3 root){
        if(root!=null){
            root.preOrder();
        }else{
            System.out.println("赫夫曼树无数据");
        }
    }

}
class Node3 implements Comparable<Node3>{
    Byte data;
    int weight;
    Node3 left;
    Node3 right;
    public Node3(Byte data,int weight){
        this.data=data;
        this.weight=weight;
    }
    @Override
    public int compareTo(Node3 o) {
        return this.weight-o.weight;
    }
    public void preOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }
}
