package com.itCs520.deanProject.Basic.Day03.sort.Merge;

import com.itCs520.deanProject.Basic.Day03.sort.Merge.Merge;

import java.util.Arrays;

public class MergeTest {
    public static void main(String[] args) {
        Integer[] arr={8,4,5,7,1,3,6,2};
        Merge.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
