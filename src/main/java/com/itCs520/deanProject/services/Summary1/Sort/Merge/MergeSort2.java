package com.itCs520.deanProject.services.Summary1.Sort.Merge;

public class MergeSort2 {
    //辅助数组
    public static Comparable[] assist;
    //比较
    public static boolean less(Comparable v,Comparable w){

        return v.compareTo(w)<0;
    }
    //交换
    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp;
        temp= a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    //对A组内数据进行排序
    public static void sort(Comparable[] a){
        //1 初始化数组
        assist=new Comparable[a.length];
        //2 定义两个变量定义索引最小值和最大值
        int lo=0;
        int hi=a.length-1;
        //3 对数组进行排序
        sort(a,lo,hi);
    }
    //对A组数据从lo到mid，从mid+1到hi排序
    public static void sort(Comparable[] a,int lo,int hi){
        //1 安全性校验
        if (hi<=lo){
            return;
        }
        //2 找出lo到hi的中间值
        int mid=lo+(hi-lo)/2;
        //3 对lo到mid，和mid+1到hi进行排序
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        //4 对排序好的数组进行归并
        merge(a,mid,lo,hi);

    }
    //对排好序对数据进行合并
    public static void merge(Comparable[] a,int mid,int lo,int hi){
        //1 定义三个指针
        int i=lo; //辅助数组下标
        int p1=lo;
        int p2=mid+1;
        //2 遍历指针p1和p2，小的元素放入辅助数组
        while (p1<=mid && p2<=hi){
            if (less(a[p1],a[p2])){
                assist[i++]=a[p1++];
            }else {
                assist[i++]=a[p2++];
            }
        }
        //3 遍历，如果p1没有遍历完，则继续移动p1指针，对应元素放置在对应索引处
        while (p1<=mid){
            assist[i++]=a[p1++];
        }
        //4 遍历，如果p2没有遍历完，则继续移动p2指针，对应元素放置在对应索引处
        while (p2<=hi){
            assist[i++]=a[p2++];
        }
        //5 将辅助数组元素复制到原数组
        for (int index = lo; index <=hi; index++) {
            a[index]=assist[index];
        }
    }
}
