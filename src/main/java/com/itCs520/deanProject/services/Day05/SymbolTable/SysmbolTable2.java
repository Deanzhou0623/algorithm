package com.itCs520.deanProject.services.Day05.SymbolTable;

import com.itCs520.deanProject.services.Day06.heap.Heap;

public class SysmbolTable2 <Key,Value> {
    //记录首结点
    private Node head;
    //记录符号表中的元素个数
    private int N;

    private class Node{
        //键
        public Key key;
        //值
        public Value value;
        //下一个结点
        public Node next;

        public Node(Key key, Value value, Node next){
            this.key=key;
            this.value=value;
            this.next=next;
        }
    }

    public SysmbolTable2(){
        this.head=new Node(null,null,null);
        this.N=0;
    }

    //获取符号标志键值对个数
    public int size(){
        return N;
    }

    //往符号表中插入键值对
    public void put(Key key,Value value){
        //1.如果符号表中已经存在该值，那么只需要找到该点，替换为value
        Node n=head;
        while (n.next!=null){//循环查找键为key的值
            //变换n
            n=n.next;
            //判断n的存储值是否为key的键值对，如果是，只需要将value值付给n
            if (n.equals(key)){
                n.value=value;
                return;
            }
        }
        //2.如果符号中不存在键为key的键值，那么需要创造新结点，保存插入键值对，新结点插入到链表头部
        Node newNode = new Node(key, value, null);
        Node oldFirst = head.next;
        newNode.next=oldFirst;
        head.next = newNode;
        //元素+1
        N++;
    }

    //删除键为key的键值对
    public void delete(Key key){
        //1. 找到key为n的结点，把该结点从链表中删除
        Node n=head;
        while (n.next!=null){
            //2. 判断n结点的下一个结点键是否为key
            if (n.next.key.equals(key)){
                n.next=n.next.next;
                N--;
                return;
            }
            //变换n
            n=n.next;

        }
    }

    //根据键值key,找到对应的值
    public Value get(Key key){
        //找到键为key的结点
        Node n=head;
        while (n.next!=null){
            //变换n
            n=n.next;
            if (n.key.equals(key)){
                return n.value;
            }
        }
        return null;
    }
}
