package com.itCs520.deanProject.Basic.Day03.sort.Insertion;

public class Insertion2 {
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
        //多少个元素参与排序
        for (int i = 1; i <a.length ; i++) {  //第一个已经默认排序，从第二个开始
            for (int j = i; j >0 ; j--) { //第二个
                if (greater(a[j-1],a[j])){
                    exch(a,j-1,j);
                }else {
                    break;
                }
            }

        }

    }
}
