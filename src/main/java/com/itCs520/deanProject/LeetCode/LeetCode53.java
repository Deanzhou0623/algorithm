package com.itCs520.deanProject.LeetCode;/*
 *ClassName:LeetCode53
 *Description:
 *@Author:deanzhou
 *@Date:2023/2/25 18:01
 */

public class LeetCode53 {
    /* dp[i] = max(nums[i] ,(dp[i-1]+num[i]))
        dp[i] 定义包括最大下标子树和
    * */

    public int maxSubArray(int[] nums){
        //1.初始化dp公式
        int[] dp=new int[nums.length];
        dp[0] = nums[0];
        int result=dp[0];
        //2. 状态转移公式
        for (int i = 1; i < nums.length; i++) {
            //状态转移公式
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            //result 保存dp[i]的最大值
            if (dp[i] > result) result = dp[i];
        }
        return result;
    }
}
