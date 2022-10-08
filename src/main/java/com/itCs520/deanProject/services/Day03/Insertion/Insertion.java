package com.itCs520.deanProject.services.Day03.Insertion;

public class Insertion {
    public static void sort(Comparable[] a) {
        for (int i = 1; i <a.length; i++) { //第一个已经默认排序 ，从索引为1的第二个开始

            for (int j = i; j >0 ; j--) {
                //比较索引j处和j-1 处的值 ，如果索引j-1 处的值比j处的大，则交换数据，如果不大则找到合适位置，退出循环
                if (greater(a[j-1],a[j])){
                    exch(a,j-1,j);
                }else {
                    break;
                }
            }

        }
    }

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
}
