package com.itCs520.deanProject.LeetCode;/*
 *ClassName:StringSearch
 *Description:
 *@Author:deanzhou
 *@Date:2023/5/15 14:33
 */

public class StringSearch {
    /*给定两个字符串A，B ，判断B中是否有A存在，存在返回A中的下标
    不存在的返回-1

    例如：A: ABCABCAABCABCD
         B: ABCABCD
         返回值：7
    * */

    public static void main(String[] args) {

    }

    //1.BF 算法 - 暴力解法，循环遍历每一个 O(m*n)
     private int BFSearch(String pat,String txt){
        int m = pat.length();
        int n = txt.length();
        //转换成字符串
         char[] Pat = pat.toCharArray();
         char[] Txt = txt.toCharArray();
         for (int i = 0; i < n-m; i++) {
             for (int j = 0; j <m; j++) {
                 if (Pat[j]!= Txt[i+j]){
                        break;
                 }
                 //pat全部匹配
                 if (j == m) return  i;
             }
         }
         //txt中不存在pat 子串
         return -1;
     }
    //2.RK 算法 - hash + BF（当遇到两个hash值相同的时候，退化为bf算法） O（N）

    /*3. BM算法
     1. 坏字符规则 ：从右往左匹配 ，找到A中第一个不匹配的字符
     2. 好后缀规则 ：

    * */

}
