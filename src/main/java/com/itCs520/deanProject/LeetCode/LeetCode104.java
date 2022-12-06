package com.itCs520.deanProject.LeetCode;



import java.util.LinkedList;
import java.util.Queue;

public class LeetCode104 {
    /*LeetCode最大深度问题
    给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。
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

    /*solution1:递归调用返回二叉树最大深度
    * */

    public int maxDepth(TreeNode root) {
        //1. 安全性校验
        if (root == null) {
            return 0;
        }else {
            //2. 递归调用方法
            return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        }

    }
    /*solution2： 循环队列实现找出树的高度   BFS

    * */
    public int maxDepth2(TreeNode root) {
        //1. 安全性校验
        if (root == null) return 0;
        //2. 定义队列存储root 结点
        Queue<TreeNode> queue = new LinkedList<>();
        //3. 定义变量记录高度
        int depth=0;
        //4. 循环队列
        while (!queue.isEmpty()){
            //size记录本层级的结点是否已经处理完
            int size = queue.size();
            //循环本层级
            while (size>0){
                TreeNode node = queue.poll();
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
                size--;
            }
            depth++;
        }

        //5. 返回对象
        return depth;
    }
}
