package com.itCs520.deanProject.services.Day04.linear;

public class CircleListInTest {
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
        //生产环
        seven.next=third;

        //找环的入口结点
        Node<String> entrance=getEntrance(first);
        System.out.println("环的入口"+ entrance.item);




    }
    //快慢指针查找中间值
    public static Node getEntrance(Node<String> first) {
        //定义两个指针
        Node<String> fast=first;
        Node<String> slow=first;
        Node<String> temp=null;
        //使用两个指针遍历链表，当快慢指针指向的结点没有下一个结点，就可以结束了，结束之后，慢指针指向的结点就是中间值
        while (fast!=null && fast.next!=null){
            //变化fast的值和slow的值
            fast=fast.next.next;
            slow=slow.next;

            //如果指针在同一位置，则指向相同结点
            if(fast.equals(slow)){
                temp=first;
                continue;
            }
            //临时结点变换
            if (temp!=null){
                temp=temp.next;
                //判断临时指针是否和慢指针相遇
                if(temp.equals(slow)){
                    break;
                }
            }
        }
        return temp;
    }

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
