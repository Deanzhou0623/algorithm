package com.itCs520.deanProject.Basic.Summary1.Linear;

public class CircleListCheck {
    public static void main(String[] args) throws Exception{
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

        //生产环
        seven.next=third;
        //查找中间值
        Boolean mid=isCircle(first);
        System.out.println("链表是否成环"+mid);
    }

    //检测链表是否成环
    public static boolean isCircle(Node<String> first){
        //1  定义两个指针
        Node<String> fast=first;
        Node<String> slow=first;
        //2 使用指针遍历结点
        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            //3 判断快指针和慢指针是否会相遇
            if (fast.equals(slow)){
                return true;
            }
        }
        return false;
    }
    //结点类
    public static class Node<T>{
        //存储数据
        T item;
        //下一个结点
        Node<String> next;

        public Node(T item, Node<String> next){
            this.item=item;
            this.next=next;
        }
    }

}
