package com.itCs520.deanProject.Basic.Day03.sort.Selection;

public class Select2 {
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
         //确定参加的元素
        for (int i = 0; i < a.length-2; i++) {
            //定义一个变量存储最小值
            int minIndex=i;
            for (int j = i+1; j < a.length; j++) {
                if (greater(a[minIndex],a[j])){
                    minIndex = j;
                }
            }
            //交换最小元素和minIndex索引值 此时最小元素为 mindIndex = j ，j重新变为最小值
            exch(a,i,minIndex);
        }
    }
}
