package com.itCs520.deanProject.LeetCode;/*
 *ClassName:AveArray
 *Description:
 *@Author:deanzhou
 *@Date:2023/3/21 21:48
 */

public class AveArray {
    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1,12,-5,50,3},4));

    }

    private static double findMaxAverage(int[] nums, int k) {
        int sum=0;
        int n = nums.length;
        //第一个窗口的和
        for (int i = 0; i <k; i++) {
            sum +=nums[i];
        }
        int max = sum;
        for (int i = k; i <n; i++) {
            sum = sum -nums[i-k] +nums[i];
            max = Math.max(sum,max);
        }
        return 1.0* max/k;
    }


}
