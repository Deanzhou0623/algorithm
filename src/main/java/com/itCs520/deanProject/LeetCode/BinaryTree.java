package com.itCs520.deanProject.LeetCode;/*
 *ClassName:BinaryTree
 *Description:
 *@Author:deanzhou
 *@Date:2023/4/1 19:43
 */


import java.util.*;

public class BinaryTree {


    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node5 = new TreeNode(5, node6, node7);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);

        //preOrder
//        preOrder(node1);
//
//        //inOrder
//        inOrder(node1);
//
//        //postOrder
//        postOrder(node1);

        //层序遍历
        ArrayList list = new ArrayList();
        layerOrder(node1,1,list);
        System.out.println(Arrays.toString(list.toArray()));
    }

    //后续遍历
    private static void morrisPostOrder(TreeNode cur){
        if (cur==null)
            return;

        TreeNode root=cur;
        TreeNode mostRight=null;
        while (cur!=null){
            mostRight = cur.left;
            if (mostRight!=null){
                while (mostRight.right !=null && mostRight.right!=cur){
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null){ // 建立线索指针
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else { // mostRight.right == cur //删除线索指针
                    mostRight.right =null;
                    printNode(cur.left);
                }
            }
            cur = cur.right;
        }
            printNode(root);
    }
    /*打印后序遍历方法
    * */
    private static void printNode(TreeNode head) {
        TreeNode tail =reverse(head);
        while (tail!=null){
            System.out.println(tail.val);
            tail = tail.right;
        }
        reverse(tail);
    }

    /*reverse binary tree
    * */
    private static TreeNode reverse(TreeNode head) {
        TreeNode prev = null,curr,next;
        curr = head;
        while (curr!=null){
            next = curr.right;
            curr.right = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    //Morris 遍历 -中序线索二叉树 前序/中序遍历  - 打印位置不同
    private static void morrisOrder(TreeNode cur){
        if (cur ==null)
            return;

        TreeNode mostRight=null;
        while (cur!=null){
            mostRight = cur.left;
            if (mostRight!=null){
                while (mostRight.right !=null && mostRight.right!=cur){
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null){ // 建立线索指针
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else { // mostRight.right == cur //删除线索指针
                    mostRight.right =null;
                }
            }else {
                //前序遍历
//                System.out.println(cur.val);
            }
            //中序遍历
            // System.out.println(cur.val);
            cur = cur.right;
        }
    }
    //前序遍历 - iterator root -left -right
    private static void preOrder2(TreeNode root) {
        if (root!=null){
            Stack<TreeNode> stack = new Stack<>();
            stack.add(root);
            while (!stack.isEmpty()){
                root = stack.pop();
                if (root!=null){
                    System.out.println(root.val);
                    //LIFO
                    stack.push(root.right);
                    stack.push(root.left);
                }
            }
        }
    }


    //中序遍历 -iterator left - root -right
    private static void inOrder2(TreeNode root) {
        if (root!=null){
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || root!=null){
                if (root!=null){
                    stack.push(root);
                    root = root.left;
                }else {
                    root = stack.pop();
                    System.out.println(root.val);
                    root = root.right;
                }
            }
        }


    }

    //后续遍历 -iterator left - right - root
    private static void postOrder2(TreeNode root){
        if (root!=null){
            Stack<TreeNode> stack = new Stack<>();
            TreeNode prev = null;
            while (!stack.isEmpty() || root!=null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }

                root = stack.pop();
                if (root.right == null || root.right == prev) {
                    System.out.println(root.val);
                    prev = root;
                    root = null;
                } else {
                    stack.push(root);
                    root = root.right;
                }
            }
        }
    }
    // 层序遍历 -iterator
    private static void layerOrder2(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            TreeNode node = q.poll();
            if (node!=null){
                System.out.println(root.val);
                q.add(node.left);
                q.add(node.right);
            }
        }
    }

    /*
    * 层序遍历
    * */
    private static void layerOrder(TreeNode root, int i, ArrayList list) {
        if (root==null)
            return;

        int length = list.size();
        if (length<=i){
            for (int j = 0; j <= i-length; j++) {
                list.add(length+j,null);
            }
        }
        list.set(i,root.val);
        layerOrder(root.left,2*i,list);
        layerOrder(root.right,2*i+1,list);
    }

    //中序遍历
    private static void inOrder(TreeNode root) {
        if (root==null)
            return;

        preOrder(root.left);
        System.out.println(root.val);
        preOrder(root.right);
    }

    //前序遍历
    private static void preOrder(TreeNode root) {
        if (root ==null)
            return;
        //root
        System.out.println(root.val);
        //left
        preOrder(root.left);
        //right
        preOrder(root.right);

    }

    //后续遍历
    private static void postOrder(TreeNode root){
        if (root ==null)
            return;
        //left
        preOrder(root.left);
        //right
        preOrder(root.right);
        //root
        System.out.println(root.val);
    }
}
class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public int deep;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}