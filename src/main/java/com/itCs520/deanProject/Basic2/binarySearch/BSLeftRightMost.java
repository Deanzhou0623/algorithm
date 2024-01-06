package com.itCs520.deanProject.Basic2.binarySearch;/*
 *ClassName:BSLeftRightMost
 *Description:
 *@Author:deanzhou
 *@Date:2023/6/10 16:21
 */

public class BSLeftRightMost {
    /*
    * 1. 二分查找的 leftRightMost的应用 ：求排名，求前任，后任，做范围查询
    *
    * 求排名：              target = 5 ,排名是6
    *                        |
    *       1 ，2 ，4 ，4 ，4 ，7 ，7
    *              ｜
    *       target =4 ，排名是3
    *
    *   排名：LeftMost +1
    * 前任/后任问题：
    *                       ｜ target = 5
    *                     前任是最靠近target的比target 小的值
    *                     后任是最靠近target的比target 大的值
    *
    *       前任：leftMost+1
    *       后任：rightMost -1
    *
    *
    * 最近邻居问题：         前任和后任加在一起看谁离的更近
    *                       4 距离 5 一个位置  --> 最近邻居
    *                       7 距离 5 两个位置
    *
    * 范围查询问题：
    *           < 4  下标：(0,LeftMost(4) -1)
    *           <=4  下标: (0.RightMost(4))
    *
    *           >4   下标：(RightMost(4)+1，a.length-1)
    *           >=4  下标：(LeftMost(4) , 无穷大)
    *
    *          4<= x <= 7 Leftmost(4) ... RightMost(7)
    *          4 < x < 7  RightMost(4)+1 ....LeftMost(7) -1
    * */
}
