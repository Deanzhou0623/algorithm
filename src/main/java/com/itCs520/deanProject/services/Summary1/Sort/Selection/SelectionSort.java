package com.itCs520.deanProject.services.Summary1.Sort.Selection;

public class SelectionSort {

    //排序
    public static void sort(Comparable[] a){
        //1.排序范围,最后一个元素不需要比较
        for (int i = 0; i <=a.length-2; i++) {
            //2.定义变量，记录最小元素所在索引，默认第一个元素为最小索引
            int minIndex=i;
            //与最小元素进行比较
            for (int j = i+1; j < a.length; j++) {
                //比较元素
                if (greater(a[minIndex],a[j])){
                    minIndex = j;
                }
            }
            //3.交换元素
            exch(a,i,minIndex);
        }

    }
    //比较
    public static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w)>0;
    }
    //交换
    public static void exch(Comparable[] a,int i ,int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
