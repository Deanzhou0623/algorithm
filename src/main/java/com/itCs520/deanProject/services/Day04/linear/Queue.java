package com.itCs520.deanProject.services.Day04.linear;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {
    //记录头结点位置
    private Node head;
    //记录链表长度
    private int N;
    //记录最后一个结点
    private Node last;

    private class Node{
        //存储数据
        T item;
        //下一个结点
        Node next;

        public Node(T item, Node next){
            this.item=item;
            this.next=next;
        }
    }

    public Queue(){
        this.head = new Node(null,null);
        this.last = null;
        this.N = 0;

    }
    //判断队列是否为空
    public boolean isEmpty(){
        return N==0;
    }

    //获取队列中的元素个数
    public int size(){
        return N;
    }

    //从队列中获取一个元素
    public T dequeue(){
        //队列为空
        if (isEmpty()){
            return null;
        }
            //不为空
        Node oldFirst = head.next;
        //获得头结点下一个元素的下一个元素
        head.next = oldFirst.next;
        N--;
            //出队列实质是删除元素，如果队列元素为空，则需要重置last
        if (isEmpty()){
            last=null;
        }
        return oldFirst.item;
        }


    //往队列中插入一个元素
    public void enqueue(T t){
        if (last == null){
           //当前尾结点为null
           last = new Node(t,null);
           head.next=last;
        }else {
            //当前尾结点last不为null
            Node oldlast=last;
            last=new Node(t,null);
            oldlast.next=last;
        }
        //元素个数增加
        N++;
    }

    @Override
    public Iterator<T> iterator() {
        return new QIterator();
    }
    private class QIterator implements Iterator {
        private Node n;

        private QIterator() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }

        @Override
        public void remove() {

        }
    }
}
