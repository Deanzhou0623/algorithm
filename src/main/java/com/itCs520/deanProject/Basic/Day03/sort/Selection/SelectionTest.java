package com.itCs520.deanProject.Basic.Day03.sort.Selection;

import com.itCs520.deanProject.Basic.Day03.sort.Selection.Selection3;

import java.util.Arrays;

public class SelectionTest {
    public static void main(String[] args) {
        //原始数据
        Integer[] arr={4,6,8,7,9,2,10,1};
        Selection3.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
