package com.itCs520.deanProject.LeetCode.sort;

public class InsertionSort {
    //exch
    public static void exch(Comparable[] a,int i,int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    //compareTo
    public static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w)>0;
    }
    //sort
    public static void sort(Comparable[] a){
        for (int i = 1; i <a.length ; i++) {//未排序数组
            for (int j = i; j >0; j--) {
                //比较j处的值和j-1处的值，如果索引j-1处的值比j的大
                if (greater(a[j-1],a[j])){
                    exch(a,j-1,j);
                }else {
                    break;
                }
            }

        }
    }
}
