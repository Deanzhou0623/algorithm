package com.itCs520.deanProject.Basic2.linkedList;/*
 *ClassName:E04LeetCode83
 *Description:
 *@Author:deanzhou
 *@Date:2023/7/18 23:26
 */

public class E04LeetCode83 {

    /*
    * 删除有序链表中的重复节点
    *
    * 输入：head =[1,1,2]
    * 输出：[1,2]
    *
    * 输入：head =[1,1,2,3,3]
    * 输出：[1,2,3]
    * */

    /*
    * 1. solution1: 双指针移动
    * */
    public static ListNode deleteDuplicates(ListNode head){
        //1. head is null or head.next is null node <2
        if (head ==null || head.next ==null){
            return head;
        }
        //2. head is not null node >=2
        ListNode p1 = head;
        ListNode p2 ;
        while ((p2=p1.next)!=null){
            //1. p1.val equal p2.val  then remove p2.val
            if (p1.val == p2.val){
                //1.2 then remove p2.val
                p1.next = p2.next;
            }else {
                //2. p2.val not equal p1.val then pointer go next
                p1=p1.next;
            }
        }
        return head;
    }

    public static ListNode deleteDuplicates2(ListNode head){
        //1. head is null or head.next is null node <2
        if (head ==null || head.next ==null){
            return head;
        }
        //2. head is not null node >=2
        if (head.val == head.next.val){
            return deleteDuplicates2(head.next);
        }else {
            head.next = deleteDuplicates2(head.next);
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(3, null);
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
        ListNode node = deleteDuplicates2(node1);
        ListNode p1= node;
        while (p1!=null){
            System.out.println(p1.val);
            p1=p1.next;
        }
    }
}
