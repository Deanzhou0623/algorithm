package com.itCs520.deanProject.LeetCode;/*
 *ClassName:Fib
 *Description:
 *@Author:deanzhou
 *@Date:2023/3/20 16:25
 */

public class Fib {
    public static void main(String[] args) {
        System.out.println(claculate(10));
        System.out.println(calculate2(10));
        System.out.println(iterator(10));
    }

    //solution1: recursion
    public static int claculate(int num){
        if (num ==0)
            return 0;
        if (num ==1)
            return 1;

        return claculate(num-1)+claculate(num-2);
    }

    //solution2: de duplication recursion
    public static int calculate2(int num){
        int[] arr = new int[num + 1];
        return recurse(arr,num);
    }

    private static int recurse(int[] arr, int num) {
        if (num ==0)
            return 0;
        if (num ==1)
            return 1;
        if (arr[num]!=0){
            return arr[num];
        }
        arr[num] = recurse(arr,num-1) + recurse(arr,num-2);
        return arr[num];
    }

    //solution3: 双指针算法 two - pointer - O(n)  space O(1)
    private static int iterator(int num) {
        if (num ==0)
            return 0;
        if (num ==1)
            return 1;
        int low =0,high = 1;
        for (int i = 2; i <=num ; i++) {
            int sum=low + high;
            low = high;
            high = sum;
        }
        return high;
    }
}
