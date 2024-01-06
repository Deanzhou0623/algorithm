package com.itCs520.deanProject.Basic2.binarySearch;/*
 *ClassName:LeetCode34
 *Description:
 *@Author:deanzhou
 *@Date:2023/6/10 18:28
 */

public class LeetCode34 {
    /*
    *  Find First and Last Position of Element in Sorted Array
    *
    * Given an array of integers nums sorted in non-decreasing order,
    * find the starting and ending position of a given target value.
      if target is not found in the array, return [-1, -1].
     You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
    *
    * */

    /*
    * 1. solution: leftMost ,rightMost
    * */

    public int[] searchRange(int[] nums,int target){

        //1. leftMost
        int leftMost = leftMost(nums, target);
        //2. RightMost
        if (leftMost==-1){
            return new int[]{-1,-1};
        }else {
            return new int[]{leftMost,rightMost(nums,target)};
        }

    }
    //LeftMost
    public int leftMost(int[] nums,int target){
        int i=0, j=nums.length-1;

        while (i<=j){
            int mid=(i+j)>>>1;
            if (target<=nums[mid]){
                j=mid-1;
            }else if (target>nums[mid]){
                i=mid+1;
            }
        }

        return i;
    }

    //RightMost
    public int rightMost(int[] nums , int target){
        int i=0, j=nums.length-1;

        while (i<=j){
            int mid=(i+j)>>>1;
            if (target<nums[mid]){
                j=mid-1;
            }else {
                i=mid+1;
            }
        }

        return i-1;
    }
}
