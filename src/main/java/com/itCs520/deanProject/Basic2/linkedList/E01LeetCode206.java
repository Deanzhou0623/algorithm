package com.itCs520.deanProject.Basic2.linkedList;/*
 *ClassName:E01LeetCode206
 *Description:
 *@Author:deanzhou
 *@Date:2023/7/16 17:08
 */

import com.itCs520.deanProject.LeetCode.LeetCode206;

import java.util.Arrays;

public class E01LeetCode206 {
    /*反转链表
    * */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    //1 solution1: list.addfirst 插入倒序
    public static ListNode reverseList(ListNode head){
        //1. new lstNode
        ListNode newList=null;
        //2. pointer
        ListNode p1 = head;
        //3. traverse the listNode
        while (p1!=null){
            newList = new ListNode(p1.val, newList);
            p1=p1.next;
        }
        return newList;
    }

    //recursion
    public static ListNode reverseList2(ListNode head){
        //1. 最后一个节点返回
        if (head ==null || head.next ==null){
            return head;
        }
        //2.
        ListNode node = reverseList(head.next);
        //5 -> 4
        head.next.next = head;
        //4 -> null
        head.next =null;
        return node;
    }

    // reverseList3 双指针
    public static ListNode reverseList3(ListNode head){
        //1. 定义双指针
        ListNode preNode =null;
        ListNode curr = head;
        //2. traverse
        while (curr!=null){
            ListNode next = curr.next;
            curr.next = preNode;
            preNode = curr;
            curr = next;
        }
        return preNode;
    }
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
    }
}
