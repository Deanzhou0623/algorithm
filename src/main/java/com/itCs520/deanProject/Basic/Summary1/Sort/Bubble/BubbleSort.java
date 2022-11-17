package com.itCs520.deanProject.Basic.Summary1.Sort.Bubble;

public class BubbleSort {
    //交换元素
    public static void exch(Comparable[] a,int i, int j){
        Comparable temp;
        temp = a[i] ;
        a[i] = a[j] ;
        a[j] = temp ;


    }
    //比较元素
    public static boolean greater(Comparable v ,Comparable w){
        return v.compareTo(w) > 0;
    }
    //元素排序
    public static void sort(Comparable[] a){
        //比较多少个元素参与排序 下标从0开始
        for (int i = a.length-1; i >0 ; i--) {
            for (int j = 0; j <i ; j++) {
                //比较前一个元素和后一个元素
                if (greater(a[j],a[j+1])){
                    //交换元素
                    exch(a,j,j+1);
                }
            }
        }
    }
}
