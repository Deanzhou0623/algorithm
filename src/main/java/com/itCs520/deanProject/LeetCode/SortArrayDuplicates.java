package com.itCs520.deanProject.LeetCode;/*
 *ClassName:SortArrayDuplicates
 *Description:
 *@Author:deanzhou
 *@Date:2023/3/14 15:19
 */

public class SortArrayDuplicates{
    /*删除排序数组中的重复项
    一个有序数组nums，原地删除重复出现元素 ，使每个元素只出现一次，返回删除后数组的新长度
    不使用额外的数组空间
    eg: [0,1,2,2,3,3,4]

    //双指针算法
    * */
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,1,2,2,3,3,4}));
    }

    private static int removeDuplicates(int[] ints) {
        if (ints.length==0)
            return 0;
        //2. 定义指针
        int i=0;
        //3. 快指针进行循环
        for (int j = 1; j < ints.length ; j++) {
            if (ints[j]!=ints[i]){
                i++;//指针向后移动
                ints[i] = ints[j]; //本身赋值给本身
            }
        }
        //返回长度
        return i+1;
    }
}
