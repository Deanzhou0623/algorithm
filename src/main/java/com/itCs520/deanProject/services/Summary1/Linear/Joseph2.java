package com.itCs520.deanProject.services.Summary1.Linear;

public class Joseph2 {
    public static void main(String[] args) {
        //解决约瑟夫问题
        //1 构建循环链表
            //1.1 定义首结点
            Node<Integer> first=null;
            //1.2 定义上一个结点
            Node<Integer> pre=null;
            //1.3 循环插入结点
        for (int i = 1; i <=41 ; i++) {
                //1.3.1 如果是首结点
                if (i==1){
                    first=new Node<>(i,null);
                    pre=first; //插入下一个结点
                    continue;
                }
                //1.3.2 如果不是首结点
                Node<Integer> newNode=new Node<>(i,null);
                //当前结点被置为pre
                pre.next=newNode;
                pre=newNode;
                //1.3.3 如果是尾结点
                if (i==41){
                    //构建循环链表
                    pre.next=first;
                }
        }

        //2 count 计数
            int count=0;
        //3 循环遍历链表
            //3.1 记录每一次拿到的结点，默认从首结点开始
            Node<Integer> n=first;
            //3.2 记录当前的上一个结点
            Node<Integer> before=null;
            //3.3 模拟抽签
            while (n!=n.next){
                count++;
                //3. 判断count是否等于3
                if (count==3){
                    //如果是3，则删除当前结点，打印当前结点，重置count=0；让当前结点n向后移
                    before.next=n.next;
                    System.out.println("删除结点为"+n.item);
                    count=0;
                    //继续向后移
                    n=n.next;
                }else {
                    before=n;
                    n=n.next;
                }
            }
        System.out.println(n.item);
    }

    //结点类
    public static class Node<T>{
        //存储数据
        T item;
        //下一个结点
        Node<Integer> next;

        public Node(T item, Node<Integer> next){
            this.item=item;
            this.next=next;
        }
    }
}
