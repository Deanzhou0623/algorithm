package com.itCs520.deanProject.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode145 {
    /*给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
    示例1：
        （1）
           \
            (2)
           /
         (3)

     输入：root = [1,null,2,3]
     输出：[3,2,1]

    * */



 // Definition for a binary tree node.
   public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
   }
    /*solution1: 递归解决后序遍历
    * */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        accessTree(root,res);
        return res;
    }
    /* 递归解决后序遍历
    * */
    private void accessTree(TreeNode root, List<Integer> res) {
        if (root == null) return;

        accessTree(root.left,res);
        accessTree(root.right,res);
        res.add(root.val);
    }

    /*solution2: 用循环解决后序遍历
    * */
    public List<Integer> postorderTraversal2(TreeNode root) {
        //1. 创建res存储对象和stack栈
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        //2. 定义变量表示前一个访问的对象
        TreeNode prevAccess = null;
        //3. 循环遍历
        while (root!=null || !stack.isEmpty()){
            // 将所有root.left 压入栈中
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            //root.left 已经遍历完成，只需要遍历root.right
            root = stack.pop();
            if (root.right == null || root.right == prevAccess){
                res.add(root.val);
                prevAccess = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        //4. 返回对象
        return res;
    }
}
