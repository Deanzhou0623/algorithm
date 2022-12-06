package com.itCs520.deanProject.LeetCode.sort;

public class QuickSort {
    //exch
    public static void exch(Comparable[] a,int i,int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    //compare
    public static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }
    //sort:对数组A中所有的元素进行排序
    public static void sort(Comparable[] a){
        int lo=0;
        int hi=a.length-1;
        sort(a,lo,hi);
    }
    //sort：对数组中从索引lo到索引hi之间的元素进行排序
    public static void sort(Comparable[] a,int lo,int hi){
        //安全性校验
        if (hi<=lo) return;

        //需要对数组中的lo索引到hi索引处的元素进行分组 （左子组，右子组）
        int partition = partition(a,lo,hi);
        //对左子组进行排序
        sort(a,lo,partition-1);
        //对右子组进行排序
        sort(a,partition+1,hi);
    }
    //对数组a中，从索引lo到索引hi之间的元素进行分组，并返回分组界限对应的索引
    public static int partition(Comparable[] a,int lo,int hi){
        //确定分界值
        Comparable key =a[lo];
        //定义两个指针，分别指向最小索引处和最大索引处对下一个位置
        int left=lo;
        int right=hi+1;
        //切分
        while (true){
            //从右往左扫描，移动right指针，找到一个比分界值小对元素，停止
            while (less(key,a[--right])){
                if (right == lo){
                    break;
                }
            }
            //从左往右扫描，移动left指针，找到一个比分界值大的元素，停止
            while (less(a[++left],key)){
                if (right == hi) {
                    break;
                }
            }
            //判断left >= right ,如果是，则证明元素扫描完毕，结束循环。如果不是则交换元素即可
            if (left >= right){
                break;
            }else {
                exch(a,left,right);
            }
        }
        //交换分界值，重新找分界值
        exch(a,lo,right);
        return right;
    }

}
