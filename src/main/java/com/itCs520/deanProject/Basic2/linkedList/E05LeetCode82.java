package com.itCs520.deanProject.Basic2.linkedList;/*
 *ClassName:E05LeetCode82
 *Description:
 *@Author:deanzhou
 *@Date:2023/7/18 23:55
 */


public class E05LeetCode82 {
    /*
    * head =[1,2,3,3,4,4,5]
    * output = [1,2,5]
    *
    * head = [1,1,1,2,3]
    * output = [2,3]
    *
    * 重复元素一个不留
    * */

    /*solution1: 递归 遇到重复元素返回重复元素下一个
    * */
    public static ListNode deleteDuplicates(ListNode head){
        //1. head is null or head.next is null node <2
        if (head ==null || head.next ==null){
            return head;
        }
        //2. head is not null node >=2
        if (head.val == head.next.val){
            ListNode x=head.next.next;
            while (x!=null && x.val == head.val){
                x= x.next;
            }
            return deleteDuplicates(x);
        }else {
            head.next = deleteDuplicates(head.next);
            return head;
        }

    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(3, node5);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(1, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode p = node1;
        while (p!=null){
            System.out.println(p.val);
            p=p.next;
        }

        System.out.println("---------------------");
        ListNode node = deleteDuplicates(node1);
        ListNode p1= node;
        while (p1!=null){
            System.out.println(p1.val);
            p1=p1.next;
        }
    }

}
