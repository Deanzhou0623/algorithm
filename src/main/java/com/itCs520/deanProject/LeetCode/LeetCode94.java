package com.itCs520.deanProject.LeetCode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode94 {
    /* 给定一个二叉树根结点root，返回中序遍历

    事例1：
     （1）
         \
          (3)
         /
      (2)

输入：root = [1,null,2,3]
输出：[1,3,2]

输入：root = []
输出：[]
    * */

    //Definition for a binary tree node.
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
    /* solution1：递归的方法实现
    * */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        accessTree(root,res);
        return res;
    }

    /* accessTree方法实现
    * */
    private void accessTree(TreeNode root, List<Integer> res) {
        if (root ==null) return;

        accessTree(root.left,res);
        res.add(root.val);
        accessTree(root.right,res);
    }

    /* solution2：循环借用stack数据结构实现
     * */
    public List<Integer> inorderTraversal2(TreeNode root) {
        //1. 存储数据的时间
        List<Integer> res = new ArrayList<>();
        //2. 借助stack实现中序遍历
        Deque<TreeNode> stack = new LinkedList<>();
        while (root!=null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            //根结点 -- 中间结点ss
            res.add(root.val);
            root=root.right;
        }
        return res;
    }
}
