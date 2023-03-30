package com.itCs520.deanProject.LeetCode;/*
 *ClassName:MergeSortArray
 *Description:
 *@Author:deanzhou
 *@Date:2023/3/21 15:47
 */

import java.sql.SQLOutput;
import java.util.Arrays;

public class MergeSortArray {
    public static void main(String[] args) {
        int[] nums1=new int[]{1,3,5,7,9,0,0,0,0};
        int[] nums2=new int[]{2,4,6,8};
        System.out.println(Arrays.toString(merge(nums1,5,nums2,4)));
        System.out.println(Arrays.toString(merge2(nums1,5,nums2,4)));
    }
    /* two pointers
    * */
    private static int[] merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy =new int[m];
        System.arraycopy(nums1,0,nums2,m,n);

        //3个指针
        int p1=0; //指向nums1_copy
        int p2=0; //指向nums2
        int p3=0; //指向nums1

        while (p1 <m && p2<n){
            nums1[p3++] =nums1_copy[p1]<nums2[p2] ? nums1_copy[p1++] :nums2[p2++];
        }
        if (p1<m){
            System.arraycopy(nums1_copy,p1,nums1,p1+p2,m+n-p1-p2);
        }
        if (p2<n){
            System.arraycopy(nums2,p2,nums1,p1+p2,m+n-p1-p2);
        }
        return nums1;
    }

    /* java api
    * */
    private static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
        return nums1;
    }


}
