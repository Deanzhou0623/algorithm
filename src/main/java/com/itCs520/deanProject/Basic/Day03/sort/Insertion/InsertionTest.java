package com.itCs520.deanProject.Basic.Day03.sort.Insertion;

import com.itCs520.deanProject.Basic.Day03.sort.Insertion.Insertion3;

import java.util.Arrays;

public class InsertionTest {
    public static void main(String[] args) {
        Integer[] arr={4,3,2,10,12,1,5,6};
        Insertion3.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
