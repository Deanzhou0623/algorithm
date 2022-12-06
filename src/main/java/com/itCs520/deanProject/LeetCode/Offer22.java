package com.itCs520.deanProject.LeetCode;

public class Offer22 {
    /*输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，
    本题从1开始计数，即链表的尾节点是倒数第1个节点。

例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。
这个链表的倒数第 3 个节点是值为 4 的节点

示例：

给定一个链表: 1->2->3->4->5, 和 k = 2.

返回链表 4->5.
    * */

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    /*solution1: 遍历得到链表长度 ，得到应该从哪里开始输出链表 ，循环到相应到位置输出
    * */
    public ListNode getKthFromEnd(ListNode head, int k) {
        //1. 定义指针
        ListNode temp=head;
        int length=0;
        //2. 循环链表
        while (temp!=null){
            temp=temp .next;
            length++;
        }
        //3. 得到从哪里开始输出
        int num=length-k;
        //4. 循环链表
        temp = head;
        for (int i = 0; i <num; i++) {
            temp=temp.next;
        }
        //5. 返回对象
        return temp;
    }

    /*solution2：双指针快慢指针
    * */
    public ListNode getKthFromEnd2(ListNode head, int k) {
        //1. 定义快慢指针
        ListNode former=head,latter = head;
        //2. 快指针先走k-1步
        for (int i = 0; i < k; i++) {
            former=former.next;
        }
        //3. 循环遍历链表
        while (former!=null){
            former=former.next;
            latter=latter.next;
        }
        //4. 返回对象
        return latter;

    }
}
