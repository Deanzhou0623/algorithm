package com.itCs520.deanProject.Basic.Day07.priority;

import com.itCs520.deanProject.Basic.Day07.priority.MinpriorityQueue;

public class MinPriorityQueueTest {
    public static void main(String[] args) {
        //创建优先队列
        com.itCs520.deanProject.Basic.Day07.priority.MinpriorityQueue<String> queue = new MinpriorityQueue<>(10);
        //往队列中存储元素
        queue.insert("A");
        queue.insert("B");
        queue.insert("C");
        queue.insert("D");
        queue.insert("E");
        queue.insert("F");
        queue.insert("G");

        //通过循环从队列中获取最小元素
        while (!queue.isEmpty()){
            String min= queue.delMin();
            System.out.print(min+" ");
        }

    }
}
