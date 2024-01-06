package com.itCs520.deanProject.Basic2.recursion;/*
 *ClassName:ReversePrintString
 *Description:
 *@Author:deanzhou
 *@Date:2023/7/1 18:28
 */

public class ReversePrintString {
    /*
    * 用递归反向打印字符串，n为字符在整个字符串的索引位置
    *  递：n从0开始，每次n 加 1 一直到 n == str.length() -1
    *  归：从 n==str.length()开始归 ，从归打印自然是逆序
    *
    * 递推关系：
    *
    *   f(n) = 停止       n= str.length();
    *          f(n+1)    0 <= n <= str.length -1
    * */

    public static void f(int n,String str){
        //1. 结束条件
        if (n== str.length())
            return;
        //2. 递推关系
        f(n+1,str);
        System.out.println(str.charAt(n));
    }

    public static void main(String[] args) {
        f(0,"abcd");
    }
}
