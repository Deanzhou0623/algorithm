package com.itCs520.deanProject.services.Day03.Test;

import com.itCs520.deanProject.services.Day03.Bubble;
import com.itCs520.deanProject.services.Day03.Selection;

import java.util.Arrays;

public class SelectionTest {
    public static void main(String[] args) {
        //原始数据
        Integer[] arr={4,6,8,7,9,2,10,1};
        Selection.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
