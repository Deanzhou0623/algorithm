package com.itCs520.deanProject.Basic.Summary1.Sort.Quick;

public class QuickSort {
    //交换元素
    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp;
        temp= a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //比较元素
    public static boolean less(Comparable v,Comparable w){

        return v.compareTo(w)<0;
    }
    // 对数据a内部进行排序
    public static void sort(Comparable[] a) {
        //1 定义两个变量记录数组最大索引和最小索引
        int lo=0;
        int hi=a.length-1;
        //2 排序
        sort(a,lo,hi);
    }
    // 对数组a中从lo到li的元素进行排序
    private static void sort(Comparable[] a, int lo, int hi) {
        //1 安全性校验
        if (hi<=lo){
            return;
        }
        //2 对数组中对lo到hi进行分组
        int partition = partition(a,lo,hi);
        //3 对lo到partition进行分组排序
        sort(a,lo,partition);
        //4 对partition+1 到 hi进行分组排序
        sort(a,partition+1,hi);
    }
    // 对数组中，从lo到mid为一组 ，从mid到hi为一组， 对这两组数据进行归并
    public static int partition(Comparable[] a, int lo, int hi){
        //1 确定分界值,默认第一个为分界值
        Comparable key=a[lo];
        //2 定义两个指针，分别指向最小索引处和最大索引处到下一个位置
        int left=lo;
        int right=hi+1;
        //3 切分
        while (true){
            //3.1 先右往左扫描，移动right指针，找到一个比分界值小到元素停止
            while (less(key,a[--right])){
                if (right==lo){
                    break;
                }
            }
            //3.2 再从左往右扫描，移动left指针，找到一个比分界值大大元素，停止
            while (less(a[++left],key)){
                if (left==hi){
                    break;
                }
            }
            //3.3 判断 left>=right ，如果是，则证明元素扫描完毕，结束循环，如果不是则交换元素即可
            if (left>=right){
                break;
            }else {
                exch(a,left,right);
            }
        }
        //4 交换分界值
        exch(a,lo,right);
        return right;
    }

}
