package com.itCs520.deanProject.Basic.Day06.heap;

public class HeapSort4 {
    //判断heap堆中索引i处堆元素是否会小于索引j处的值
    private static boolean less(Comparable[] heap,int i,int j){
        return heap[i].compareTo(heap[j])<0;
    }
    //交换heap堆中i索引处堆值和j索引处堆值
    public static void exch(Comparable[] heap,int i,int j){
        Comparable temp=heap[i];
        heap[i] = heap[j];
        heap[j] = temp;

    }
    //根据原数组构造出堆heap
    private static void createHeap(Comparable[] source,Comparable[] heap){

    }
    //对source数组从小到大进行排序
    public static void sort(Comparable[] source){

    }
    //在heap堆中，对target元素做下沉，范围是0-range
    private static void sink(Comparable[] heap,int target,int range){

    }
}
