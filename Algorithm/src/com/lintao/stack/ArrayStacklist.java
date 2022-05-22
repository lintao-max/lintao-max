package com.lintao.stack;

public class ArrayStacklist {
    public static void main(String[]args){
        //创造一个表达式
        String espression="3+6*2-1";
        //创造两个数组栈
        Stack datastack=new Stack(10);
        Stack operstack=new Stack(10);
        int num1=0;//用于记录数据1
        int num2=0;//用于记录数据2
        char ch=' ';//记录符号
        int oper=0;
        int res=0;//用于记录运算结果
        int index=0;
        String num="";
        while(true){
            ch=espression.substring(index,index+1).charAt(0);
            if(operstack.isoper(ch)){//判断是字符
                if(!operstack.isEmpty()) {//判断字符栈内不是为空
                    //若扫描即将入栈的字符优先级<栈内的字符的优先级
                    if(operstack.priority(ch)< operstack.priority(operstack.peek())){
                        num1=datastack.popStack();
                        num2=datastack.popStack();
                        oper=operstack.popStack();
                        res=datastack.cal(num1,num2,oper);
                        //将运算结果入数栈
                        datastack.addStack(res);
                        //将操作符入字符栈
                        operstack.addStack(ch);
                    }else{
                        //字符优先级大于字符栈内的优先级,则直接入符号栈
                        operstack.addStack(ch);
                    }
                }else{
                    //字符栈为空的时候，直接入
                    operstack.addStack(ch);
                }
            }else{
                //datastack.addStack(ch-48);//若果是数字，直接入数栈
                //若果是多位数则需要向后一位探视，若是数字继续拼接，若是字符则入数栈
                num+=ch;
                if(index>=espression.length()-1){
                    //已经到表达式最后一位了，直接入数栈
                    datastack.addStack(ch-48);
                }else{
                    if(operstack.isoper(espression.substring(index+1,index+2).charAt(0))){
                        datastack.addStack(Integer.parseInt(num));
                        //必须置空
                        num="";
                    }
                }
            }
            index++;
            if(index>=espression.length()){
                break;
            }

        }
        //若表达式扫描完成后 就顺序从数栈以及操作符栈中弹出，并计算
        while(true){
            if(operstack.isEmpty()){//操作栈中没有符号了 则为空
                break;
            }
            num1=datastack.popStack();
            num2=datastack.popStack();
            oper=operstack.popStack();
            res=datastack.cal(num1,num2,oper);
            //将运算结果入数栈
            datastack.addStack(res);
        }
        System.out.println("操作数栈的值"+res);
    }
}
class Stack{
    int maxsize;
    int arrstack[];
    int pop;
    public Stack(int maxsize){
        this.maxsize=maxsize;
        arrstack=new int[this.maxsize];
    }
    public boolean isEmpty(){
        return pop==-1;
    }
    public boolean isFull(){
        return pop==maxsize-1;
    }
    public void addStack(int value){
        if(isFull()){
            System.out.println("栈内数据已经满");
            return;
        }
        pop++;
        arrstack[pop]=value;
    }
    public int popStack(){
        if(isEmpty()){
            System.out.println("stack内数据已经为空");
            return -1;
        }
        int value=arrstack[pop];
        pop--;
        return value;
    }
    public void ShowList(){
        if(isEmpty()){
            System.out.println("没有数据");
            return;
        }
        for(int i=pop;i>0;i--){
            System.out.println(arrstack[i]);
        }
    }
    //判断是不是字符
    public boolean isoper(char val){
        return val=='*'||val=='+'||val=='-'||val=='/';
    }

    //设置优先级
    public int priority(int val){
        if(val=='*'||val=='/'){
            return 1;
        }else if(val=='+'||val=='-'){
            return 0;
        }else{
            return -1;
        }
    }
    //计算方法
    public int cal(int num1,int num2,int oper){
        int res=0;
        switch(oper){
            case '+':
                res=num1+num2;
                break;
            case '-':
                res=num2-num1;
                break;
            case '*':
                res=num1*num2;
                break;
            case '/':
                res=num2/num1;
                break;

        }
        return res;
    }
    public int peek(){
        return arrstack[pop];
    }

}
