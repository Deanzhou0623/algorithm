package com.itCs520.deanProject.Basic.Summary1.Sort.Selection;

public class SelectionSort2 {
    //排序
    public static void sort(Comparable[] a){
        //1.元素排序的范围,最后一个元素无需排序
        for (int i = 0; i <a.length-1 ; i++) {
            //2.定义变量记录最小值索引，第一个默认为最小值
            int minIndex=i;
            for (int j = i+1; j <a.length ; j++) { //第一个值默认排好序
                if (greater(a[minIndex],a[j])){
                    //3.比较元素大小，元素小的记录索引
                    minIndex = j;
                }
            }
            //4.交换元素
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
