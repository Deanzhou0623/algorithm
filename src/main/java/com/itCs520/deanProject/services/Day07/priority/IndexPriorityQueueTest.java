package com.itCs520.deanProject.services.Day07.priority;

public class IndexPriorityQueueTest {
    public static void main(String[] args) {
        //创建优先队列
        IndexPriorityQueue<String> queue = new IndexPriorityQueue<>(10);
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
