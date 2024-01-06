package com.itCs520.deanProject.Basic2.binarySearch;/*
 *ClassName:BsRightMost
 *Description:
 *@Author:deanzhou
 *@Date:2023/6/10 16:05
 */

public class BsRightMost {
    /*
    * 1. 返回重复元素最右侧元素
    * */
    public static void main(String[] args) {
        //test
        int[] a={1,2,4,4,4,5,6,7};
        System.out.println(binarySearchRightMost(a, 4));
    }

    /*LeftMost:
     * */
    public static int binarySearchRightMost(int[] a,int target){
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
                i = mid + 1;           //向右移
            }
        }
        return candidate;
    }

    /*升级版  返回 <=target 最靠右的索引*/
    public static int binarySearchRightMost2(int[] a,int target){
        //1. pointer
        int i=0, j=a.length-1;
        //2. 循环遍历
        while (i<=j){
            //2.1 取中间元素
            int mid= (i+j)>>>1;
            //2.2 target 小于 mid
            if (target<a[mid]) {
                j = mid - 1;
            }else{
                //2.3 target > mid
                i = mid + 1;
            }
        }
        return i-1;
    }
}
