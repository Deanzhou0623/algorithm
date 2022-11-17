package com.itCs520.deanProject.Basic.Day03.sort.Bubble;

import com.itCs520.deanProject.Basic.Day03.sort.Bubble.Bubble3;

import java.util.Arrays;

public class BubbleTest {
    public static void main(String[] args) {
        Integer[] arr={4,5,6,3,2,1};
        Bubble3.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
