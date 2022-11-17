package com.itCs520.deanProject.Basic.Summary1.Sort.Quick;

public class QuickSort2 {
    //交换元素
    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp;
        temp= a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //比较元素
    public static boolean less(Comparable v,Comparable w){

        return v.compareTo(w)<0;
    }
    //a数组内部进行排序
    public static void sort(Comparable[] a){
        int lo=0;
        int hi=a.length-1;
        sort(a,lo,hi);
    }

    //a数组从lo到partition进行排序，partition+1到hi进行排序
    private static void sort(Comparable[] a, int lo, int hi) {
        //安全性校验
        if (lo>=hi){
            return;
        }
        //找到lo到hi的中间值
        int partition=partition(a,lo,hi);
        sort(a,lo,partition);
        sort(a,partition+1,hi);
    }
    //对排好序对数据进行归并
    private static int partition(Comparable[] a, int lo, int hi) {
        Comparable key=a[lo];
        int left=lo;
        int right=hi+1;
        while (true){
            //比较
            while (less(key,a[--right])){
                if (right==lo){
                    break;
                }
            }
            //比较
            while (less(a[++left],key)){
                if (left==hi){
                    break;
                }
            }
            if (left>=right){
                break;
            }else {
                //交换元素位置
                exch(a,left,right);
            }
        }
        //交换临界值
        exch(a,lo,right);
        return right;
    }

}
