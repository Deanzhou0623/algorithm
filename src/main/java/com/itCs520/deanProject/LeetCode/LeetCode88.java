package com.itCs520.deanProject.LeetCode;

import java.util.Arrays;

public class LeetCode88 {
    /* 给你两个按照非递减排列的整数数组nums1, nums2,另外两个整数
        m和n分别表示，分别表示nums1，nums2中的元素数目
       请你合并nums2和nums1中，使合并后的数组同样按照非递减顺序排列

     注意：最终，合并后的数组不应该由函数返回，而是存储在数组num1中，为了应对这种情况
           nums1的初始长度为m+n，其中前m个元素表示合并的元素，后n个元素为0
           应该忽略，num2的长度为n

      事例1：
      输入 nums1= [1,2,3,0,0,0], m = 3,nums2 = [2,5,6]
      输出 [1,2,3,4,5,6]
      解释：需要合并[1,2,3] 和 [2,5,6]
      合并结果为[1,2,3,4,5,6]
    * */

    /*1. solution1 :最简单的办法想到Arrays.sort这个api
    * */
    public void merge(int[] nums1, int m,int[] nums2,int n){
        for (int i = 0; i < n; ++i) {
            nums1[m+i]=nums2[i];
        }
        Arrays.sort(nums1);
    }
}
