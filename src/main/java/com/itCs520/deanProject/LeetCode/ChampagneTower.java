package com.itCs520.deanProject.LeetCode;/*
 *ClassName:ChampagneTower
 *Description:
 *@Author:deanzhou
 *@Date:2023/5/7 20:33
 */

public class ChampagneTower {
    public static void main(String[] args) {
        System.out.println(champagneTower(5,2,1));
    }

    public static double champagneTower(int poured,int query_row,int query_glass){
        double[][] ca = new double[100][100];
        ca[0][0] = poured;

        //模拟倒酒
        for (int r = 0; r <= query_row; r++) {
            for (int l = 0; l <=r; l++) {
                double d = (ca[l][r] - 1.0)/2;
                //d 大于0 溢出
                if (d>0){
                    ca[r+1][l] +=d;
                    ca[r+1][l+1] +=d;
                }
            }
        }
        //可能超过1
        return Math.min(1,ca[query_row][query_glass]);
    }
}
