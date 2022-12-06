package com.itCs520.deanProject.LeetCode;

public class LeetCode876 {
    /*给定一个头结点为 head 的非空单链表，返回链表的中间结点。

如果有两个中间结点，则返回第二个中间结点。

示例 1：
输入：[1,2,3,4,5]
输出：此列表中的结点 3 (序列化形式：[3,4,5])
返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
注意，我们返回了一个 ListNode 类型的对象 ans，这样：
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.

示例 2：
输入：[1,2,3,4,5,6]
输出：此列表中的结点 4 (序列化形式：[4,5,6])
由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。

    * */

   public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  /*solution1:遍历链表找到中间位置返回该结点
  * */
    public ListNode middleNode(ListNode head) {
        //1. 定义指针，定义一个常量
        ListNode ptr=head;
        int length=0;
        //2. 循环链表得到链表长度
        while (ptr!=null){
            length++;
            ptr=ptr.next;
        }
        //3. 计算中点
        int mid=length/2;
        //4. 循环链表找到该值
        ptr = head;
        for (int i = 0; i < mid; i++) {
            ptr=ptr.next;
        }
        //5. 返回对象
        return ptr;
    }

    /*solution2: 快慢指针
    * */
    public ListNode middleNode2(ListNode head) {
        //1. 定义快慢指针
        ListNode fastPtr=head,slowPtr=head;
        //2. 循环链表
        while (fastPtr!=null && fastPtr.next!=null){
            fastPtr=fastPtr.next.next;
            slowPtr=slowPtr.next;
        }
        //3. 返回对象
        return slowPtr;

    }
}
