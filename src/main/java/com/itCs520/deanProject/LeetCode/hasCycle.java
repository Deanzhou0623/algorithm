package com.itCs520.deanProject.LeetCode;/*
 *ClassName:hasCycle
 *Description:
 *@Author:deanzhou
 *@Date:2023/3/21 13:54
 */

import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x,ListNode next) {
        val = x;
        this.next = next;
    }


}
public class hasCycle {


    public static void main(String[] args) {
        ListNode node5 = new ListNode(5,null);
        ListNode node4 = new ListNode(5,node5);
        ListNode node3 = new ListNode(5,node4);
        ListNode node2 = new ListNode(5,node3);
        ListNode node1 = new ListNode(5,node2);

        //cycle
         node5.next = node3;
         // time O(n)  space O(n)
        System.out.println(hasCycleList(node1));
        System.out.println(hasCycleList2(node1));
    }
    /* 双指针
    * */
    private static boolean hasCycleList2(ListNode head) {
        if(head ==null ||head.next ==null ){
            return false;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        while (slow!=fast){
            if (fast == null || fast.next ==null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static boolean hasCycleList(ListNode head){
        HashSet<ListNode> set = new HashSet<>();
        while (head!=null){
            if (!set.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
