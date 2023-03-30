package com.itCs520.deanProject.LeetCode;/*
 *ClassName:GetMaxSum
 *Description:
 *@Author:deanzhou
 *@Date:2023/3/19 21:20
 */

import java.util.Arrays;

public class GetMaxSum {
    public static void main(String[] args) {
        System.out.println(getMaxMin(new int[]{1,2,3,4,5,6}));
    }
    //暴力解法
    /*1. d第一位/第二位为 负数 ，且绝对值 > nums[n-2]/nums[n-3]
      2. 无负数：max--> nums[n-1]*nums[n-2]*nums[n-3]
      3. time： O(nlogn)
    * */
    public static int sort(int[] nums){
        Arrays.sort(nums);
        int n=nums.length;
        return Math.max(nums[0]*nums[1]*nums[n-1],nums[n-1]*nums[n-2]*nums[n-3]);
    }
    /*
    * 1. 线性扫描 / linear scan
    * 2. time O(n)
    * */
    public static int getMaxMin(int[] nums){
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE,max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for (int x:nums) {
            if (x<min1){
                min2 = min1;
                min1 = x;
            }else if (x<min2){
                min2 = x;
            }
            if (x>max1){
                max3 = max2;
                max2 = max1;
                max1 = x;
            }else if (x>max2){
                max3 = max2;
                max2 = x;
            }
        }
        return Math.max(min1*min2*max1,max1*max2*max3);
    }
}
