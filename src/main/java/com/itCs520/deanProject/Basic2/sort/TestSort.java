package com.itCs520.deanProject.Basic2.sort;/*
 *ClassName:TestSort
 *Description:
 *@Author:deanzhou
 *@Date:2023/7/6 18:35
 */

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;

public class TestSort {

    @Test
    @DisplayName("test bubbleSort")
    public void test1(){
        Integer[] a ={12,56,5,2,5,123,6,9};
        System.out.println(Arrays.toString(a));
        System.out.println("----------------------");
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
