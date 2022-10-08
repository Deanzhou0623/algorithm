package com.itCs520.deanProject.services.Day03.Selection;

public class Selection {
    //排序
    public static void sort(Comparable[] a) {
        for (int i = 0; i <=a.length-2; i++) { //剩余最后一个元素是无需比较
            //定义一个变量记录最小元素所在索引，默认为参与选择排序的第一个元素位置
            int minIndex = i;
            //与最小元素的比较元素
            for (int j = i+1; j <a.length ; j++) {
                //如果比较的值小，则交换索引位置
                if (greater(a[minIndex],a[j])){
                    minIndex= j;
                }
            }
            //交换最小元素索引minIndex的索引值
            //j和i交换
            exch(a,i,minIndex);

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
