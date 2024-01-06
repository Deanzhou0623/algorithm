package com.itCs520.deanProject.Basic2.linkedList;/*
 *ClassName:LinkedList
 *Description:
 *@Author:deanzhou
 *@Date:2023/6/15 16:13
 */

public class LinkedList {
    /*
    * LinkedList
    * 1. define:
    *    linkedList is a linear collection of data elements whose order
    *    is not given by their physical placement in memory. instead, each element
    *    to the next
    *
    * 2. type:
    *    单项链表(linkedList)
    *       每个元素只知道下一个元素是谁
    *    双向链表(double linkedList)
    *       每个元素知道上一个和下一个元素是谁
    *    循环链表(circular linked list)
    *       通常链表的尾节点tail都是指向null，而循环链表的尾节点tail是指向头节点head
    *
    *    特殊节点： sentinel (哨兵节点) 不存储数据，通常用作头尾
    *       head --> 1 --> 2 --> 3 --> 4 --> tail
    *     sentinel                          sentinel
    *
    * 3. big o notation:
    *       query: 根据index查找,时间复制度：O(n)
    *
    *       insert或者delete：
    *          起始位置：O(1)
    *          结束位置：已经tail节点位置O(1) ,不知道tail尾节点O(n)
    *          中间位置：根据index查找时间+O(1)
    *
    * 4. static
    *   内部类相对独立，跟外部类变量没有关系
    * */

    /*
    * summary:
    * 1. singleLinkedList without Sentinel
    *       1. add :addFirst/addLast/insert 方法
    *       2. get :查询方法
    *       3. remove: removeFirst , remove 方法
    *
    * 2. singleLinkedList with sentinel
    *       1. 区别：设置一个node 为sentinel node
    *       2. 结构：head -> sentinel node -> node1 -> node2 ->......
    *       3. traverse: 注意遍历的起点
    *
    * */
}
