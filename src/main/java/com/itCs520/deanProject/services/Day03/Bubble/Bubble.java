package com.itCs520.deanProject.services.Day03.Bubble;

public class Bubble {
    //对数组a中的元素进行排序
    public static void sort(Comparable[] a) {
        for (int i = a.length-1; i>0 ;i--) { //决定多少个元素参与排序
            for (int j = 0; j < i; j++) {
                //比较j处的值和j+1处的值
                if (greater(a[j],a[j+1])){
                        exch(a,j,j+1);
                }
            }
        }
    }
    //交换
    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp;
        temp= a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /*比较数组内部的值
    * */
    private static boolean greater(Comparable v, Comparable w) {
        //compareTo 实质是做减法
        return v.compareTo(w) > 0;
    }
}
