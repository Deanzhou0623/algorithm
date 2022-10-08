package com.itCs520.deanProject.services.Day03.Bubble;

import java.util.Arrays;

public class BubbleTest {
    public static void main(String[] args) {
        Integer[] arr={4,5,6,3,2,1};
        Bubble3.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
