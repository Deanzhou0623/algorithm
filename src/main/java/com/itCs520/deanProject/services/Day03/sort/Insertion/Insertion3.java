package com.itCs520.deanProject.services.Day03.sort.Insertion;

public class Insertion3 {
    //交换元素
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

    //排序
    public static void sort(Comparable[] a){
        for (int i = 1; i < a.length; i++) {// 第一个默认排好序
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
