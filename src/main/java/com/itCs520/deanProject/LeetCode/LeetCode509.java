package com.itCs520.deanProject.LeetCode;/*
 *ClassName:LeetCode509
 *Description:
 *@Author:deanzhou
 *@Date:2023/2/23 18:33
 */

public class LeetCode509 {
    /*动态规划实现
    * */
    public int fib(int n){
        if (n<=1) return n;
        int[] dp=new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <=n ; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
