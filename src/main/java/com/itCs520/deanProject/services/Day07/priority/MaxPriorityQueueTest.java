package com.itCs520.deanProject.services.Day07.priority;

public class MaxPriorityQueueTest {
    public static void main(String[] args) {
        //创建优先队列
        MaxpriorityQueue<String> queue = new MaxpriorityQueue<>(10);
        //往队列中存储元素
        queue.insert("A");
        queue.insert("B");
        queue.insert("C");
        queue.insert("D");
        queue.insert("E");
        queue.insert("F");
        queue.insert("G");

        //通过循环从队列中获取最大元素
        while (!queue.isEmpty()){
            String max= queue.delMax();
            System.out.print(max+" ");
        }

    }
}
