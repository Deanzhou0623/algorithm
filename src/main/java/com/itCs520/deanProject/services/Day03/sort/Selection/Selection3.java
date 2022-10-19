package com.itCs520.deanProject.services.Day03.sort.Selection;

public class Selection3 {
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
        //确定排序范围
        for (int i = 0; i <= a.length-2 ; i++) {
            int minIndex=i;
            for (int j = i+1; j <a.length ; j++) {
                if (greater(a[minIndex],a[j])){
                    minIndex = j;
                }
            }
            //互换索引
            exch(a,i,minIndex);
        }
    }
}
