package com.itCs520.deanProject.LeetCode;/*
 *ClassName:LinkListReverse
 *Description:
 *@Author:deanzhou
 *@Date:2023/2/28 15:44
 */

public class LinkListReverse {
    /*链表反转专题讲解
    * */
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    /*迭代思路
    * */
    public static ListNode iterator(ListNode head){
        ListNode prev=null,next;
        ListNode curr=head;
        while (curr!=null){
            next = curr.next;
            curr.next=prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    /*递归思路
    * */
    public static ListNode recursion(ListNode head){
        //终止条件
        if (head == null || head.next==null){
            return head;
        }
        //循环条件
        ListNode newNode=recursion(head.next);
        head.next.next=head;
        head.next=null;

        return newNode;
    }

}
