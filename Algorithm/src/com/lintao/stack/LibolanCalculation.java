package com.lintao.stack;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LibolanCalculation {
    public static void main(String[]args){
        //创建逆波兰表达式
        String suffixExpression="3 4 + 5 * 6 -";

    }

    //遍历表达式并入list
    public List<String> getListString(String lis){
        List<String> list=new ArrayList<String>();
        String[] listitems=lis.split(" ");
        for(String item:listitems){
            list.add(item);
        }
        return list;
    }
    //计算表达式
    public int cal(List<String> lis){
        //创建栈
        Stack<String> stack=new Stack<String>();
        for(String item:lis){
            if(item.matches("\\%d+")){//匹配多位数
                stack.push(item);//若果是数栈，便入栈
            }else{//如果是运算符号 ，便弹出两个数并一起运算
                int num2=Integer.parseInt(stack.pop());
                int num1=Integer.parseInt(stack.pop());
                int res=0;
                //判断运算符号并运算
                if(item.equals("+")){
                    res=num2+num1;
                }else if(item.equals("-")){
                    res=num1-num2;
                }else if(item.equals("*")){
                    res=num1*num2;
                }else if(item.equals("/")){
                    res=num1/num2;
                }else{
                    throw new RuntimeException("运算符号不合法");
                }
                stack.push(""+res);//把运算结果送入栈
            }
        }
        return Integer.parseInt(stack.pop());//将栈内最后一个数返回
    }


    //将中缀表达式扫描到list中
    public List<String> getIndexExpression(String s){
        List<String> list=new ArrayList<>();
        char c;
        int index=0;
        String str="";
        do{
            //若果是非数字则直接入list
            if((c=s.charAt(index))<48||(c=s.charAt(index))>57){
                list.add(""+c);
                index++;
            }else{//若果是数字则需要拼接
                str="";
                while(index<s.length()&&(c=s.charAt(index))>48 && (c=s.charAt(index))<57){
                    str+=c;
                    index++;
                }
                list.add(str);
            }

        }while(index<s.length());
        return list;
    }
    //将中缀表达式转为后缀表达式
    public List<String> SwitchIndextoSUffix(List<String> list){
        //创建一个栈
        Stack<String> s1=new Stack<>();
        //创建list
        List<String> s2=new ArrayList<>();
        for(String item:list){
            //判断是数字的情况则直接加入s2集合中
            if(item.matches("\\d+")){
                s2.add(item);
            }else if(item.equals("(")){//遇到左括号情况
                s1.push(item);
            }else if(item.equals(")")){//遇到右括号的时候，则需要将s1栈中符号弹出-->s2中
                while(!s1.peek().equals("(")){//当遇到(的时候停止循环弹出
                    s2.add(s1.pop());
                }
                s1.pop();//此时循环结束，必须将（弹出s1
            }else{//还有种情况就是，遇到s1栈内的运算符号优先级>输入的符号优先级
                while(s1.size()!=0 && Operfu.getPirority(s1.peek())>Operfu.getPirority(item)){
                    s2.add(s1.pop());
                }
                s1.push(item);//将即将入栈的运算符号入s1
            }
            //将表达式中剩余运算符入list中
            while(s2.size()!=0){
                s2.add(item);
            }
        }
       return s2;
    }

}
class Operfu{
    static int ADD=1;
    static int SUM=1;
    static int MUL=2;
    static int DVL=2;

    public static int getPirority(String item){
        int res=0;
        switch(item){
            case "+":
                res=ADD;
                break;
            case "-":
                res=SUM;
                break;
            case "*":
                res=MUL;
                break;
            case "/":
                res=DVL;
                break;
            default:
                break;
        }
        return res;
    }
}
