package com.itCs520.deanProject.Basic2.recursion;/*
 *ClassName:BinarySearch
 *Description:
 *@Author:deanzhou
 *@Date:2023/7/6 17:59
 */

public class BinarySearch {

    /*
    * 1. 递归求解binarySearch
    * */
    public int search(int[] a,int target){
        return recursion(a,target,0,a.length-1);
    }
    //recursion for binary search
    private static int recursion(int[] a, int target, int i,int j) {
        if (i>j){
            return -1;
        }

        int m=(i+j) >>>1;
        if (target<a[m]){
            return recursion(a,target,i,m-1);
        }else if (a[m] <target){
            return recursion(a,target,m+1,j);
        }else {
            return m;
        }
    }
}
