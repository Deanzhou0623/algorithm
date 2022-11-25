package com.itCs520.deanProject.LeetCode;

public class LeetCode83 {
    /*给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。

    事例1：
        (1) --> (1) --> (3)
                |
           (1) --> (3)
    输入：head = [1,1,2]
    输出：[1,2]

    输入：head = [1,1,2,3,3]
    输出：[1,2,3]

      链表中节点数目在范围 [0, 300] 内
    -100 <= Node.val <= 100
    题目数据保证链表已经按升序 排列
    * */


    public class ListNode {

        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    /*1. solution:删除链表中的重复元素,最简单的方法 遍历整个链表
     * */
    public ListNode deleteDuplicates(ListNode head){
        //1. 判断head是否为空
        if (head == null) return head;
        //2. 定义一个首结点
        ListNode currNode = head;
        //3. 循环链表
        while (currNode.next!=null){
            if (currNode.next.val == currNode.val){
                currNode.next = currNode.next.next;
            }else {
                currNode = currNode.next;
            }
        }
        //4. 返回对象
        return  head;
    }
    /*2. 递归处理，本质上其实就是将链表压栈后倒叙处理
    * */
    public ListNode deleteDuplicates2(ListNode head){
        if (head == null || head.next == null) return  head;
        head.next = deleteDuplicates2(head.next);
        return head.val == head.next.val ? head.next :head;
    }
}
