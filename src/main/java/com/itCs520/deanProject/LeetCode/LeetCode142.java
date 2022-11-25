package com.itCs520.deanProject.LeetCode;

public class LeetCode142 {
    /*给定一个链表的头节点 head，返回链表开始入环的第一个节点。如果链表无环，则返回null。

如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，
则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数
pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，
则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
不允许修改 链表。

 (3) --> (2) --> (0) --> (-4)
          /\               /
           \--------------


输入：head = [3,2,0,-4], pos = 1
输出：返回索引为 1 的链表节点
解释：链表中有一个环，其尾部连接到第二个节点。
    * */
    /*1.快慢指针
    * */
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public ListNode detectCycle(ListNode head) {
        //1. 判断head是否为空
        if (head == null) return null;
        //2. 定义快慢指针
        ListNode slowPtr=head;
        ListNode fastPtr=head;
        //3. 定义是否有环变量
        boolean loopExist = false;
        //4. while循环判断是否有环
        while (fastPtr.next!=null && fastPtr.next.next!=null){
            slowPtr=slowPtr.next;
            fastPtr=fastPtr.next.next;
            if (slowPtr == fastPtr){
                loopExist = true;
                break;
            }
        }
        //5. 判断入口位置
        /*理论：第一次相遇判断有环（fast步长为2 ，slow步长为1 ）
               第二次相遇即为环的入口( fast步长为 1 ，slowPtr与fastPtr相遇的时候即为入口)
        * */
        //5. 重制fastPtr
        if (loopExist){
            fastPtr = head;
            while (slowPtr!=fastPtr){
                fastPtr =fastPtr.next;
                slowPtr =slowPtr.next;
            }
            return fastPtr;//返回环开始的结点
        }
        return null;
    }
}
