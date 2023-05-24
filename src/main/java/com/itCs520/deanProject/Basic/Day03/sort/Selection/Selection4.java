package com.itCs520.deanProject.Basic.Day03.sort.Selection;/*
 *ClassName:Selection4
 *Description:
 *@Author:deanzhou
 *@Date:2023/4/13 15:47
 */

public class Selection4 {
    //exchange
    private static void exch(Comparable[] a,int i,int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    //compare
    private static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w)>0;
    }
    //sort
    public static void sort(Comparable[] a){
        //确定参加的元素
        for (int i = 0; i <a.length-2 ; i++) {
            //定义变量存储最小值
            int minIndex =i;
            for (int j = i+1; j <a.length ; j++) {
                if (greater(a[minIndex],a[j])){
                    minIndex=j;
                }
            }
            //交换最小元素和minIndex索引值
            exch(a,i,minIndex);
        }
    }

}
