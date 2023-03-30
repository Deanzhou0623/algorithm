package com.itCs520.deanProject.LeetCode;/*
 *ClassName:LeetCode470
 *Description:
 *@Author:deanzhou
 *@Date:2023/2/26 18:49
 */

public class LeetCode470 {
    /*rand7 （1 - 7）--> rand10（1 - 10）
     （rand7 -1 ） --> （0 - 6）
      (rand7 - 1)* 7 --> (0 , 7 , 14 , 21 , 28 ,25 , 42)
      (rand7 - 1)*7 + rand7-1 -->(0 - 48) 49个数
      结果小于40
      结果 % 10 取余数 （0 - 9） + 1
    * */
    public int rand10() {
        int temp = 40 ;
        while(temp >= 40){
//            temp = (rand7()-1)*7+ rand7()-1;
        }
        return temp%10 +1;
    }

    /*
    * 解决  randA() 生成 randB()的问题解法
    *
    * randN ---> randM
    * randN ---> randX   X >= M  X是N的整数倍 N=7 X=49 M=10；
    * randX ---> randY   Y 又是M的整数倍  Y = 40 M = 10
    * randY mod M +1 ---> randM
    *
    * 解决： rand3 ---> rand11
    *   rand3 ---> rand27 ---> rand 22 ---> rand11
    * 1. rand3 --> 1, 2 ,3
    * 2. rand3-1 --> 0 , 1 ,2
    * 3. (rand3-1)*3 --> 0 , 3 ,6
    * 4. (rand3-1)*3*3 --> 0 , 9 , 18
    * 5. (rand3-1)*3*3 + (rand3-1)*3 + rand3-1 --> 0 - 26   27个数
    * 6. 第5步产生的结果 >= 22,重复第5步
    * 7. mod 11 + 1 --> 1- 11 ---> rand11
    * */
}
