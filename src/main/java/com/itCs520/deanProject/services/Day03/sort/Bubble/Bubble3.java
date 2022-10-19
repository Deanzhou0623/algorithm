package com.itCs520.deanProject.services.Day03.sort.Bubble;

public class Bubble3 {
    //冒泡排序
    //排序
    public static void sort(Comparable[] a){
        //确定排序个数
        for (int i = a.length-1; i >0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (greater(a[j],a[j+1])){
                    exch(a,j,j+1);
                }
            }
        }

    }
    //交换
    public static void exch(Comparable[] a, int i ,int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    //比较
    public static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w)>0;
    }
}
