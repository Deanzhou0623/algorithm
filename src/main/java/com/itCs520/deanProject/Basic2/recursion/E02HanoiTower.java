package com.itCs520.deanProject.Basic2.recursion;/*
 *ClassName:E02HanoiTower
 *Description:
 *@Author:deanzhou
 *@Date:2023/7/12 13:53
 */

import java.util.LinkedList;

public class E02HanoiTower {
    /*
    *   汉娜塔
    *
    *       --    圆盘1        三根柱子
    *      ----   圆盘2           -           -           -
    *     ------  圆盘3           -           -           -
    *    -------- 圆盘4           -           -           -
    *
    *   圆盘在第一根柱子上 ：一次只能移动一个圆盘/小圆盘上面不能放大圆盘
    *   移到第三根柱子上：
    * */

    //1. LinkedList模拟三个柱子
     static LinkedList<Integer> a = new LinkedList<Integer>();
     static LinkedList<Integer> b = new LinkedList<Integer>();
     static LinkedList<Integer> c = new LinkedList<Integer>();

     //2. 3,2 ,1 init
    static void init(int n){
        for (int i = n; i >=1 ; i--) {
            a.addLast(i);
        }
    }

    /**
     *
     * @param n - 圆盘个数
     * @param a - 源
     * @param b - 借
     * @param c - 目
     */

    static void move(int n,LinkedList<Integer> a,
                     LinkedList<Integer> b,
                     LinkedList<Integer> c){
        if (n==0){
            return;
        }
        move(n-1,a,c,b);
        c.addLast(a.removeLast()); //中间
        print();
        move(n-1,b,a,c);
    }

    public static void main(String[] args) {
        init(3);
        print();
        move(3,a,b,c);
    }

    private static void print() {
        System.out.println("---------------");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
