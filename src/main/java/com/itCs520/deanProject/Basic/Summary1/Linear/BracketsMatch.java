package com.itCs520.deanProject.Basic.Summary1.Linear;

import com.itCs520.deanProject.Basic.Day04.linear.Stack;

public class BracketsMatch {
    //括号匹配问题
    public static void main(String[] args) {
        String str = "(上海(北京)())";
        boolean match = isMatch(str);
        System.out.println(str + " 中的括号是否匹配" + match);
    }
    /*
     * 1. 判断str中的括号是否匹配
     * */
   /* private static boolean isMatch(String str) {
        //1 创建stack对象用来存储左括号
        Stack<String> chars = new Stack<>();
        //2 从左到右遍历字符
        for (int i = 0; i < str.length(); i++) {
            String currChar=str.charAt(i)+" ,";
            //3 判断当前字符串是否为左括号，如果是，则把字符放入栈中
            if (currChar.equals("(")){
                //压栈
                chars.push(currChar);
            }else if (currChar.equals(")")){
                //4 继续判断当前字符是否是右括号，如果是，则从栈中弹出一个左括号，并判断弹出的结果是否为null，如果为null则证明没有匹配左括号
                String pop=chars.pop();
                if (pop==null){
                    return false;
                }
            }
        }
        //5 判断栈中有没有剩余的左括号，如果有，则证明括号不匹配
        if (chars.size()==0){
            return true;
        }
        return false;
    }*/

    public static boolean isMatch(String str){
        //1 定义stack存储数据
        Stack<Object> chars = new Stack<>();
        //2 遍历数组
        for (int i = 0; i <str.length() ; i++) {
                String currChar=str.charAt(i)+",";
            //3 判断字符是否为左括号，如果是左括号则压栈
            if (currChar.equals("(")){
                chars.push(currChar);
            }else if(currChar.equals(")")){
                //4 判断字符是否为右括号如果是则弹栈，并判断弹栈元素是否为空
                String pop= (String) chars.pop();
                if (pop==null){
                    return false;
                }
            }

        }
        //5 判断stack里面是否剩余左括号，如果是，则说明字符不匹配
        if (chars.size()==0){
            return true;
        }
        return false;
    }
}
