package com.itCs520.deanProject.Basic.Day04.linear;


import java.util.Iterator;

public class TowWayLinkList<T> implements Iterable<T> {
    //记录头结点位置
    private Node head;
    //记录尾结点长度
    private Node last;
    //记录链表长度
    private int N;

    //结点类
    private class Node{
        public Node(T item,Node pre,Node next){
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
            //存储数据
            public T item;
            //指向上一个结点
            public Node pre;
            //指向下一个结点
            public Node next;

    }
    public TowWayLinkList(){
        //初始化头结点和尾结点
        //头结点
        this.head=new Node(null,null,null);
        //尾结点
        this.last=null;
        //初始化元素个数
        this.N=0;
    }

    //清空链表
    public void clear(){
        /*//头结点的next域不指向下一个结点即可
        this.head.next=null;
        //尾结点为空
        this.last=null;
        this.N=0;*/
        //头结点不指向下一个结点
        this.head.next=null;
        //尾结点为空
        this.last=null;
        //链表长度为空
        this.N=0;
    }

    //获取链表长度
    public int length(){
        return N;
    }
    //判断线性表是否为空表
    public boolean isEmpty(){
        return N==0;
    }

    //获取第一个元素
    public T getFirst(){
        if (isEmpty()){
            return null;
        }
        return head.next.item;
    }
    //获取最后一个元素
    public T getLast(){
        if (isEmpty()){
            return null;
        }
        return last.item;
    }
    //获取指定位置的值
    public T get(int i){
        //通过循环从头结点的下一个结点开始找 ，依次找i次，就可以找到对应的元素
//        Node n=head.next;
//        for (int index = 0; index < i; index++) {
//            n=n.next;
//        }
//        return n.item;
        Node n=head.next;
        for (int index = 0; index <i ; index++) {
            n = n.next;
        }
        return n.item;
    }

    //向链表中添加元素T
    public void insert(T t){
//        if (isEmpty()){
//            //链表为空的情况
//            //创建新结点
//            Node newNode = new Node(t, head, null);
//            //让新结点成为尾结点
//            last=newNode;
//            //让头结点指向尾结点
//            head.next=last;
//        }else {
//            //链表不为空
//            Node oldLast = last;
//            //创建新结点
//            Node newNode = new Node(oldLast, t, null);
//            //让当前的尾结点指向新结点
//            oldLast.next=newNode;
//            //让当前新结点称为尾结点
//            last=newNode;
//        }
//        //元素个数加1
//        N++;
        //链表为空的情况
        if (isEmpty()) {
            Node newNode = new Node(t, head, null);
            //让新结点成为尾结点
            last = newNode;
            //头结点指向尾结点
            head.next = last;
        }else {
            //链表不为空的情况
           Node oldLast=last;
           //创建新的接待你
            Node newNode = new Node(t, oldLast, null);
            //当前尾结点指向新结点
            oldLast.next =newNode;
            //新结点称为尾结点
            last=newNode;
        }
        //元素个数+1
        N++;

    }

    //在i位置插入指定元素t
    public void insert(int i,T t){
       /* //找到i位置的前一个结点
        Node pre=head;
        for (int index = 0; index <i ; index++) {
            pre=pre.next;
        }
        //找到i位置的结点
        Node curr=pre.next;
        //创建新结点
        Node newNode = new Node(t,pre,curr);
        //原来i位置的前一个结点指向新结点即可
        pre.next=newNode;
        //让i位置的前一个结点变为新结点
        curr.pre=newNode;
        //元素个数加1
        N++;*/
        //找到i前面一个元素位置
        Node pre=head;
        for (int index = 0; index <i-1 ; index++) {
            pre=pre.next;
        }
        //找到i位置
        Node curr=pre.next;
        //创建新的结点
        Node newNode = new Node(t,pre,curr);
        //原来位置指向新结点
        pre.next=newNode;
        //i位置的前一个结点变为新结点
        curr.pre=newNode;
        //元素个数+1
        N++;
    }
    //删除元素i
    public T remove(int i){
        //找到i位置的前一个结点
        Node pre=head;
        for (int index = 0; index < i-1; index++) {
            pre=pre.next;
        }
        //找到i位置结点
        Node curr=pre.next;
        //i位置的下一个结点
        Node nextNode=curr.next;
        //让i位置的前一个结点的下一个结点变为i位置的下一个结点
        pre.next=nextNode;
        //让i位置的下一个结点的上一个结点变为i位置的前一个结点
        nextNode.pre=pre;
        //元素个数-1
        N--;
        return curr.item;
    }

    //查找元素t在链表中第一次出现的位置
    public int indexOf(T t){
        //从头结点开始，依次找到每一个头结点，取出item，和t进行比较，如果相同则找到了
        Node n = head;
        for (int index = 0; n.next!=null ; index++) {
            n=n.next;
            if (n.item.equals(t)){
                return index;
            }
        }
            return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new TIterator();
    }
    private class TIterator implements Iterator{
        private Node n;
        private TIterator(){
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
