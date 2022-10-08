package com.itCs520.deanProject.services.Day03.Quick;

public class Quick3 {
    //交换元素
    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp;
        temp= a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    //比较元素
    public static boolean less(Comparable v,Comparable w){
        //compareTo，实质是做减法
        return v.compareTo(w)<0;
    }
    //对数组内部进行排序
    public static void sort(Comparable[] a){
        //初始化排序范围
        int lo=0;
        int hi=a.length-1;
        sort(a,lo,hi);
    }
    //对数组从lo到hi进行排序
    private static void sort(Comparable[] a, int lo, int hi) {
        //安全性校验
        if (lo>=hi){
            return;
        }
        //对索引lo处到hi处进行分组，分为左子组和右子组
        int partition=partition(a,lo,hi);
        //对左子组排序
        sort(a,lo,partition);
        //对右子组排序
        sort(a,partition+1,hi);
    }

    public static int partition(Comparable[] a, int lo, int hi) {
        //数组第一个默认为分界值
        Comparable key=a[lo];
        //定义两个指针
        int left=0;
        int right = hi+1;
        //先从右往左扫描
        while (true){
            while (less(key,a[--right])){
                if (right==lo){
                    break;
                }
            }

            //再从左往右扫描，移动left指针，找到一个比分界值大的元素，停止
            while (less(a[++left],key)){
                if (left == hi){
                    break;
                }
            }

            //交换分界值
            if (left >= right){
                break;
            }else {
                exch(a,left,right);
            }
            // 如果交换完毕
            exch(a,lo,right);
        }
        return right;

    }
}
