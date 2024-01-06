package com.itCs520.deanProject.Basic2.recursion;/*
 *ClassName:E06Sum
 *Description:
 *@Author:deanzhou
 *@Date:2023/7/10 16:04
 */

public class E06Sum {
    /*
    * 递归求和
    * */
    public static long sum(long n) {
        if (n==1)
            return 1;
        return sum(n-1)+n;
    }

    public static void main(String[] args) {
        /*
        * n 过大 会爆栈 stackOverFlowError
        * */
        System.out.println(sum(10));
    }

    /*
    * 解决 stackOverFlow error
    *  1. 尾调用
    *   最后一步调函数
    *
    *   2.example
    *       function a(){
    *           return b()
    *       }
    *
    *   反例：
    *       function a(){
    *          return b() +1 / b() + x
    *       }
    *  2. scale去recursion
    *     for循环 
    * */
}
