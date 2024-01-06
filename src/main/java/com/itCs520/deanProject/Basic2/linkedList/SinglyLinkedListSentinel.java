package com.itCs520.deanProject.Basic2.linkedList;/*
 *ClassName:SinglyLinkedList
 *Description:
 *@Author:deanzhou
 *@Date:2023/6/15 16:50
 */

import java.util.Iterator;
import java.util.function.Consumer;

public class SinglyLinkedListSentinel implements Iterable<Integer>{//整体
    //优化 头指针指向sentinel node
    private Node head =new Node(-1,null); //头指针
    //避免空链表的判断 ，即使为空也有sentinel node


    //节点类
    private static class Node{
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
//        head = new Node(value,head);
        insert(0,value);
    }

    //遍历链表 (consumer 接收操作 )
    public void loop(Consumer<Integer> consumer){
        //起点需要更改 ，遍历起点不包括sentinel node
        Node pointer = head.next;
        while (pointer!=null){
            consumer.accept(pointer.value);
            pointer=pointer.next;
        }
    }

    //for循环遍历链表
    public void loop2(Consumer<Integer> consumer){
        //起点需要更改 ，遍历起点不包括sentinel node
        for (Node pointer = head.next;pointer!=null;pointer=pointer.next) {
            consumer.accept(pointer.value);
        }
    }

    //iterator迭代器 遍历
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            //起点需要更改 ，遍历起点不包括sentinel node
            Node pointer =head.next;
            @Override
            public boolean hasNext() {
                return pointer!=null;
            }

            @Override
            public Integer next() {
                //起点需要更改 ，遍历起点不包括sentinel node
                int v=pointer.value;
                pointer = pointer.next;
                return v;
            }
        };
    }

    //递归遍历

    //查找最后一个元素
    public Node findLast(){
        // sentinel node LinkList is not null
       /*if (head==null)
            return null;*/

        //pointer = head is sentinel node
        Node pointer;
        for (pointer=head; pointer.next!=null;pointer=pointer.next){

        }
        return pointer;
    }

    //插入最后一个元素
    public void addLast(int value){
        Node last=findLast();
        //1. 修改一：不可能为空链表
       /* if (last==null){
            addFirst(value);
            return;
        }*/
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
        int i= -1 ;
        //起点需要更改 ，遍历起点不包括sentinel node ？
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
        //不存在 找不到，index =0 的上一个元素为sentinel
        /*if (index==0){
            addFirst(value);
            return; //不需要继续执行
        }*/
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
        /*if (head==null){
            illegalIndex(0);
        }
        //2. head is not null
        //head 指向 第二个节点
        head=head.next;*/
        remove(0);
    }
    //remove by index
    public void remove(int index){
        //1. index =0

        /*if (index==0){
            removeFirst();
            return;
        }*/
        //2.index >0
         //2.1 prev node
        Node prev=findNode(index-1);
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
