package com.itCs520.deanProject.LeetCode.sort;

public class ShellSort {
    //exch
    public static void exch(Comparable[] a,int i,int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[i] = temp;
    }
    //compare
    public static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w)>0;
    }
    //sort
    public static void sort(Comparable[] a){
        //1根据增长量
        int h = 1;
        while (h<a.length/2){
            h=h*2+1;
        }

        //当增长量为1的时候停止
        while (h>-1){
            //排序
            //找到带插入元素
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >=h; j-=h) {
                    if (greater(a[j-h],a[j])){
                        //交换位置
                        exch(a,j-h,j);
                    }else {//结束循环
                        break;
                    }
                }
            }
        }
    }

}
