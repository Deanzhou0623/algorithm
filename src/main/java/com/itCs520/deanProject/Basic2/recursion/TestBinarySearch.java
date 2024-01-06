package com.itCs520.deanProject.Basic2.recursion;/*
 *ClassName:TestBinarySearch
 *Description:
 *@Author:deanzhou
 *@Date:2023/7/6 18:07
 */

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class TestBinarySearch {

    @Test
    @DisplayName("测试 binarySearch")
    public void test1(){
        int[] a={12,33,56,78,116,145,268};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.search(a, 78));
    }
}
