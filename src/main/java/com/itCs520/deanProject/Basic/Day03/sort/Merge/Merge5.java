package com.itCs520.deanProject.Basic.Day03.sort.Merge;/*
 *ClassName:Merge5
 *Description:
 *@Author:deanzhou
 *@Date:2023/4/13 16:09
 */

public class Merge5 {
    //assist array
    private static Comparable[] assist;

    //exchange
    private static void exch(Comparable[] a,int i,int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //less
    private static boolean less(Comparable v,Comparable w){
        //compareTo
        return v.compareTo(w)<0;
    }

    //对数组a内部进行排序
    public static void sort(Comparable[] a){
        assist = new Comparable[a.length];
        int lo=0;
        int hi=a.length-1; //下标
        sort(a,lo,hi);
    }
    /*对数组a中从lo到li的元素进行排序
     * */
    private static void sort(Comparable[] a, int lo, int hi) {
        //1.安全性校验
        if (hi <lo){
            return;
        }
        //2. 对lo到hi的数组进行分组
        int mid =lo+(hi-lo)/2;
        //3. 分别对每一组的数据进行排序
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        //4. 把排好序的数组进行归并
        merge(a,lo,mid,hi);
    }
    /*
        对数组中，从lo到mid为一组 ，从mid到hi为一组， 对这两组数据进行归并
        * */
    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        //1. 定义三个指针
        int i=lo;
        int p1=lo;
        int p2=mid+1;
        //2.遍历移动p1指针和p2指针，比较对应索引处的值，找出最小的那个，放到辅助数组最小索引处
        while (p1<=mid && p2<=hi){
            //比较对应索引处的值
            if (less(a[p1],a[p2])){
                assist[i++] = a[p1++];
            }else {
                assist[i++] = a[p2++];
            }
        }
        //3.遍历，如果p1的指针没有走完，那么顺序移动p1指针，把对应元素放到辅助数组对应索引上
        while (p1<=mid){
            assist[i++] = a[p1++];
        }
        //4.遍历，如果p2的指针没有走完，那么顺序移动p1指针，把对应元素放到辅助数组对应索引上
        while (p2<=hi){
            assist[i++] =a[p2++];
        }
        //5. 拷贝辅助数组
        for (int index = 0; index < hi; index++) {
            a[index]=assist[index];
        }
    }
}
