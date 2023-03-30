package com.itCs520.deanProject.LeetCode;/*
 *ClassName:ArrayCenterIndex
 *Description:
 *@Author:deanzhou
 *@Date:2023/3/14 15:47
 */

import java.util.Arrays;

public class ArrayCenterIndex {
    /*寻找数组的中心下标
    给定一个整数数组nums，请编写一个能返回数组"中心下标"的方法
    中心下标是数组的一个下标，其左层所有元素相加和等于右侧所有元素相加合
    如果数组不存在中心下标，返回-1
    如果数组有多个中心下标，应该返回最靠近左边的那个
    注意：中心下标可能出现在数组的两端
    * */
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1,7,3,6,5,6}));
    }
    //
    private static int pivotIndex(int[] ints) {
        //jdk 8的stream计算
        int sum = Arrays.stream(ints).sum();
        int total = 0;
        for (int i = 0; i < ints.length; i++) {
            total +=ints[i];
            if (total == sum){
                return i;
            }
            sum = sum -ints[i];
        }
        return -1;
    }
}
