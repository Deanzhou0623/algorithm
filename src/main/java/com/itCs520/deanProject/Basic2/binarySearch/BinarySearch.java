package com.itCs520.deanProject.Basic2.binarySearch;/*
 *ClassName:BinarySearch
 *Description:
 *@Author:deanzhou
 *@Date:2023/5/31 20:44
 */


import java.util.Arrays;

public class BinarySearch {
    /*
    *
    * 二分查找过程 ：
    *   1. 两个双指针指向 已排好序的数组两边
    *   2. 计算向下取整，找到中点，比较中点与目标值大小
    *   3. 大 --> 右指针 指向 中点+1的位置 小则反之
    *   4. 不断重复如果没找到，则左指针> 右指针 停止
    * */

    public static void main(String[] args) {
        //test1
        int[] a={7,13,21,30,38,44,52,53};
//        System.out.println(binarySearchBasic(a,38));
//        System.out.println(binarySearchAlternative(a,38));

        //test
        int[] b={2,5,8};
        int target=4;
        javaBinarySearch(b,target);
    }
    public static int binarySearchBasic(int[] a ,int target){
        /*//1. 指针
        int i=0;
        int j=a.length-1;
        while (i<=j){
            //除法运算改成 无符号右移运算
            int mid=(i+j) >>> 1;   //mid = (i+j)/2
            if (target<a[mid]){ // 目标值在中点左边,则说明 j要往左移
                j = mid-1;
            }else if (target>a[mid]){ //目标值在中点右边
                i=mid+1;
            }else if (target==a[mid]){
                return mid;
            }
        }
        return -1;*/
        int i=0, j=a.length-1;
        while (i<=j){
            //算出中间值
            int mid=(i+j)>>>1;
            //判断
            if (target<a[mid]){
                j=mid-1;
            }else if (target> a[mid]){
                i=mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    /*
    * 问题1： 为什么是i<= j 意味着区间内有未比较的元素 ， 而不是i<j
    * i == j .意味着i，j 他们指向的元素也会参与比较
    * i < j 只意味着m指向的元素参与比较
    *
    *
    * 问题2：（i+j）/2有没有问题
    * 有问题 当number out of range , java 的二进制第一位是 sign bit，
    * 所以可能会算出负数
    * 因此要改成右移运算
    *
    * 问题3：为什么都写成小于符号
    * ascending sort
    * 因为数组升序排列，用小于符号 看上去更符合逻辑
    * */

    public static int binarySearchAlternative(int[] a,int target){
        //1. 指针
        /*int i=0;
        int j=a.length;                 //第一处改动
        while (i< j){                   //第二处改动
            // = (i+J)/2
            int mid=(i+j)>>>1;
            if (target<a[mid]){
                j=mid;                  //第三处改动
            }else if (target>a[mid]){
                i=mid+1;

            }else if (target==a[mid]){
                //find the number
                return mid;
            }

        }
        return -1;*/
        //j 相当于指针 无任何实际值，不参与比较
        int i=0, j=a.length;
        while (i<j){
            int mid=(i+j)>>>1;
            if (target<a[mid]){
                j=mid;
            }else if (a[mid]< target){
                i=mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    /*
    * j 作为一个边界，无比较元素 ，如果 改成i< =j 会陷入死循环
    *
    * */


    //二分查找发平衡版
    /*解决经典二分查找法的局限： 往左边找L次，右边2L次
      时间复杂度： 最坏：O(logn)  最好 O(n)
    * */
    public static int balancedBinarySearch(int[] a,int target){
        /*int i=0 , j=a.length;
        while (1<j-i){   //只剩1个元素 退出循环
            int m=(i+j)>>>1;
            if (target<a[m]){
                j=m;
            }else {
                i=m;
            }
        }
        if (a[i] == target){
            return i;
        }else {
            return -1;
        }*/
        //1. pointer
        int i=0,j=a.length;
        //2. 比较
        while (1<j-i){
            int mid = (i+j)>>>1;
            if (target<a[mid]){
                j=mid;
            }else {
                i=mid;
            }
        }
        //3. 剩最后一个元素退出循环进行比较
        if (a[i] == target)
            return i;
        else
            return -1;
    }


    /*
    *  java版二分查找法的实现：
    *   1. 在java. array.utils package 下面
    *   2. binarySearch 搜索int类型为例， 在 1700 行
    *   3. 实现方式是跟最初的二分查找法类似，但是 它向右找成本更低，向左找成本高
    *   4. 未找到return的话是 返回 -(low + 1) -(insertion point + 1) ,加-1是为了区分插入点是0的情况
    *
    *   5. 查找插入点
    *
    *   [2,5,8]     a
    *   [2,0,0,0]   b
    *   [2,4,0,0]   b
    *   [2,4,5,8]   b
    * */
    public static void javaBinarySearch(int[] a,int target){
        int i= Arrays.binarySearch(a,target);
        //-（insertion + 1 ）
        System.out.println(i);

        if (i<0){
            int insertIndex = Math.abs(i+1); //插入点索引
            int[] b=new int[a.length+1];
            //拷贝插入点之前的元素
            System.arraycopy(a,0, b,0,insertIndex);
            //插入点
            b[insertIndex] = target;
            //插入点之后的元素
            System.arraycopy(a,insertIndex,b,insertIndex+1,a.length-insertIndex);
            System.out.println(Arrays.toString(b));
        }
    }
}
