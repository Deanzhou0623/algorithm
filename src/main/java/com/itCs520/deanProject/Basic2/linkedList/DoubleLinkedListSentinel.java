package com.itCs520.deanProject.Basic2.linkedList;/*
 *ClassName:DoubleLinkedListSentinel
 *Description:
 *@Author:deanzhou
 *@Date:2023/6/21 12:05
 */

import java.util.Iterator;

public class DoubleLinkedListSentinel implements Iterable<Integer> {

    //构造双向链表的node
    static class Node{
        Node prev; //prev node pointer
        int value; //value
        Node next; //next node pointer

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }
    //sentinel node
    private Node head;
    private Node tail;

    //构造双向链表
    public DoubleLinkedListSentinel(){
        head = new Node(null,-1,null);
        tail = new Node(null,-2,null);
        head.next=tail;
        tail.prev=head;
    }

    //findNode
    public Node findNode(int index){
        int i=-1;
        for (Node p=head;p!=tail;p=p.next ,i++) {
            if (i==index)
                return p;
        }
        return null; //can not find
    }

    //insert
    public void insert(int index,int value){
        //1. find node -1
         Node prev=findNode(index-1);
        //2. if prev is null
        if (prev ==null)
            illegalIndex(index);
        //3. if prev is not null
        Node next=prev.next;
        Node inserted = new Node(prev,value,next);
        prev.next=inserted;
        next.prev=inserted;

    }

    //remove
    public void remove(int index){
        //1. find the node -1
        Node prev = findNode(index-1);
        //2. if can not find
        if (prev ==null)
            illegalIndex(index);
        //3. prev is not null( can find )
        Node removed = prev.next;
        //删除节点是sentinel节点 ，不合法的
        if (removed==tail){
            illegalIndex(index);
        }
        Node next = removed.next;
        prev.next = next;
        next.prev = prev;
    }

    //exception
    public void illegalIndex(int index) {
        throw new IllegalArgumentException(
                String.format("index [%d] illegal index%n",index)
        );
    }
    public void addFirst(int value){
        insert(0, value);
    }

    public void removeFirst(){
        remove(0);
    }

    public void addLast(int value){
        Node last=tail.prev;
        Node added = new Node(last, value, tail);
        last.next = added;
        tail.prev = added;
    }

    public void removeLast(){
        Node removed = tail.prev;
        //表示链表被删空
        if (removed==head){
            illegalIndex(0);
        }
        Node prev = removed.prev;
        prev.next =tail;
        tail.prev =prev;
    }

    //iterator
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator() {
            Node p=head.next;
            @Override
            public boolean hasNext() {
                return p!=tail;
            }

            @Override
            public Integer next() {
                int value =p.value;
                p=p.next;
                return value ;
            }
        };
    }

}
