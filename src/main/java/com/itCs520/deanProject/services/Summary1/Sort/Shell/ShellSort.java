package com.itCs520.deanProject.services.Summary1.Sort.Shell;

public class ShellSort {
    //比较
    public static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w)>0;
    }
    //交换
    public static void exch(Comparable[] a,int i ,int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    //排序
    public static void sort(Comparable[] a){
        //1.根据数组长度确定增长量
        int h=1;
        while (h<a.length/2){
            h=2*h+1;
        }
        //2.希尔排序
        while (h>=1){
            //排序
            for (int i = h; i <a.length ; i++) {
                //找到待插入元素
                for (int j = i; j >=h ; j-=h) {
                    //比较待插入元素
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
}
