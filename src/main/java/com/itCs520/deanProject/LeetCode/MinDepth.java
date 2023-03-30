package com.itCs520.deanProject.LeetCode;/*
 *ClassName:MinDepth
 *Description:
 *@Author:deanzhou
 *@Date:2023/3/22 15:28
 */

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth {
    /*给定一个二叉树，找出最小深度
     最小深度是从根结点到叶子结点最短路径上的路径数
    * */
    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node6 = new TreeNode(6, node7, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, node6, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);
        System.out.println(minDepth(node1));
        System.out.println(minDepth2(node1));
        /*
        *                 1
        *             /       \
        *            2          3
        *         /    \       /
        *        4      5    6
        *                   /
        *                  7
        * */

    }
    /* 深度优先遍历 DFS depth first search  time: 取决于树的高度O(n) space ：logn
    * */
    public static int minDepth(TreeNode root){
        if (root ==null)
            return 0;
        if (root.left == null && root.right ==null)
            return 1;

        int min = Integer.MAX_VALUE;
        if (root.left!=null){
            min = Math.min(minDepth(root.left),min);
        }
        if (root.right!=null){
            min = Math.min(minDepth(root.right),min);
        }
        return min+1; // plus root
    }

    /* BFS :borad first search  通过queue 实现 time:O(n) space：O(n)
    * */
    public static int minDepth2(TreeNode root){
        if (root ==null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        root.depth=1;
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            // node is leaf
            if (node.left == null && node.right ==null){
                return node.depth;
            }
            // node has left child
            if (node.left!=null)
                node.left.depth = node.depth+1;
                queue.offer(node.left);
            // node has right child
            if (node.right!=null)
                node.right.depth=node.depth+1;
                queue.offer(node.right);
        }

        return 0;
    }
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        int depth;
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
