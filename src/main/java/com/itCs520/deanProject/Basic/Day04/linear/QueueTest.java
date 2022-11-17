package com.itCs520.deanProject.Basic.Day04.linear;

import com.itCs520.deanProject.Basic.Day04.linear.Queue;

public class QueueTest {
    public static void main(String[] args) {
        //创建栈对象
        com.itCs520.deanProject.Basic.Day04.linear.Queue<String> q = new Queue<>();

        //测试压栈
        q.enqueue("a");
        q.enqueue("b");
        q.enqueue("c");
        q.enqueue("d");

        for (String item : q) {
            System.out.println("入队顺序："+item);
        }
        System.out.println("------------------------------");
        //测试弹栈
        String result = q.dequeue();
        System.out.println("出队元素是"+result);
        System.out.println("剩下元素个数为"+q.size());
    }
}
