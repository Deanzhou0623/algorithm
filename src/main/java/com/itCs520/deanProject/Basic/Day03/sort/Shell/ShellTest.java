package com.itCs520.deanProject.Basic.Day03.sort.Shell;

import com.itCs520.deanProject.Basic.Day03.sort.Shell.Shell;

import java.util.Arrays;

public class ShellTest {
    public static void main(String[] args) {
        //原始数据
        Integer[] arr={9,1,2,5,7,4,8,6,3,5};
        Shell.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
