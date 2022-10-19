package com.itCs520.deanProject.services.Summary1.Sort.Bubble;

public class BubbleSort2 {
    //排序
    public static void sort(Comparable[] a){
        //1. 每次排序之后，最大的元素放置在末尾，参与排序元素-1/ 如果元素从头开始减少 则应该是 从0开始 i++
        for (int i = a.length-1; i >0; i--) {
            for (int j = 0; j < i; j++) {
                //2. 元素和后一个元素比较
                if (greater(j,j+1)){
                    exch(a,j,j+1);
                }
            }
        }
        //3. 元素值大，则交换位置
    }
    //比较
    public static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w)>0;
    }
    //交换
    public static void exch(Comparable[] a, int i ,int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
