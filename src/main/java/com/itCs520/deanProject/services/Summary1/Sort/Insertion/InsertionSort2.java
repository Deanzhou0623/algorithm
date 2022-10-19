package com.itCs520.deanProject.services.Summary1.Sort.Insertion;

public class InsertionSort2 {
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

    //排序
    public static void sort(Comparable[] a){
        for (int i = 1; i <a.length ; i++) {
            for (int j = i; j >0 ; j--) {
                if (greater(a[j-1],a[j])){
                    exch(a,j-1,j);
                }else {
                    break;
                }
            }
        }
    }
}
