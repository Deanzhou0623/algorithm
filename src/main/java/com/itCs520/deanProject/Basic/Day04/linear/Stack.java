package com.itCs520.deanProject.Basic.Day04.linear;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    //记录头结点位置
    private Node head;
    //记录链表长度
    private int N;

    //结点类
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
    //构造方法
    public Stack(){
        this.head=new Node(null,null);
        this.N=0;
    }

    //判断是否为空
    public boolean isEmpty(){
        return N==0;
    }

    //判断栈中的元素个数
    public int size() {
        return N;
    }

    //弹出栈顶元素
    public T pop(){
        //找到首结点的第一个结点
        Node oldFirst=head.next;
        if (oldFirst==null){
            return null;
        }
        //让首结点指向原来第一个结点的下一个结点
        head.next=oldFirst.next;
        //元素个数-1
        N--;
        return oldFirst.item;
    }
    //向栈中压入元素t
    public void push(T t) {
        //找到首结点指向的第一个结点
          Node oldFirst=head.next;
        //创建新结点
        Node newNode = new Node(t, null);
        //让首结点指向新结点
        head.next=newNode;
        //让新结点指向原来的第一个结点
        newNode.next=oldFirst;
        //元素个数++
        N++;
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }
    private class SIterator implements Iterator{
        private Node n;
        private SIterator(){
            this.n=head;
        }

        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public Object next() {
            n=n.next;
            return n.item;
        }

        @Override
        public void remove() {

        }
    }
}
