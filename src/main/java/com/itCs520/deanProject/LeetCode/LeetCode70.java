package com.itCs520.deanProject.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode70 {
    /*
    * 1. 爬楼梯
    * 一次可以爬1阶或者2阶，有多少种方法可以爬到楼顶
    *
    * 事例1：
    * 输入：2
    * 输出：2
    * 解释：有两种方法可以爬到楼顶
    * 1. 1阶 + 1阶
    * 2. 2阶
    *
    *
    * 事例2：
    * 输入：3
    * 输出：3
    * 解释：有三种方法可以爬到楼顶
    * 1. 1阶 + 1阶 + 1阶
    * 2. 2阶 + 1阶
    * 3. 1阶 + 2阶
     * */

    /*solution1： 迭代方法解决爬楼梯问题
    * */
    public int climbStairs1(int n){
        if (n<=2){
            return n;
        }
        return climbStairs1(n-1)+climbStairs1(n-2);
    }

    /*solution2： 迭代方法解决爬楼梯问题 + hashMap存储被重复计算数据
     * */
     Map<Integer,Integer> storeMap= new HashMap<>();
    public int climbStairs2(int n){
        if (n<=2){
            return n;
        }
        if (storeMap.get(n)!=null){
            return storeMap.get(n);
        }else {
            int result=climbStairs2(n-1)+climbStairs2(n-2);
            storeMap.put(n,result);
            return result;
        }

    }
    /*solution3： for循环解决爬楼梯问题
     * */
    public int climbStairs3(int n){
        if (n<=2){
            return n;
        }
        int result = 0;
        int pre = 2;
        int prePre=1;
        for (int i = 3; i < n; ++i) {
            result = pre+prePre;
            prePre = pre;
            pre = result;
        }
        return result;
    }
}
