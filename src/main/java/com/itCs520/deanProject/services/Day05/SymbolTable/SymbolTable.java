package com.itCs520.deanProject.services.Day05.SymbolTable;

public class SymbolTable <Key,Value>{
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

        public Node(Key key,Value value,Node next){
            this.key=key;
            this.value=value;
            this.next=next;
        }
    }

    public SymbolTable(){
        this.head=new Node(null,null,null);
        this.N=0;
    }

    //获取符号表中键值对个数
    public int size(){
        return N;
    }
    //往符号表中插入键值对
    public  void put(Key key, Value val){
        //如果符号表中已经存在键值对，那么只需要找到该结点，替换为value
        Node n=head;
        while (n.next!=null){
            //变换n
            n=n.next;
            //判断n的存储值是否为key的键值对，只需要创建新结点，保存要插入的键值对，把新结点插入到链表的头部
            if (n.key.equals(key)){
                n.value=val;
                return;
            }
        }
        //如果符号中不存在键为key的键值，只需要创新新结点，保存要插入的键值对，把新结点插入到链表的头部
        Node newNode = new Node(key,val,null);
        Node oldFirst=head.next;
        newNode.next=oldFirst;
        head.next=newNode;
        //元素个数++
        N++;
    }
    //删除键为key的键值对
    public void delete(Key key){
        //找到键为key的n结点，把该结点从链表中删除
        Node n=head;
        while (n.next!=null){
            //判断n结点的下一个结点的键是否为key，如果是则删除该结点
            if (n.next.key.equals(key)){
                n.next=n.next.next;
                N--;
                return;
            }

            //变换n
            n=n.next;
        }

    }

    //根据键值key，找到对应的值
    public Value get (Key key){
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
