package com.itCs520.deanProject.LeetCode;/*
 *ClassName:Change
 *Description:
 *@Author:deanzhou
 *@Date:2023/3/27 15:49
 */

public class Change {
    /*
    * 买柠檬水售价为5 ， 每位顾客向你购买，然后向你支付，5，10，20
    * 必须给每个客户正确找零，一开始你手上没有零钱，如果能正确找零返回true 否则false
    * */
    public static void main(String[] args) {
        System.out.println(change(new int[]{5,5,20}));
        
    }

    private static boolean change(int[] ints) {
        int five = 0;
        int ten = 0;
        for (int bill:ints) {
            if ( bill ==5){//顾客正好给5
                five++;
            }else if (bill ==10){
                if (five ==0){
                    return false;
                }
                five--;
                ten++;
            }else {//20
                if (five>0 && ten >0){
                    five--;
                    ten--;
                }else if (five>=3){
                    five-=3;
                }else {
                    return false;
                }
            }

        }
        return  true ;
    }
}

