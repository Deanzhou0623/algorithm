package com.itCs520.deanProject.Basic2.linkedList;/*
 *ClassName:SinglyLinkedList
 *Description:
 *@Author:deanzhou
 *@Date:2023/6/15 16:50
 */

import java.util.Iterator;
import java.util.function.Consumer;

public class SinglyLinkedList implements Iterable<Integer>{//整体
    private Node head =null; //头指针



    //节点类
    public static class Node{
        int value; //值
        Node next; //下一个指针

        public Node(int value,Node next){
            this.value = value;
            this.next =next;
        }
    }

    //添加到第一个
    public void addFirst(int value){
        // head为指针 所以 head = newNode（）意味着 head指向xxx
        //1. 链表为空/链表非空
        head = new Node(value,head);
    }

    //遍历链表 (consumer 接收操作 )
    public void loop(Consumer<Integer> consumer){
        Node pointer = head;
        while (pointer!=null){
            consumer.accept(pointer.value);
            pointer=pointer.next;
        }
    }

    //for循环遍历链表
    public void loop2(Consumer<Integer> consumer){
        for (Node pointer = head;pointer!=null;pointer=pointer.next) {
            consumer.accept(pointer.value);
        }
    }


    /*
    * iterator 递归遍历
    * */
    public void loop3(Consumer<Integer> before, Consumer<Integer> after){
        //no sentinel
        recursion(head,before,after);
    }

    private void recursion(Node curr, Consumer<Integer> before, Consumer<Integer> after){ // 某个节点进行操作
        //1 safety verification
        if (curr == null)
            return;

        //2. curr is not null
        before.accept(curr.value);
        recursion(curr.next, before, after);
        after.accept(curr.value);
    }
    //iterator迭代器 遍历
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node pointer =head;
            @Override
            public boolean hasNext() {
                return pointer!=null;
            }

            @Override
            public Integer next() {
                int v=pointer.value;
                pointer = pointer.next;
                return v;
            }
        };
    }

    //递归遍历

    //查找最后一个元素
    public Node findLast(){
        if (head==null)
            return null;

        Node pointer;
        for (pointer=head; pointer.next!=null;pointer=pointer.next){

        }
        return pointer;
    }

    //插入最后一个元素
    public void addLast(int value){
        Node last=findLast();
        //1. 空链表
        if (last==null){
            addFirst(value);
            return;
        }
        //2. 非空链表
        last.next = new Node(value,null);
    }

    //test 获取索引
    /**
    public void test(){
        int i=0;
        for (Node pointer=head; pointer!=null;pointer=pointer.next, i++) {
            System.out.println(pointer.value+" 索引是 "+i);
        }
    }
     */

    //根据index找到findNode
    private Node findNode(int index){
        int i=0;
        for (Node p=head;p!=null;p=p.next, i++) {
            if (i == index){
                return p;
            }
        }
        return null;//node not find
    }
    //返回节点值
    public int get(int index){
        Node node=findNode(index);
        if (node==null){
            illegalIndex(index);
        }
        return node.value;
    }

    //insert element
    public void insert(int index,int value) throws IllegalArgumentException{
        //1.index = 0
        if (index==0){
            addFirst(value);
            return; //不需要继续执行
        }
        //2.index !=0
        Node prev=findNode(index-1);
        if (prev==null){
            illegalIndex(index);
            return;
        }
        prev.next=new Node(value,prev.next);
    }

    public void illegalIndex(int index) {
        throw new IllegalArgumentException(
                String.format("index [%d] illegal index%n",index)
        );
    }

    //removeFirst
    public void removeFirst(){
        if (head==null){
            illegalIndex(0);
        }
        //2. head is not null
        //head 指向 第二个节点
        head=head.next;
    }
    //remove by index
    public void remove(int index){
        //1. index =0
        if (index==0){
            removeFirst();
            return;
        }
        //2.index >0
         //2.1 prev node
        Node prev=findNode(index);
        if (prev==null){
            illegalIndex(index);
        }
        //2. remove node
        Node remove = prev.next;
        if (remove==null){
            illegalIndex(index);
        }
        //3. prev node --> next node
        prev.next = remove.next;
    }

}
