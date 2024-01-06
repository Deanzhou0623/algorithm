package com.itCs520.deanProject.Basic2.binarySearch;/*
 *ClassName:LeetCode35
 *Description:
 *@Author:deanzhou
 *@Date:2023/6/10 17:43
 */

public class LeetCode35 {
    // Search Insert Position
    /*
    * Given a sorted array of distinct integers and a target value,
    * return the index if the target is found. If not,
    * return the index where it would be if it were inserted in order.
      You must write an algorithm with O(log n) runtime complexity.
    *
    *Example 1:

    Input: nums = [1,3,5,6], target = 5
    Output: 2
    Example 2:

    Input: nums = [1,3,5,6], target = 2
    Output: 1
    Example 3:

    Input: nums = [1,3,5,6], target = 7
    Output: 4
    *
    * */
        //快捷键搜索java内部class：commond + O
    /*solution1: java utils array package, return -(insertion point + 1)
      solution2: LeftMost-->
    * */

    /*public int search(int[] a,int target) {
        int i=0,j=a.length-1;
        while (i<=j){
            int mid=(i+j)>>>1;
            if (target<=a[mid])
                j=mid-1;
            else
                i=mid+1;
        }
        return i;
    }*/

    public int search(int[] a,int target){
        int i=0,j=a.length-1;
        while (i<=j){
            int mid=(i+j)>>>1;
            if (target<=a[mid]){
                j=mid-1;
            }else {
                i=mid+1;
            }
        }
        return i;
    }
}
