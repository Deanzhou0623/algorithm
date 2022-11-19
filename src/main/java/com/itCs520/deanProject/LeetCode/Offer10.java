package com.itCs520.deanProject.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Offer10 {
    /*1. 写一个函数，输入n求斐波那契数列的第n项
        定义如下：
    f(n) = 0             n=0;
           1             n=1;
          f(n-2) +f(n-1) n>1
    * */

    /*solution1： 迭代方法解决求斐波那契数列的第n项
    * */
    public int fib1(int n){
        if (n<=1){
            return n;
        }
        return fib1(n-2) + fib1(n-1);
    }

    /*solution2： 迭代方法解决求斐波那契数列的第n项,通过hashMap存储已经计算过的数据来提升效率
     * */
    Map<Integer,Integer> storeMap= new HashMap<>();
    public int fib2(int n){
        if (n<=1){
            return n;
        }
        if (storeMap.get(n)!=null){
            return storeMap.get(n);
        }else {
            int result=fib2(n-2)+fib2(n-1);
            storeMap.put(n,result);
            return result;
        }
    }

    /*solution3： for循环解决求斐波那契数列的第n项
    * */
    public int fib3(int n){
        if (n<=1){
            return n;
        }
        //定义三个参数、
        int result = 1;
        int pre = 0;
        int prePre = 0;
        //for循环模拟求n
        for (int i = 2; i < n; ++i) {
            pre = result;
            prePre = pre;
            result = pre + prePre;
        }
        return result;
    }

}
