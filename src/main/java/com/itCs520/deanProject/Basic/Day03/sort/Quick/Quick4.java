package com.itCs520.deanProject.Basic.Day03.sort.Quick;/*
 *ClassName:Quick4
 *Description:
 *@Author:deanzhou
 *@Date:2023/4/10 21:01
 */

public class Quick4 {
    //1. compareTo
    private static boolean less(Comparable v,Comparable w ){
        return v.compareTo(w)<0;
    }
    //2. exchange
    private static void exch(Comparable[] a,int i,int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    //3. sort
    private static void sort(Comparable[] a){
        int lo=0;
        int hi=a.length;
        sort(a,lo,hi);
    }
    //4. sort from lo to hi
    private static void sort(Comparable[] a,int lo,int hi){
        //1.安全性校验
        if (lo>hi)
            return;
        //2. 需要对数组lo到hi的元素进行分组
        int partition = partition(a,lo,hi);
        //3. sort left array
        sort(a,lo,partition-1);
        //4. sort right array
        sort(a,partition+1,hi);

    }
    //5. partition separate the group (对索引从lo到hi的元素进行分组，并返回分组界限所对应的索引)
    private static int partition(Comparable[] a,int lo,int hi){
        //1. 确定分界值
        Comparable key =a[lo];
        //2. 定义两个指针，分别指向元素的最小索引和最大索引的下一个位置
        int left=lo;
        int right =hi+1;

        //3. 切分
        while (true){
            //3.1 从右往左进行扫描，移动指针right，找到一个比分界值小的元素
            while (less(key,a[--right])){
                if (right ==lo){
                    break;
                }
            }
            //3.2 从左往右扫描，移动指针left,找到一个比分界值大的元素
            while (less(a[++left],key)){
                if (left==hi){
                    break;
                }
            }
            //3.3 判断left > right ，如果是，则证明元素扫描完毕,结束循环。如果不是，则交换元素
            if (left>=right){
                break;
            }else {
                exch(a,left,right);
            }
        }
            //4. 交换分界值
            exch(a,lo,right);
        return right;
    }
}
