package com.itCs520.deanProject.LeetCode;/*
 *ClassName:LeetCode461
 *Description:
 *@Author:deanzhou
 *@Date:2023/2/6 23:45
 */

public class LeetCode461 {

    /*1. 暴力解法：
        1，4 转为二进制存入数组
        for循环 1 对应数组 ，for循环4对应数组
        依次比较 ，数据！= distance +1；
    * */

    /*2.  eor
      按位或异 ^ (1 ^ 1 = 0 1^0 = 1 0^0 = 0, 任何一个数和自己亦或都是0)
       x = x & (x-1) 算出二进制里面有多少个1
    * */
    public int hammingDistance(int x, int y) {
        int distance = 0;
        for (int i = x^y; i!=0 ; i=i&(i-1)) {
            distance++;
        }
        return distance;
    }
}
