package com.itCs520.deanProject.services.Day03.Quick;

import com.itCs520.deanProject.services.Day03.Quick.Quick;

import java.util.Arrays;

public class QuickTest {
    public static void main(String[] args) {
        Integer[] arr={6 , 1 , 2 , 7 , 9 , 3 , 4 , 5 , 8 };
        Quick.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
