package com.itCs520.deanProject.LeetCode;

import java.util.HashSet;

public class LeetCode160 {
    /*
    给你两个单链表的头结点headA 和 headB ，
    请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
    图示两个链表在节点 c1 开始相交：

  A:  （a1） -- (a2)
                     \
                      (c1) -- (c2) -- (c3)
                       /
 B: (b1) -- (b2) -- (b3)

 题目数据 保证 整个链式结构中不存在环。
注意，函数返回结果后，链表必须 保持其原始结构 。

自定义评测：
评测系统 的输入如下（你设计的程序 不适用 此输入）：
intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0
listA - 第一个链表
listB - 第二个链表
skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数
skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数
评测系统将根据这些输入创建链式数据结构，并将两个头节点 headA 和 headB 传递给你的程序。如果程序能够正确返回相交节点，那么你的解决方案将被 视作正确答案 。

事例：
  A:  （a1） -- (a2)
                     \
                      (c1) -- (c2) -- (c3)
                       /
 B: (b1) -- (b2) -- (b3)

输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
输出：Intersected at '8'
解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
— 请注意相交节点的值不为 1，因为在链表 A 和链表 B 之中值为 1 的节点 (A 中第二个节点和 B 中第三个节点) 是不同的节点。换句话说，它们在内存中指向两个不同的位置，而链表 A 和链表 B 中值为 8 的节点 (A 中第三个节点，B 中第四个节点) 在内存中指向相同的位置。


提示：

listA 中节点数目为 m
listB 中节点数目为 n
1 <= m, n <= 3 * 104
1 <= Node.val <= 105
0 <= skipA <= m
0 <= skipB <= n
如果 listA 和 listB 没有交点，intersectVal 为 0
如果 listA 和 listB 有交点，intersectVal == listA[skipA] == listB[skipB]
 

进阶：你能否设计一个时间复杂度 O(m + n) 、仅用 O(1) 内存的解决方案？
*/
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    /*solution1:通过hash表的方式进行实现   时间复杂度：O(m+n)  空间复杂度： headA长度为m 则 为O(m)
    * */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //1. 构建hash表对象
        HashSet<ListNode> nodes = new HashSet<>();
        //2. 定义headA头指针
        ListNode temp=headA;
        //3. 循环变量headA，并将A存入hash表
        while (temp.next!=null){
            nodes.add(temp);
            temp = temp.next;
        }
        //3.定义headB头指针
         temp=headB;
        //4.循环headB看是否hash表中含有重复元素，如果有则返回对象，无则返回null
        while (temp.next!=null){
            if (nodes.contains(temp)){
                return temp;
            }
        }
        //5. 返回对象
        return null;
    }
    /*solution2: 双指针的方式 每次移一位，当其中headA指针指的下一位为null就从headB的头结点开始
                 HeadB同样如此

                  时间复杂度：O(m+n)  空间复杂度： O(1)
    * */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        //1.判断这两个链表是否为空
        if (headA == null || headB == null) return null;
        //2.定义两个指针headA和headB
        ListNode pA=headA,pB=headB;
        //3.循环指针
        while (pA!=pB) {
            pA = pA==null?headB:pA.next;
            pB = pA==null?headA:pB.next;
        }
        //4.返回对象
            return pA;
    }
   /*solution3: 双指针的方式 每次移一位，但是首先计算差值，从差值开始链表移动，如果两个链表相交
                则一定会相遇
                  时间复杂度：O(m+n)  空间复杂度： O(1)
    * */
   public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
       //1.定义三个变量
       int L1=0, L2 = 0,diff = 0;
       //2. 定义指针
       ListNode head1=headA,head2=headB;
       //3.循环headA得到链表长度
       while (head1.next!=null) {
           L1++;
           head1=head1.next;
       }
       //4.循环headB得到链表长度
       while (head2.next!=null) {
           L2++;
           head2=head2.next;
       }
       //5.比较就算差值
       if (L1<L2){
           head1 = headB;head2 = headA;diff=L2-L1;
       }else {
           head1=headA;head2=headB;diff=L1-L2;
       }
       //6.指针循环
       for (int i = 0; i < diff; i++)
           head1 = head1.next;
           while (head1!=null && head2!=null){
               if (head1 == head2)
                   return head1;
                   head1=head1.next;
                   head2=head2.next;

           }
       return null;

   }
}
