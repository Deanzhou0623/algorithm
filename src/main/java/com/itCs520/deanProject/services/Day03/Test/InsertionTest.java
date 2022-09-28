package com.itCs520.deanProject.services.Day03.Test;

import com.itCs520.deanProject.services.Day03.Bubble;
import com.itCs520.deanProject.services.Day03.Insertion;

import java.util.Arrays;

public class InsertionTest {
    public static void main(String[] args) {
        Integer[] arr={4,3,2,10,12,1,5,6};
        Insertion.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
