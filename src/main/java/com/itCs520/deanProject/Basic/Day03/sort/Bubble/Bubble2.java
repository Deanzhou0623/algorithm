package com.itCs520.deanProject.Basic.Day03.sort.Bubble;

public class Bubble2 {
    //排序sort
    public static void sort(Comparable[] a){
        //确定排序个数
        for (int i = a.length-1; i >0 ; i--) {
        //确定比较对象
            for (int j = 0; j <i ; j++) {
                if (greater(a[j],a[j+1])){
                    exch(a,j,j+1);
                }
            }
        }
    }
    //交换exch
    public static void exch(Comparable[] a,int i,int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    //比较greater
    public static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w)>0;
    }
}
