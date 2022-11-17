package com.itCs520.deanProject.Basic.Day04.linear;


//循环链表
public class CircularLinkedListTest {
    public static void main(String[] args) throws Exception  {
        //创建结点
        Node<String> first = new Node<String>("aa", null);
        Node<String> second = new Node<String>("bb", null);
        Node<String> third = new Node<String>("cc", null);
        Node<String> fourth = new Node<String>("ee", null);
        Node<String> fifth = new Node<String>("ff", null);
        Node<String> six = new Node<String>("gg", null);
        Node<String> seven = new Node<String>("hh", null);

        //完成指向
        first.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next =fifth;
        fifth.next=six;
        six.next=seven;


        //构建循环链表让最后一个结点指向第一个结点
        seven.next=first;





    }
    //快慢指针查找中间值

    //结点类
    public static class Node<T>{
        //存储数据
        T item;
        //下一个结点
        Node next;

        public Node(T item, Node next){
            this.item=item;
            this.next=next;
        }
    }

}
