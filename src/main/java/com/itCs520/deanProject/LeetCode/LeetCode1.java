package com.itCs520.deanProject.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1 {
    /*给定一个整数 nums和一个整数的目标值target
    请你在该数组中找出和为目标值 target 的哪两个整数，并返回他们的下标


    假设：每一种输入只会对应一个答案，数组中同一个元素不能在答案里重复出现

    事例1：
    输入：nums[2,7,11,15],   target = 9;
    输出：[0,1]
    解释：因为 num[0] + num[1] ==9 ,返回[0,1];
    * */

    /*solution1: 暴力穷举法
    * */
    public int[] twoSum1(int[] nums, int target){
        //1. 定义一个int[]对象，存放结果
        int[] result= new int[2];
        //2. 双层for循环循环模拟该过程 num[i] + num[j] = target
        for (int i = 0; i <nums.length ; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if (nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    /*solution2: 暴力穷举法优化，通过hashMap避免重复扫描
            key为值，value为下标
     * */
    public int[] twoSum2(int[] nums, int target){
        Map<Integer, Integer> storeNums = new HashMap<>(nums.length,1);
        //1. 定义一个int[]对象，存放结果
        int[] result= new int[2];
        for (int i = 0; i <nums.length ; i++) {
            int another = target - nums[i];
            Integer anotherIndex = storeNums.get(another);
            if (anotherIndex!=null){
                result[0] = anotherIndex;
                result[1] = i;
                break;
            }else{
                storeNums.put(nums[i],i );
            }
        }
        return result;
    }


}
