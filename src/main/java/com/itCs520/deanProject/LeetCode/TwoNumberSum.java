package com.itCs520.deanProject.LeetCode;/*
 *ClassName:TwoNumberSum
 *Description:
 *@Author:deanzhou
 *@Date:2023/3/20 15:33
 */

import java.util.Arrays;
import java.util.HashMap;

public class TwoNumberSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1,2,3,4,5,6},10)));
    }
    //1. 暴力解法 （无序序列）
    private static int[] solution(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length ; j++) {
                if (nums[i] +nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }


    /*2. solution2 :
    标记解法，利用map （无序序列）
    time O(n)
    * */
    private static int[] solution2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i );
        }
        return new int[0];
    }
}
