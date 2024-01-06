package com.itCs520.deanProject.Basic2.linkedList;/*
 *ClassName:DoubleLinkedListSentinel
 *Description:
 *@Author:deanzhou
 *@Date:2023/6/21 12:05
 */

import java.util.Iterator;

public class DoubleLinkedListSentinel2 implements Iterable<Integer> {

    /*双向循环链表
    * */
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
    private Node sentinel = new Node(null,-1,null);

    //构造双向链表
    public DoubleLinkedListSentinel2(){
        sentinel.prev=sentinel;
        sentinel.next=sentinel;
    }

    //remove


    //exception
    public void illegalIndex(int index) {
        throw new IllegalArgumentException(
                String.format("index [%d] illegal index%n",index)
        );
    }
    public void addFirst(int value){
        Node a = sentinel;
        Node b = sentinel.next;
        Node added= new Node(a,value,b);
        a.next = added;
        b.prev = added;
    }

    public void removeFirst(){
        Node removed = sentinel.next;
        if (removed == sentinel){
            throw new IllegalArgumentException("can not remove sentinel");
        }
        Node a = sentinel;
        Node b = removed.next;
        a.next = b;
        b.prev = a;
    }

    public void addLast(int value){
        Node a=sentinel.prev;
        Node b=sentinel;
        Node added=new Node(a,value,b);
        a.next=added;
        b.prev=added;
    }

    public void removeLast(){
        Node removed = sentinel.prev;
        if (removed==sentinel){
            throw  new IllegalArgumentException("can not delete");
        }
        Node a = removed.prev;
        Node b = sentinel;
        a.next = b;
        b.prev = a;
    }

    //iterator
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator() {
            Node p=sentinel.next;
            @Override
            public boolean hasNext() {
                return p!=sentinel;
            }

            @Override
            public Integer next() {
                int value =p.value;
                p=p.next;
                return value ;
            }
        };
    }

    //removed by value
    public void removeByValue(int value){
        Node removed=findValue(value);
        if (removed == null){
            return;
        }
        Node a = removed.prev;
        Node b = removed.next;
        a.next = b;
        b.prev = a;
    }
    //find value
    public Node findValue(int value){
        Node p=sentinel.next;
        while (p != sentinel){
            if (p.value == value){
                return p;
            }
        }
        return null;
    }

}
