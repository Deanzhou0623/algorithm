package com.itCs520.deanProject.Basic.Day04.linear;


import java.util.Iterator;

public class LinkList <T> implements Iterable<T>{
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

        public Node(T item,Node next){
            this.item=item;
            this.next=next;
        }
    }
    public LinkList(){
        //初始化头结点
        this.head  = new Node(null,null);
        //初始化元素个数
        this.N=0;
    }

    //清空链表
    public void clear(){
        head.next = null;
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

    //获取指定位置的值
    public T get(int i){

        //通过循环从头结点开始找，依次找i
        Node n = head.next;
        for (int index = 0; index < i; index++) {
            n=n.next;
        }
        return n.item;
    }

    //向链表中添加元素T
    public void insert(T t){
        Node n=head;
        while (n.next!=null){
            //找到最后一个结点
            n=n.next;
        }
        //创建新结点保存元素T
        Node newNode = new Node(t, null);
        //让最后一个结点指向新结点
        n.next=newNode;
        //元素个数需要增长
        N++;
    }

    //在i位置插入指定元素t
    public void insert(int i,T t){

        //找到i位置的前一个结点
        Node pre=head;
        for (int index = 0; index < i-1; index++) {
            pre=pre.next;
        }
        //找到i结点位置
        Node curr=pre.next;
        //创建一个新结点
        Node newNode = new Node(t, curr);
        //原来i位置前面一个结点指向新结点
        pre.next=newNode;
        //元素个数加1
        N++;
    }
    //删除元素i
    public T remove(int i){
        Node pre=head;
        for (int index = 0; index <i-1 ; index++) {
            pre=pre.next;
        }
        //找到i位置的结点
        Node curr=pre.next;
        //i结点的下一个位置
        Node nextNode = curr.next;
        pre.next=nextNode;
        //元素个数-1
        N--;
        return curr.item;
    }

    //查找元素t在链表中第一次出现的位置
    public int indexOf(T t){
        //从头结点开始，依次找到每一个头结点，取出item，和t进行比较，如果相同则找到了
       /* Node n = head;
        for (int index = 0; n.next!=null ; index++) {
            n=n.next;
            if (n.item.equals(t)){
                return index;
            }
        }
            return -1;*/
        Node n=head;
        for (int index = 0; n.next!=null; index++) {
            n=n.next;
            if (n.item.equals(t)){
                return index;
            }

        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new LIterator();
    }
    private class LIterator implements Iterator{
        private Node n;
        private LIterator(){
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

    //用来反转整个链表
    public void reverse(){
        //判断当前链表是否为空链表，如果是空链表，则结束运行，如果不是，则调用重载的reverse方法完成反转
        if(isEmpty()){
            return;
        }
        reverse(head.next);
    }

    //反转指定结点，并把结点返回
    public Node reverse(Node curr){
        if (curr.next==null){
            head.next=curr;
            return curr;
        }
        //递归反转curr的下一个结点：返回值就是链表反转后，当前结点的上一个结点
        Node pre=reverse(curr.next);
        //让返回结点的下一个结点变为当前结点curr
        pre.next=curr;
        //把当前结点的下一个结点变为null
        curr.next=null;
        return curr;
    }
}
