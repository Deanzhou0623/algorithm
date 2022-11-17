package com.itCs520.deanProject.Basic.Summary1.Linear;

public class FastSlowPointer {
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

        //查找中间值
        String mid=getmid(first);
        System.out.println("中间值为"+mid);
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
    //快慢指针查找中间值
//    public static String getmid(Node<String> first){
//        //1 定义两个指针
//        Node<String> fast=first;
//        Node<String> slow=first;
//        //2 使用两个指针遍历链表，当快慢指针指向的结点没有下一个结点，就可以结束，结束之后，慢指针指向的结点就是中间值
//        while (fast!=null && fast.next!=null){
//            //变化fast的值和slow的值
//            fast=fast.next.next;
//            slow=slow.next;
//        }
//        return slow.item;
//    }

    public static String getmid(Node<String> first){
        //1 定义两个指针
        Node<String> fast=first;
        Node<String> slow=first;
        //2 循环遍历两个指针
        while (fast !=null && fast.next!=null){
            //3 变化快指针和慢指针
            fast=fast.next.next;
            slow=slow.next;
        }
        //4 返回结果
        return slow.item;
    }
}
