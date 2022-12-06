package com.itCs520.deanProject.LeetCode.sort;



public class SelectionSort {
    //exch
    public static void exch(Comparable[] a,int i, int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    //compareTo
    public static boolean greater(Comparable v, Comparable w){
        return v.compareTo(w)>0;
    }
    //sort
    public static void sort(Comparable[] a){
        //比较参加元素
        for (int i = 0; i < a.length-2; i++) { //倒数第一个无需比较
            //定义一个变量存储最小值
            int minIndex=i;
            for (int j = i+1; j <a.length ; j++) {
                if (greater(a[minIndex],a[j])){
                    minIndex = j;
                }
            }
            //交换最小元素所在的索引值
            exch(a,i,minIndex);
        }
    }
}
