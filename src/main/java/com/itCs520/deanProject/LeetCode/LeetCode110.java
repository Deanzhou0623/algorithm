package com.itCs520.deanProject.LeetCode;

import com.itCs520.deanProject.Basic.Summary2.Tree.MaxDepth;

public class LeetCode110 {
    /*给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：

一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。

                （3）
               /   \
            (9)     (20)
                   /    \
                (15)    (7)

输入：root = [3,9,20,null,null,15,7]
输出：true

                    (1)
                  /    \
               (2)     (2)
             /    \
          (3)     (3)
        /    \
      (4)     (4)
输入：root = [1,2,2,3,3,null,null,4,4]
输出：false
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

  /*solution1:自底向上递归
  * */
  public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        return helper(root)!=-1;  //如果不为平衡二叉树则返回-1
  }
        /* 自底向上递归api
        * */
  private int helper(TreeNode root){
        if (root == null) return 0;

        int left=helper(root.left);
        int right = helper(root.right);
        if (left == -1 || right == -1 || Math.abs(left-right) > 1) {
            return -1;
        }
        return Math.max(left,right)+1;
  }

}
