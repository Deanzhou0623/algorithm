package com.itCs520.deanProject.Basic.Day07.priority;

import com.itCs520.deanProject.Basic.Day07.priority.IndexMinPriorityQueue;

public class IndexPriorityQueueTest {
    public static void main(String[] args) {
        //创建优先队列
        com.itCs520.deanProject.Basic.Day07.priority.IndexMinPriorityQueue<String> queue = new IndexMinPriorityQueue<>(10);
        //往队列中存储元素
        queue.insert(0,"A");
        queue.insert(2,"B");
        queue.insert(1,"C");

        //测试修改
        queue.changeItem(2,"D");


        //通过循环从队列中获取最大元素
        while (!queue.isEmpty()){
            int index= queue.delMin();
            System.out.print(index+" ");
        }

    }
}
