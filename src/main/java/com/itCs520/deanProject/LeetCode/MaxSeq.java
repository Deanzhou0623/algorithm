package com.itCs520.deanProject.LeetCode;/*
 *ClassName:MaxSeq
 *Description:
 *@Author:deanzhou
 *@Date:2023/3/27 15:01
 */

public class MaxSeq {
    /*最长连续递增序列
    给定一个未经排序的整数数组，找到最长且连续递增的子序列，并返回该序列的长度
    序列的下标是连续的
    * */
    public static void main(String[] args) {
        System.out.println(findLength(new int[]{1,2,3,2,3,4,3,4,5,6,7}));
    }

    private static int findLength(int[] ints) {
        int start=0;
        int max = 0;
        for (int i = 1; i < ints.length ; i++) {
            if (ints[i] <= ints[i-1]){
                 start = i;
            }
            max = Math.max(max,i-start+1);
        }
        return max;
    }
}
