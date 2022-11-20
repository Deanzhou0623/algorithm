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
    /*2. solution2 :通过两个指针去循环数组中的数组并进行比较，将较小元素存入临时数组，并指针向后移一位
     * */
    public void merge2(int[] nums1, int m,int[] nums2,int n){
        int k=m+n;
        //1. 创建一个临时数组
        int[] temp=new int[k];
        //2. for循环模拟指针
        for (int index = 0,nums1Index =0,nums2Index=0;index < k; index++) {
            if (nums1Index>=m){/*数组1的数据已经取完，直接添加数组2的数据即可*/
                temp[index] = nums2[nums2Index++];
            }else if (nums2Index>=n) {/*数组2的数据已经取完，直接添加数组1的数据即可*/
                temp[index] = nums1[nums1Index++];
            }else if (nums1[nums1Index]<nums2[nums2Index]){
                /*nums1数组的数据小于nums2数组的数据，将nums1的数组存入进temp数组*/
                temp[index] = nums1[nums1Index++];
            }else {
                temp[index] = nums2[nums2Index++];
            }
        }
        //3.将临时数组的数据复制给nums1并返回
        for (int i = 0; i <k ; i++) {
            nums1[i]=temp[i];
        }
    }

    /*3. solution3 :对方案2进行优化降低空间复杂度，不需要开辟额外空间
                通过指针倒叙取元素，并将元素存放在nums1数组中的最后一个
     * */
    public void merge3(int[] nums1, int m,int[] nums2,int n) {
        //1.得到元素的个数
        int k = m + n;
        //2. for循环模拟倒叙指针取元素
        for (int index = k-1,nums1Index=m-1,nums2Index=n-1; index >=0; index--) {
            /*数组1的数据已经取完，直接添加数组2的数据即可*/
            if (nums1Index<0){
                nums1[index]=nums2[nums2Index--];
            }
            /*数组2的数据已经取完，直接添加数组1的数据即可,因为是往nums1中添加数据，直接break*/
           else if (nums2Index<0){
                break;
            }
            /*nums1数组的数据大于nums2数组的数据，将nums1的数组存入数组*/
            else if (nums1[nums1Index]>nums2[nums2Index]){
                nums1[index]=nums1[nums1Index--];
            }else {//nums2数组的数据大于nums1数组的数据
                nums1[index]=nums2[nums2Index--];
            }
        }

    }
}
