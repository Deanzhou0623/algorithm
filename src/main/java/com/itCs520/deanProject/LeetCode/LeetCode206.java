package com.itCs520.deanProject.LeetCode;

public class LeetCode206 {
    /*给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
    * */

    /* (1) --> (2) --> (3) --> (4) --> (5)
                    |
       (5) --> (4) --> (3) --> (2) --> (1)
       输入：head = [1,2,3,4,5]
       输出：[5,4,3,2,1]
  */
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    /*solution1:通过双指针直接反转直接反转 时间复杂度：O(n) 空间复杂度：O(1)
     * */

    public ListNode reverseList(ListNode head) {
        //1.定义双指针
        ListNode preNode = null;
        ListNode curr = head;
        //2.循环链表
        while (curr!=null){  //注意 curr指针指向null终止 如果是 curr.next!=null 则最后一个元素无法录入
            //3.链表反转
            ListNode next = curr.next;//保存当前结点指向 A --》 B
            curr.next = preNode; // 当前curr的指向指向 前一个结点
            preNode = curr; // 指针后移
            curr = next;
        }
        //4.返回对象
        return preNode;
    }
}
