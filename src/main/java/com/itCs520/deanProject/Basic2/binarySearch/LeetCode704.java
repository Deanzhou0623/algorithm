package com.itCs520.deanProject.Basic2.binarySearch;/*
 *ClassName:LeetCode704
 *Description:
 *@Author:deanzhou
 *@Date:2023/6/10 17:27
 */

public class LeetCode704 {
    /*
    *
    * Given an array of integers nums which is sorted in ascending order,
    * and an integer target, write a function to search target in nums.
    *  If target exists, then return its index. Otherwise, return -1.
        You must write an algorithm with O(log n) runtime complexity.
    *
    *
    * Input: nums = [-1,0,3,5,9,12], target = 9
      Output: 4
      Explanation: 9 exists in nums and its index is 4

*     Input: nums = [-1,0,3,5,9,12], target = 2
      Output: -1
      Explanation: 2 does not exist in nums so return -1
    * */


    /*
    * 1. solution1: basic binary search
    * 2. solution2: improved binary search
    * 3. solution3: balanced binary search
    * */
   /* public int search(int[] a, int target){
        int i=0;
        int j=a.length;
        while (i+1<j){
            int mid = (i+j)>>>1;
            if (target<a[mid]){
                j=mid;
            }else {
                i=mid;
            }
        }
        return (a[i] == target)? i:-1;
    }*/
    public int search(int[] a,int target){
        int i=0,j=a.length;
        while (1<j-i){
            int mid=(i+j)>>>1;
            if (target<a[mid]){
                j=mid;
            }else {
                i=mid;
            }
        }
        return (a[i]==target)?i:-1;
    }
}
