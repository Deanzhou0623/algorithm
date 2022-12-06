package com.itCs520.deanProject.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode144 {
    /*给你二叉树的根节点 root ，返回它节点值的 前序 遍历。

 事例1：
     （1）
         \
          (3)
         /
      (2)

示例1：
输入：root = [1,null,2,3]
输出：[1,2,3]

示例 2：
输入：root = []
输出：[]
     * */
    /*solution1: 递归的方式实现
    * */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        accessTree(root,res);
        return res;
    }

    /*accessTree实现方法
    * */
    private void accessTree(TreeNode root, List<Integer> res) {
            if (root == null) return;

            res.add(root.val);
            accessTree(root.left,res);
            accessTree(root.right,res);

    }

        /*solution2：通过循环遍历借助stack的方式实现
        * */
        public List<Integer> preorderTraversal2(TreeNode root) {
            //1. 存储数据的时间
            List<Integer> res = new ArrayList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();
            //2. 借助stack栈遍历实现
            while (!stack.isEmpty() || root!=null){
                while (root!=null){
                    res.add(root.val);
                    stack.push(root);
                    root = root.left;
                }
                    root = stack.pop();
                    root = root.right;
            }
            //3. 返回对象
                return res;
        }

}
