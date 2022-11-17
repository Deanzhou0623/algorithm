package com.itCs520.deanProject.Basic.Day03.sort.Merge;

public class Merge2 {
    //辅助数组
    //辅助数组assist
    private static Comparable[] assist;

    //交换
    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp;
        temp= a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    //比较
    private static boolean less(Comparable v, Comparable w) {
        //compareTo 实质是做减法
        return v.compareTo(w) < 0;
    }



    /*对数组A内部进行排序
    * */
    //排序
    private static void sort(Comparable [] a){
        //1初始化数组
        assist = new Comparable[a.length];
        //2 初始化两个变量记录数组中的最大索引和最小索引
        int lo = 0;
        int hi =a.length-1;
        sort(a,lo,hi);
    }

    /*对数组a中从lo到li的元素进行排序
     * */
    //排序
    private static void sort(Comparable [] a,int lo,int hi){
        //1. 安全性校验
        if (hi<=lo){
            return;
        }
        //2. 对lo到hi进行分组
        int mid = lo + (hi-lo)/2;
        //对lo到mid进行排序
        sort(a,lo,mid);
        //对mid到hi进行排序
        sort(a,mid+1,hi);

        //3.对两组数组进行归并
        merge(a,lo,mid,hi);
    }

    /*
    对数组中，从lo到mid为一组 ，从mid到hi为一组， 对这两组数据进行归并
    * */
    //归并
    public static void merge(Comparable [] a,int lo ,int mid ,int hi){
        //1. 定义三个指针
        int i=lo;
        int p1=lo;
        int p2=mid+1;

        //2. 遍历移动p1指针和p2指针，比较对应索引处的值，找出最小的那个，放到辅助数组最小索引处
        while (p1<=mid && p2<=hi){
            //比较索引处的值
            if (less(a[p1],a[p2])){
                assist[i++]=a[p1++];
            }else {
                assist[i++]=a[p2++];
            }
            //3.遍历，如果p1的指针没有走完，那么顺序移动p1指针，把对应元素放到辅助数组对应索引上
            while (p1<=mid){
                assist[i++]=a[p1++];
            }
            //4.遍历，如果p2的指针没有走完，那么顺序移动p1指针，把对应元素放到辅助数组对应索引上
            while (p2<=hi){
                assist[i++]=a[p2++];
            }
            //5.把辅助数组拷贝到原数组中
            for (int index = lo; index <= hi; index++) {
                a[index]=assist[index];
            }
        }
    }
}
