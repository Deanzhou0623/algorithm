package com.itCs520.deanProject.LeetCode;/*
 *ClassName:TwoNumberSum2
 *Description:
 *@Author:deanzhou
 *@Date:2023/3/20 15:53
 */

import java.util.Arrays;

public class TwoNumberSum2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSearch(new int[]{1,2,3,4,5,6},10)));
        System.out.println(Arrays.toString(twoPoint(new int[]{1,2,3,4,5,6},10)));
    }

    //binary search O(nlogn)
    public static int[] twoSearch(int[] numbers, int target){
        for (int i = 0; i < numbers.length; i++) {
            int low=i , high = numbers.length -1;
            while (low <= high){
                int mid= (high-low)/2+low;
                if (numbers[mid] == target-numbers[i]){
                    return new int[]{i,mid};
                }else if (numbers[mid]> target-numbers[i]){
                    high = mid-1;
                }else {
                    low = mid+1;
                }
            }

        }
        return new int[0];
    }

    // two pointer  time O(n)
    public static int[] twoPoint(int[] nums,int target){
        int low =0, high = nums.length-1;
        while (low <high){
            int sum=nums[low] + nums[high];
            if (sum==target){
                return new int[]{low,high};
            }else if (sum < target){
                low++;
            }else {
                high--;
            }
        }
        return new int[0];
    }

}
