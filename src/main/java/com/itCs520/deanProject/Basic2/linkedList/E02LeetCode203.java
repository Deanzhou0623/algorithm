package com.itCs520.deanProject.Basic2.linkedList;/*
 *ClassName:E02LeetCode203
 *Description:
 *@Author:deanzhou
 *@Date:2023/7/17 18:24
 */


public class E02LeetCode203 {
    /*解法1：
    * */
    public static ListNode removeElement(ListNode head, int val){
        //sentinel
        ListNode s=new ListNode(-1,head);
        //double pointers
        ListNode p1= s;
        ListNode p2=s.next;
        while (p2!=null){
            if (p2.val == val){
                //删除节点
                p1.next = p2.next;
                p2 =p2.next;
            }else {
                p1=p1.next;
                p2=p2.next;
            }
        }
        return s.next;
    }

    /*
    *解法2：
    * */
    public static ListNode removeElements(ListNode p, int val){
        if (p ==null){
            return null;
        }
        if (p.val == val){
            //返回下一个节点的结果（相当于跳过当前节点）
            return removeElements(p.next,val);
        }else {
            //p向后移
            p.next = removeElements(p.next,val);
            //返回节点自身
            return p;
        }
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
        ListNode node = removeElements(node1,3);
        ListNode p1= node;
        while (p1!=null){
            System.out.println(p1.val);
            p1=p1.next;
        }
    }
}
