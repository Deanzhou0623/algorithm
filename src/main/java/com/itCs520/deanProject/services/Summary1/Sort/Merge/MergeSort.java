package com.itCs520.deanProject.services.Summary1.Sort.Merge;

public class MergeSort {
    //辅助数组
    private static Comparable [] assist;

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
        //1.初始化数组A
        assist = new Comparable[a.length];
        //2.定义变量lo，hi分别用来记录数组中的最小索引和最大索引
        int lo=0;
        int hi=a.length-1;
        //3.调用sort重载方法完成对数组a中的，从索引hi到lo的排序
        sort(a,lo,hi);
    }
    //对数据a中从lo到li的元素进行排序
    public static void sort(Comparable[] a, int lo, int hi){
        //1.安全性校验lo是否大于hi
        if(hi<=lo){
            return;
        }
        //2.对lo到hi进行分组
        int mid=lo+(hi-lo)/2;
        //3.分别对每一组数据进行排序
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        //4.排好序的数组进行归并
        merge(a,lo,mid,hi);

    }
    /*对数组中，从lo到mid为一组，从mid到hi为一组，对这两组数据进行归并
    * */
    public static void merge(Comparable[] a,int lo,int mid,int hi){
        //1.定义三个指针
        int i=lo;
        int p1=lo;
        int p2=mid+1;
        //2.遍历移动指针p1和指针p2，比较对应索引处的值
        while (p1<=mid && p2<=hi){
            //比较对应索引处的值
            if (less(a[p1],a[p2])){
                assist[i++]=a[p1++];
            }else {
                assist[i++]=a[p2++];
            }
        }
        //3.遍历，如果p1的指针没有走完，那么顺序移动p1指针，把对应元素放到辅助数组对应索引上
        while (p1<=mid){
            assist[i++]=a[p1++];
        }
        //4.遍历，如果p2的指针没有走完，那么顺序移动p2指针，把对应元素放到辅助数组对应索引上
        while (p2<=hi){
            assist[i++]=a[p2++];
        }
        //5.把辅助数组的元素拷贝到原数组中
        for (int index = lo; index <=hi; index++) {
            a[index]=assist[index];
        }
    }
}
