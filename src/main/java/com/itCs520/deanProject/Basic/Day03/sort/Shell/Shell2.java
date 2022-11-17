package com.itCs520.deanProject.Basic.Day03.sort.Shell;

public class Shell2 {
    //排序
    public static void sort(Comparable[] a){
        //1 根据数组长度确定增常量 增长量规则
        int h = 1;
        while (h<a.length/2){
            h=2*h+1;
        }
        //当增长量为1的时候停止
        while (h>=1){
            //排序
            //1找到待插入元素
            for (int i = h; i <a.length ; i++) {
                for (int j = i; j >=h ; j-=h) {
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
    //比较
    public static boolean greater(Comparable v,Comparable w){
        //compareTo实质是做减法
        return v.compareTo(w)>0;
    }
    //比较
    public static void exch(Comparable[] a,int i ,int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
