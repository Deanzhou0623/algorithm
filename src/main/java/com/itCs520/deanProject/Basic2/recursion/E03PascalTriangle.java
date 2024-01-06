package com.itCs520.deanProject.Basic2.recursion;/*
 *ClassName:E03PascalTriangle
 *Description:
 *@Author:deanzhou
 *@Date:2023/7/16 14:31
 */

import com.sun.org.apache.regexp.internal.RE;

public class E03PascalTriangle {

    /*
    *  1                        8
    *  1  1                     6       (n-1-i)*2
    *  1  2  1                  4
    *  1  3  3  1               2
    *  1  4  6  4  1            0
    *
    * i行，j列 [i][j] [i-1][j-1] + [i-1][j]
    * j = 0 , i = j [i][j] = 1
    * */
    private static int element(int i,int j){
        if (j ==0 || i==j)
            return 1;
        return element(i-1,j-1)+element(i-1,j);
    }

    private static void printSpace(int n,int i){
        int num = (n-1-i)*2;
        for (int j = 0; j < num; j++) {
            System.out.print(" ");
        }
    }

    public static void print(int n){
        for (int i = 0; i < n; i++) {
            printSpace(n,i);
            for (int j = 0; j <=i ; j++) {
                System.out.printf("%-4d",element(i,j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        print2(5);
    }

    /*
    *  改进： 二维数组 存储数据 避免重复计算
    *
    * */
    private static int element1(int[][] triangle,int i,int j){
        if (triangle[i][j]>0){
            return triangle[i][j];
        }

        if (j ==0 || i==j) {
            triangle[i][j] = 1;
            return 1;
        }
        triangle[i][j] = element1(triangle,i-1,j-1)+element1(triangle,i-1,j);
        return triangle[i][j];
    }


    public static void print1(int n){
        //二维数组
        int[][] triangle = new int[n][];
        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i+1];
            for (int j = 0; j <=i ; j++) {
                System.out.printf("%-4d",element1(triangle,i,j));
            }
            System.out.println();
        }
    }

    /*
    *
    * 改进3： 改进 用 数组存储 减少内存空间
    * */
    private static void createRow(int[] row,int i){
        //1. 第0行
        if ( i==0){
            row[0] = 1;
            return;
        }

        //2. 不是0行
        for (int j = i; j >0 ; j--) {
            row[j] = row[j]+row[j-1];
        }
    }

    public static void print2(int n){
        //二维数组
//        int[][] triangle = new int[n][];
        int[] row = new int[n];
        for (int i = 0; i < n; i++) {
//
            createRow(row,i);
            for (int j = 0; j <=i ; j++) {
                System.out.printf("%-4d",row[j]);
            }
            System.out.println();
        }
    }
}
