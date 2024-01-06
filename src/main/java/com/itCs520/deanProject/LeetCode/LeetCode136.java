package com.itCs520.deanProject.LeetCode;/*
 *ClassName:LeetCode136
 *Description:
 *@Author:deanzhou
 *@Date:2023/2/2 13:08
 */

public class LeetCode136 {
    /**         使用了额外空间/ 时间复杂度是线性
     * 1.暴力穷举法： hashMap <key,value> key 是本身的值，
     *             value 就是count 遇到一次+1 遍历value 找出value =1
     */

    /*2. 利用位运算 ：
    按位或异 ^ (1 ^ 1 = 0 1^0 = 1 0^0 = 0, 任何一个数和自己亦或都是0)
    * */
    public int singleNumber(int[] nums){
        int result=0;
        for (int num:nums) {
            result = result^num;
        }
        return result;
    }
}
