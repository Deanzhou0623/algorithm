package com.itCs520.deanProject.LeetCode;/*
 *ClassName:LeetCode338
 *Description:
 *@Author:deanzhou
 *@Date:2023/2/2 13:26
 */

public class LeetCode338 {
    /*1.
       x =  x & (x-1) ,清除最低位的1
       假设二进制 x=21 , 0001 0101
         21 & 20 =

         0001 0101 &
         0001 0100  =  0001 0100 = 20

         20 & 19

         0001 0100 &
         0001 0000 = 16

         16 & 15
         0001 0000 &
         0000 1111 = 0

        3 次清除所有的 1
        N 的1 的个数  = [N&(N-1)]+1
    * */

    public int[] countBits(int n) {
        int[] num = new int[n+1];
        for (int i = 1; i <=n; i++) {
            num[i] = num[i&(i-1)]+1;
        }
        return num;
    }
    /*2. 利用奇偶性 解决问题
        奇数 比 偶数的二进制 后面 多1
        偶数 +1 = 奇数
        奇数：5 = 101 7 = 111
        偶数：4 = 100 6 = 110

        偶数    偶数每次除2 (向右移一位) 1的个数不变
        12 = 1100
        6  = 110
        3  = 11
    * */
    public int[] countBits2(int n) {
        int[] num=new int[n+1];
        for (int i = 1; i <=n; i++) {
            // 正则表达式： 判断奇偶性 / 奇数 = 偶数 +1 / 偶数 = 偶数➗2
            num[i] = (i&1)==1? num[i-1]+1:num[i>>1];
        }
        return num;
    }
}
