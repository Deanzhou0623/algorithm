package com.itCs520.deanProject.Basic2.recursion;/*
 *ClassName:E06fibonacci
 *Description:
 *@Author:deanzhou
 *@Date:2023/7/7 20:06
 */

import java.util.Arrays;

/*  求 斐波那契 的 第n项

    递归次数： 2 * f(n+1) - 1
*  */
public class E06fibonacci {
    /*
    *
    *   f(n) = 0                    n = 0
    *          1                    n = 1
    *          f(n-1) + f(n-2)      n = 2
    * */

    /*
    * 改动版 ：找个array来存储
    * time： O(n)    space：O(n)
    * */
    public static int change(int n){
        int[] cache =new int[n+1];
        Arrays.fill(cache,-1);
        cache[0] = 0;
        cache[1] = 1;
        return f2(n,cache);
    }
    //改动版
    public static int f2(int n,int[] cache){
        /*if (n == 0) {
            return 0;
        }
        if (n == 1){
            return 1;
        }*/
        if (cache[n]!=-1)
            return cache[n];
        //存入数组
        int x = f2(n-1,cache);
        int y = f2(n-2,cache);
        cache[n] = x+y;
        return cache[n];
    }

    public static int f(int n){
        if (n == 0) {
            return 0;
        }
        if (n == 1){
            return 1;
        }
        return f(n-1) + f(n-2);
    }

    public static void main(String[] args) {
        int f=f(8);
        System.out.println(f);
    }
}
