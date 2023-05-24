package com.itCs520.deanProject.LeetCode;/*
 *ClassName:TicTacToe
 *Description:
 *@Author:deanzhou
 *@Date:2023/5/10 14:19
 */

public class TicTacToe {
    public static void main(String[] args) {
        System.out.println(vaildBoard(new String[]{"XXX","OXO","O O"}));
    }

    //board
    private static boolean vaildBoard(String[] board) {
        //1. x 赢
        //2. o 赢
        //3. 平局
        int xCount = 0;
        int oCount = 0;
        // 计算二维数组中 x有多少个/o有多少个
        for (String row:board) {
            for (char c: row.toCharArray()) {
                if (c == 'X'){
                    xCount++;
                }else if (c == 'O'){
                    oCount++;
                }
            }
        }
        //3. 第三种情况
        if (xCount != oCount && xCount - oCount !=1 )
            return false;
        //x win
        if (win(board,"XXX") && xCount - oCount !=1){
            return false;
        }
        // o win
        if (win(board,"OOO") && xCount - oCount !=0){
            return false;
        }
        return true;
    }


    static boolean win(String[] board,String flag){
        /* 情况 1：
        *           x  o  o
        *           x  x  o
        *           x  o  o
        *
        * 情况 2：
         *           o  o  o
         *           o  x  o
         *           x  o  x
        * */
        for (int i = 0; i < 3; i++) {
            //col 对应情况1
            if (flag.equals("" + board[0].charAt(i)+ board[0].charAt(i)+ board[0].charAt(i))){
                return true;
            }
            //row 对应情况2
            if (flag.equals(board[i])){
                return true;
            }
        }

        // / 情况
        if (flag.equals("" + board[0].charAt(2)+ board[0].charAt(1)+ board[0].charAt(0))){
            return true;
        }
        // \ 情况
        if (flag.equals("" + board[0].charAt(0)+ board[0].charAt(1)+ board[0].charAt(2))){
            return true;
        }
        return false;
    }
}
