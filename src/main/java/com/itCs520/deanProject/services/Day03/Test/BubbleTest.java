package com.itCs520.deanProject.services.Day03.Test;

import com.itCs520.deanProject.services.Day03.Bubble;
import com.itCs520.deanProject.services.Day03.Bubble2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BubbleTest {
    public static void main(String[] args) {
        Integer[] arr={4,5,6,3,2,1};
        Bubble2.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
