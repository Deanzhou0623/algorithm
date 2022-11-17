package com.itCs520.deanProject.Basic.Day03.sort.Shell;

public class Shell {
    //对数组a中的元素进行排序
    public static void sort(Comparable[] a) {
        //根据数组的长短确定增长量的长度
        int h=1;
        while (h< a.length/2){
             h= 2*h+1;
        }
        //希尔排序
        while (h>=1){
            //排序
            //找到待插入元素
            for (int i = h; i < a.length; i++) {
                //待插入元素插入到有序数列中
                for (int j = i; j >=h; j-=h) {
                    //待插入元素a[j] 和 a[j-h]
                    if (greater(a[j-h],a[j])){
                        exch(a,j-h,j);
                    }else {
                        //待插入元素已经找到合适位置结束循环
                        break;
                    }
                }
            }


            //减小规则
            h=h/2;
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
