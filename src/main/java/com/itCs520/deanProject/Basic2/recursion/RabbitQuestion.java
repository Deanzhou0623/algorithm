package com.itCs520.deanProject.Basic2.recursion;/*
 *ClassName:RabbitQuestion
 *Description:
 *@Author:deanzhou
 *@Date:2023/7/7 20:28
 */

/*
*
* 兔子问题 ： 斐波那契的变体
*
* 第一个月： 未成熟的兔子                              2
* 第二个月： 他们成熟                                  2    -- 2
* 第三个月： 它们能产下一对新的兔子                      4      6 -   10
* 所有的兔子遵循相同的规律 求第n个月兔子数
* */
public class RabbitQuestion {

    public static int count(int n){
        int rabbit = 2;

        if (n ==1 || n==2){
            return 2;
        }
        return count(n-1)+count(n-2);
    }

    public static void main(String[] args) {
        int num = count(5);
        System.out.println(num);
    }
}
