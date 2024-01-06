package com.itCs520.deanProject.Basic2.recursion;/*
 *ClassName:FrogQuestion
 *Description:
 *@Author:deanzhou
 *@Date:2023/7/7 20:40
 */


/*
*  斐波那契问题变体问题： 青蛙跳楼梯
*
*    楼梯有n阶
*     青蛙要爬到楼顶 可以一次跳一阶 也可以一次跳两阶
*     只能向上跳 有多少种跳法
*
*
*       n                  跳法
*       1                   1
*       2                   1，1  / 2
*       3                   1，1，1 / 2，1 /1，2
*       4                   1，1，1，1 / 1，2，1，/ 2，2/ 2，1，1/ 1，1，2
*
* */
public class FrogQuestion {

    public static int jump(int n){
        if (n==1)
            return 1;
        if (n==2)
            return 2;
        return jump(n-1)+jump(n-2);
    }
    
}
