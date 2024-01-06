package com.itCs520.deanProject.LeetCode;/*
 *ClassName:Dota2
 *Description:
 *@Author:deanzhou
 *@Date:2023/5/20 12:25
 */

/*
* Author: Dingsong Zhou/ Ryan Schmidt
* Project: Lego robot line tracker and move box
* Date: 2023/5/26
 * */
import java.util.LinkedList;
import java.util.Queue;

public class Dota2 {
    public static void main(String[] args) {
        System.out.println(predicPartyVictory("RDD"));
    }
    //time：O(n)
    public static String predicPartyVictory(String senate){
        //队列模拟
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();
        int length = senate.length();
        for (int i = 0; i < length; i++) {
            if (senate.charAt(i) =='R'){
                //存元素，下标代表顺位
                r.offer(i);
            }else {
                d.offer(i);
            }
        }
        while (!r.isEmpty() && !d.isEmpty()){
            //r方派出的议员 弹出队列下标 下标更小的进行判断
            int rPoll=r.poll();
            //d方派出的议员
            int dPoll=d.poll();
            //如果ban 则不入队 ，如果选择完毕，入队尾
            if (rPoll< dPoll){
                r.offer(rPoll+length); //进入第二轮不能干扰第一轮选择
            }else {
                d.offer(dPoll+length);
            }
        }
        return d.isEmpty()?"R":"D";
    }
}
