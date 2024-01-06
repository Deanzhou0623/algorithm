package com.itCs520.deanProject.Basic2.sort;/*
 *ClassName:InsertionSort
 *Description:
 *@Author:deanzhou
 *@Date:2023/7/6 19:12
 */

public class InsertionSort {
    //greater
    public static boolean greater(Comparable a,Comparable b){
        return a.compareTo(b)>0;
    }
    //exch
    public static void exch(Comparable[] a, int i,int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    //sort
    public static void insertionSort(Comparable[] a){
        for (int i = 1; i < a.length; i++) {
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
