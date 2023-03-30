package com.itCs520.deanProject.Basic.Day06.heap;

import com.itCs520.deanProject.Basic.Day06.heap.HeapSort;

import java.util.Arrays;

public class HeapSortTest {
    public static void main(String[] args) {
        //待排序数组
        String[] arr={"S","O","R","T","E","X","A","M","P","L","E"};
        //通过heapSort对数组进行排序
        HeapSort3.sort(arr);
        //打印排序后的元素
        System.out.println(Arrays.toString(arr));
    }
}
