package com.itCs520.deanProject.Basic2.sort;/*
 *ClassName:BubbleSort
 *Description:
 *@Author:deanzhou
 *@Date:2023/7/6 18:24
 */

public class BubbleSort {
    //compare
    public static boolean greater(Comparable a,Comparable b){
        return a.compareTo(b)>0;
    }
    //exchange
    public static void exch(Comparable[] a,int i,int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //sort
    public static void sort(Comparable[] a){
        for (int i = a.length-1; i >0; i--) {
            for (int j = 0; j < i; j++) {
                //compare
                if (greater(a[j],a[j+1])){
                    exch(a,j,j+1);
                }
            }
        }
    }

}
