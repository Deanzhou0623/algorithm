package com.itCs520.deanProject.LeetCode.sort;

public class MergeSort {
    //归并排序所需要的辅助数组
    private static Comparable[] assist;

    //exch
    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp;
        temp= a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    //compare
    private static boolean less(Comparable v, Comparable w) {
        //compareTo 实质是做减法
        return v.compareTo(w) < 0;
    }
    public static void sort(Comparable[] a){
        //1初始化数组
        assist = new Comparable[a.length];
        //2定义一个变量lo和li变量，分别记录数组中最小索引和最大索引
        int lo=0;
        int hi=a.length-1;
        //3调用sort重载方法完成数组中的，从索引hi到lo的排序
        sort(a,lo,hi);
    }
    /*对数组a中从lo到li的元素进行排序
    * */
    private static void sort(Comparable[] a,int lo,int hi){
        //安全性校验
        if (hi<=lo) return;

        //2对lo到进行分组
        int mid = lo + (hi-lo)/2;

        //3分别对每一组的数据进行排序
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        //4把排好序的数组进行归并
        merge(a,lo,mid,hi);
    }
    /*
   对数组中，从lo到mid为一组 ，从mid到hi为一组， 对这两组数据进行归并
   * */
    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        //1定义及三个指针
        int i=lo;
        int p1=lo;
        int p2=mid+1;
        while (p1<=mid && p2<=hi){
            //比较索引处的值
            if (less(a[p1],a[p2])){
                assist[i++] = a[p1++];
            }else {
                assist[i++] = a[p2++];
            }
        }
        //遍历，如果p1指针没有走完你那么顺序移动p1指针
        while (p1<=mid){
            assist[i++] = a[p1++];
        }
        //4.遍历，如果p2的指针没有走完，那么顺序移动p1指针，把对应元素放到辅助数组对应索引上
        while (p2<=hi){
            assist[i++]=a[p2++];
        }
        //5把辅助数组拷贝到原数组中
        for (int index = lo; index <=hi ; index++) {
            a[index] = assist[index];
        }
    }
}
