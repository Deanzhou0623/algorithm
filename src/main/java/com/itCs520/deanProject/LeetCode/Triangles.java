package com.itCs520.deanProject.LeetCode;/*
 *ClassName:Triangles
 *Description:
 *@Author:deanzhou
 *@Date:2023/3/29 18:23
 */

import java.util.Arrays;

public class Triangles {
    public static void main(String[] args) {
        System.out.println(LargestPerimeter(new int[]{3,6,2,3}));
    }
    /*贪心算法
    * */
    private static int LargestPerimeter(int[] ints) {
        Arrays.sort(ints);
        for (int i = ints.length-1; i >=2 ; i--) {
            if (ints[i-1]+ ints[i-2] > ints[i]){
                return ints[i-1]+ ints[i-2] + ints[i];
            }
        }
        return 0;
    }
}
