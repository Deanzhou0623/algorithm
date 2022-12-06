package com.itCs520.deanProject.LeetCode;

public class LeetCode234 {
    /*
    * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。
    * 如果是，返回 true ；否则，返回 false 。
    *
    *
    * 事例1：
    * (1) --> (2) --> (2) --> (1)
    * 输入：head = [1,2,2,1]
      输出：true

      示例 2：
      (1) --> (2)
     输入：head = [1,2]
     输出：false
    * */

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
    /*solution1: 通过反转链表 实现回文链表的比较 时间复杂度 O(n) 空间复杂度：O(1)
    * */
    public boolean isPalindrome(ListNode head) {
        //1. difine fastPtr & slowPtr
        ListNode  fastPtr=head,slowPtr=head;
        //2. 循环链表
        while (fastPtr!=null && fastPtr.next!=null){
            fastPtr=fastPtr.next.next;
            slowPtr=slowPtr.next;
        }
        //3. 获取结点位置 ，如果链表为奇数则结点位置向后推一位
        if (fastPtr!=null){
            slowPtr=slowPtr.next;
        }
        //4. 反转链表
        slowPtr=reverseList(slowPtr);
        //5. 重制fastPtr
        fastPtr=head;
        //6. 重新循环快慢指针，并每次移一位进行比较，如果快慢指针值不相同则说明不是回文链表
        while (slowPtr!=null){
            if (fastPtr.val != slowPtr.val){
                return false;
            }
            slowPtr=slowPtr.next;
            fastPtr=fastPtr.next;
        }
        return true;
    }
    //反转链表api
    public ListNode reverseList(ListNode head){
        //1. 定义双指针
         ListNode preNode = null;
         ListNode curr = head;
        //2. 循环链表
        while (curr!=null){
            //3. 链表反转
            ListNode  next=curr .next;
            curr.next=preNode;
             preNode = curr;
             curr=next;
        }
        //4. 返回对象
        return  preNode;
    }

}
