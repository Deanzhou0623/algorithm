package com.itCs520.deanProject.LeetCode;/*
 *ClassName:CountPrime
 *Description:
 *@Author:deanzhou
 *@Date:2023/3/1 21:46
 */

public class CountPrime {
    /*暴力算法
    1 不算
    * */
    public static int bf(int n){
        int count=0;
        for (int i = 2; i < n; i++) {
            count+= isPrime(n) ? 1 : 0;
        }
        return count;
    }
    /*判断是不是prime    //1不算
     i 小于 开根号x --  i*i < x
    * */
    private static boolean isPrime(int n) {
        for (int i = 2; i*i <= n; i++) {
            if (n%i == 0) return false;
        }
        return true;
    }


    /*埃氏筛选法
    非素数(合数)
    * */
    public static int eratosthenes(int n){
        boolean[] isPrime=new boolean[n]; //默认为false
        int count=0;
        for (int i = 2; i <n ; i++) {
            if (!isPrime[i])
                count++;
            /* 2*i -> i*i 因为 2*2 2*3  2*4 存在重复标记
            * */
            for (int j = 2*i; j < n; j+=i) { //j为合数标记位 j+=i 相当于 2*i -> 3*i -> 4*i
                isPrime[j] = true;
            }
        }
        return count;
    }
}
