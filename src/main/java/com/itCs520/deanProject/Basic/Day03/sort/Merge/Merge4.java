package com.itCs520.deanProject.Basic.Day03.sort.Merge;/*
 *ClassName:Merge4
 *Description:
 *@Author:deanzhou
 *@Date:2023/2/26 22:40
 */

public class Merge4 {
    //需要辅助数组
    private static Comparable[] assist;

    //交换元素
    private static void exch(Comparable[] a,int i,int j){
        Comparable temp;
        temp=a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    //比较大小
    private static boolean less(Comparable v,Comparable w){
        //减法
        return v.compareTo(w)<0;
    }
    //对数组内部进行排序
    private static void sort(Comparable[] a){
        //1. 初始化数组a
        assist = new Comparable[a.length];
        //2. 定义一个lo变量，和li变量，分别记录数组最小的索引和最大的索引
        int lo=0;
        int hi=a.length-1;
        //3. 调用sort 重载方法完成对数组a中的，从索引hi到lo的排序
        sort(a,lo,hi);
    }
    //对数组从a中从lo到li的元素进行排序
    private static void sort(Comparable[] a,int lo,int hi){
        //1. 安全性校验
        if (hi<=lo) return;

        //2. 对lo到hi数组进行分组排序
        int mid=lo+(hi-lo)/2;
        //3. 分为两个组
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        //4. 对排好序对数组进行归并排序
        merge(a,lo,mid,hi);
    }
    //对数组中，从lo到mid为一组 ，从mid到hi为一组， 对这两组数据进行归并
    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        //1. 定义3个指针
        int i=lo;
        int p1=lo;
        int p2=mid+1;
        //2.遍历移动p1指针和p2指针
        while (p1<=mid && p2<=hi){
            if (less(a[p1],a[p2])){
                assist[i++] =a[p1++];
            }else {
                assist[i++] =a[p2++];
            }
        }
        //3.遍历，如果p1指针没走完，那么顺时针移动p1指针，把对应元素放到辅助数组对应索引上
        while (p1<=mid){
            assist[i++]= a[p1++];
        }
        //4.遍历，如果p2的指针没有走完，那么顺序移动p1指针，把对应元素放到辅助数组对应索引上
        while (p2<=hi){
            assist[i++]=a[p2++];
        }
        //5. 把辅助数组的元素拷贝到原数组中
        for (int index = lo; index <=hi; index++) {
            a[index]=assist[index];
        }
    }
}
