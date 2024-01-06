package com.itCs520.deanProject.Basic2.linkedList;/*
 *ClassName:E03LeetCode19
 *Description:
 *@Author:deanzhou
 *@Date:2023/7/17 19:08
 */

public class E03LeetCode19 {
    /*
    * 删除链表倒数的第N个节点
    * 给你一个链表，删除链表倒数的第n个节点，并返回链表头节点
    *
    * 示例1：
    *
    *   1 - > 2 - > 3 - > 4 - > 5
    *
    *   1 - > 2 - > 3 - > 5
    *
    * 输入： head =[1,2,3,4,5] n =2;
    * 输出： [1,2,3,5]
     * */

    public static ListNode removeNthFromEnd(ListNode head,int n){
        //添加sentinel
        ListNode s=new ListNode(-1,head);
        recursion(s,n);
        return s.next;
    }

    private static int recursion(ListNode head, int n) {
        if (head ==null){
            return 0;
        }
        int nth = recursion(head.next,n); //下一个节点倒数位置
        System.out.println(head.val+" " +nth);
        if (nth == n){
            //head = 3 head.next =4  head.next.next = 5;
            head.next = head.next.next;
        }
        return nth+1;
    }


    public static ListNode removeNthFromEnd2(ListNode head,int n){
        //添加sentinel
        ListNode s=new ListNode(-1,head);
        recursion2(s,n);
        return s.next;
    }

    private static ListNode recursion2(ListNode head, int n) {
        //sentinel LinkedList
        ListNode s = new ListNode(-1, head);
        ListNode p1= s;
        ListNode p2= s;
        //倒数第二个 从 sentinel 节点开始移动3个位置
        for (int i = 0; i < n+1; i++) {
            p2 =p2.next;
        }
        while (p2!=null){
            p2=p2.next;
            p1=p1.next;
        }
        //p1 指向 被删除节点
        p1.next = p1.next.next;

        return s.next;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode p = node1;
        while (p!=null){
            System.out.println(p.val);
            p=p.next;
        }

        System.out.println("---------------------");
        ListNode node = removeNthFromEnd2(node1,2);
        ListNode p1= node;
        while (p1!=null){
            System.out.println(p1.val);
            p1=p1.next;
        }
    }
}
