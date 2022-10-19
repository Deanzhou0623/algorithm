package com.itCs520.deanProject.services.Summary1.Sort.Insertion;

public class InsertionSort {
    //交换元素
    public static void exch(Comparable[] a,int i, int j){
        Comparable temp;
        temp = a[i] ;
        a[i] = a[j] ;
        a[j] = temp ;


    }
    //比较元素
    public static boolean greater(Comparable v ,Comparable w){
        return v.compareTo(w) > 0;
    }

    //排序
    public static void sort(Comparable[] a){
        //1.排序范围从第二个元素开始，第一个元素默认已排好序
        for (int i = 1; i <a.length ; i++) {
            //2. 未排序元素需要依次和前面已排序元素进行比较
            for (int j = i; j >0 ; j--) {
                //3.比较小则交换排序
                if (greater(a[j-1],a[j])){
                    //前面大的元素和后面小的元素进行置换
                    exch(a,j-1,j);
                }else {
                    break;
                }
            }
        }


    }
}
