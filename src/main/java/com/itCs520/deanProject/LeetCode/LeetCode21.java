package com.itCs520.deanProject.LeetCode;

public class LeetCode21 {
    /*将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

            (1) --> (2) --> (4)
            (1) --> (3) --> (4)

            (1) --> (1) --> (2) --> (3) --> (4) --> (4)
    输入：l1 = [1,2,4], l2 = [1,3,4]
    输出：[1,1,2,3,4,4]
    示例 2：

    输入：l1 = [], l2 = []
    输出：[]
    示例 3：

    输入：l1 = [], l2 = [0]
    输出：[0]

    * */
    public class ListNode {

        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /*1. solution: 循环➕双指针解决
     * */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //1. 判断list1和list2是否为空
        if (list1==null) return list2;
        if (list2==null) return list1;
        //2. list1和list2都不为空
        //3. 创建一个新的链表用于存储对象
        ListNode node = new ListNode(0);
        //4. 创建头结点
        ListNode p=node;
        //5. 循环比较list1和list2都value，将两者比较，小的数据存储node
        while (list1!=null && list2!=null){
            if (list1.val< list2.val){
                p.next = list1;
                list1 = list1.next;
            }else {
                p.next = list2;
                list2 = list2.next;
            }
                p=p.next;

        }
        if (list1!=null){
            p.next=list1;
        }
        if (list2!=null){
            p.next = list2;
        }
        return node.next; //如果是返回node,会将 node初始化赋值的0也给输出出去，因此需要返回node.next
    }

    /*2. solution: 递归解决
     * */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        //1. 判断list1和list2是否为空
        if (list1==null) return list2;
        if (list2==null) return list1;
        if (list1.val< list2.val){
            list1.next = mergeTwoLists2(list1.next,list2);
            return list1;
        }
        list2.next =mergeTwoLists2(list1,list2.next);
        return list2;
    }
}

