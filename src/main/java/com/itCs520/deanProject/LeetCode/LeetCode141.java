package com.itCs520.deanProject.LeetCode;

public class LeetCode141 {
    /*给你一个链表的头节点 head ，判断链表中是否有环。

如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
注意：pos 不作为参数进行传递。仅仅是为了标识链表的实际情况。
如果链表中存在环 ，则返回 true 。 否则，返回 false

    (3) --> (2) --> (0) --> (4)
             /\             /
              \------------
输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。

链表中节点的数目范围是 [0, 104]
-105 <= Node.val <= 105
pos 为 -1 或者链表中的一个 有效索引 。

进阶：你能用 O(1)（即，常量）内存解决此问题吗？

    * */
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    /*1. solution：快慢指针解决链表是否成环
     * */
    public boolean hasCycle(ListNode head) {
        //1. 判断head是否为空
        if (head == null) return false;
        //2. 定义快慢指针
          ListNode fastPtr = head;
          ListNode slowPtr = head;
        //3. 循环遍历链表
        while (fastPtr.next!=null && fastPtr.next.next!=null){
            slowPtr=slowPtr.next;
            fastPtr=fastPtr.next.next;
            //4. 快慢指针是否相遇
            if (slowPtr == fastPtr){
                return true;
            }
        }
        return false;
    }
}
