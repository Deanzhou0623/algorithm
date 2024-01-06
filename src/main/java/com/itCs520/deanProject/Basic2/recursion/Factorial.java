package com.itCs520.deanProject.Basic2.recursion;/*
 *ClassName:Factorial
 *Description:
 *@Author:deanzhou
 *@Date:2023/7/1 18:18
 */

public class Factorial {
    /* 递归的方法求阶乘
    * 1. n！= 1x2 x3 .... x(n-2)(n-1)N n为自然数 0！=1
    *
    * 递推关系：
    *   f(n) =  1            n=1
    *           n*f(n-1)     n>1
    * */

    public static int f(int n){
        //1. 终止条件
        if (n == 1) return 1;
        //2. 关系式
        return n*f(n-1);
    }

    public static void main(String[] args) {
        int f=f(5);
        System.out.println(f);
    }
}
