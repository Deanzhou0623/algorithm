package com.itCs520.deanProject.LeetCode.sort;

public class BubbleSort {
    //exch
    public static void exch(Comparable [] a,int i, int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    //compareTo
    public static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w) > 0;
    }
    //bubbleSort
    public static void sort(Comparable[] a){
        for (int i = a.length-1; i >0 ; i--) { //n个元素参与
            for (int j = 0; j <i; j++) {
                if (greater(a[j],a[j+1])){
                    exch(a,j,j+1);
                }
            }
        }
    }
}
