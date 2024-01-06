package com.itCs520.deanProject.Basic2.binarySearch;/*
 *ClassName:BsLeftRightMost
 *Description:
 *@Author:deanzhou
 *@Date:2023/6/10 15:03
 */

public class BsLeftMost {

    /*1. 二分查找基础版 -- 重复元素
      2. 遇到第一个符合条件的数 -- 直接返回

      需求：找重复元素中 最左侧的 元素

      1 ，2 ，3 ，【4】 ，4 ，4 ，5 ，6 ，7
                   -> 返回该元素
    * */
    public static void main(String[] args) {
        //test
        int[] a={1,2,4,4,4,5,6,7};
        System.out.println(binarySearchLeftMost(a, 4));
    }

    /*LeftMost:
    * */
    public static int binarySearchLeftMost(int[] a,int target){
        //1. pointer
        int i=0, j=a.length-1;
        int candidate = -1;
        //2. 循环遍历
        while (i<=j){
            //2.1 取中间元素
            int mid= (i+j)>>>1;
            //2.2 target 小于 mid
            if (target<a[mid]) {
                j = mid - 1;
            }else if (a[mid]<target) {
                //2.3 target > mid
                i = mid + 1;
            }else {                   //改动else 部分的代码
                //2.3 target == mid
//                return mid;
                candidate = mid;    //记录符合条件位置
                j = mid - 1;           //继续缩小
            }
        }
        return candidate;
    }

    /*1. 升级版  i返回 >= target的最靠左的索引
    * */
    public static int binarySearchLeftMost2(int[] a,int target){
        //1. pointer
        int i=0, j=a.length-1;
        //2. 循环遍历
        while (i<=j){
            //2.1 取中间元素
            int mid= (i+j)>>>1;
            //2.2 target 小于 mid
            if (target<=a[mid]) {
                j = mid - 1;
            }else if (a[mid]<target) {
                //2.3 target > mid
                i = mid + 1;
            }
        }
        return i;
    }

}
