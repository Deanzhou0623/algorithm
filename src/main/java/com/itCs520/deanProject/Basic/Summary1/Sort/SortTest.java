package com.itCs520.deanProject.Basic.Summary1.Sort;

import com.itCs520.deanProject.Basic.Summary1.Sort.Quick.QuickSort2;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        Integer[] arr={4,5,6,3,2,1,23,754,2125,7745543,43,321,456,909};
        QuickSort2.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
