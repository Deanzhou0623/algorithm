package com.itCs520.deanProject.services.Day03.Test;

import com.itCs520.deanProject.services.Day03.Selection;
import com.itCs520.deanProject.services.Day03.Shell;

import java.util.Arrays;

public class ShellTest {
    public static void main(String[] args) {
        //原始数据
        Integer[] arr={9,1,2,5,7,4,8,6,3,5};
        Shell.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
