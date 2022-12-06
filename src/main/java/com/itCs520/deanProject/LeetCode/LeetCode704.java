package com.itCs520.deanProject.LeetCode;

public class LeetCode704 {
    /*给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，
    如果目标值存在返回下标，否则返回 -1。

示例 1:
输入: nums = [-1,0,3,5,9,12], target = 9
输出: 4
解释: 9 出现在 nums 中并且下标为 4

示例 2:
输入: nums = [-1,0,3,5,9,12], target = 2
输出: -1
解释: 2 不存在 nums 中因此返回 -1
    * */

    /*solution1: 循环方式查找
    * */
    public int search(int[] nums, int target) {
        int start=0, end = nums.length-1;
        while (start<=end){
            int mid = (start+end)/2;
            if (target>nums[mid]){
                start=mid+1;
            }else if(target<nums[mid]) {
                end=mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    /*solution2:递归对方式
    * */
    public int search2(int[] nums, int target) {
        return searchNums(nums,0,nums.length-1,target);
    }
    private int searchNums(int[] arr,int start,int end,int key){
        int mid=(start+end)/2;
        if(start<=mid){
            if (key>arr[mid]){
                return searchNums(arr,mid+1,end,key);
            }else if (key<arr[mid]){
                return searchNums(arr,start,mid-1,key);
            }else {
                return mid;
            }
        }
        return -1;
    }
}
