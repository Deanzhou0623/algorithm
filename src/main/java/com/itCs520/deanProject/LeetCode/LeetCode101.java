package com.itCs520.deanProject.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode101 {
    /*给你一个二叉树的根节点 root ， 检查它是否轴对称。

    示例1：
                    (1)
                  /  |  \
                (2)  |    (2)
              /   \  |   /   \
            (3)   (4)|  (4)   (3)
                     |
    输入：root = [1,2,2,3,4,4,3]
    输出：true

                    (1)
                  /     \
               (2)      (2)
                 \         \
                 (3)        (3)
    输入：root = [1,2,2,null,3,null,3]
    输出：false
     * */

//    Definition for a binary tree node.
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
    /*solution1： 递归调用实现
     * */
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        //调用函数比较左子结点和右子结点
        return deepCheck(root.left,root.right);
    }

    private boolean deepCheck(TreeNode left, TreeNode right) {
        //递归的终止条件是两个结点都为空
        //或者两个结点有一个为空
        //或者两个结点的值不相等
        if ( left == null && right == null  ) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;

        //再递归比较比较左结点的左孩子，右结点的右孩子
        //以及比较左结点的右孩子 和 右结点的左孩子
        return deepCheck(left.left, right.right) && deepCheck(left.right ,right.left);
    }

    /*solution2:循环迭代 + 队列的方式
    * */
    public boolean isSymmetric2(TreeNode root) {
        //1.创建队列用于存储树中的node
        Queue<TreeNode> q = new LinkedList<>();
        //2.定义root的左子结点和右子结点
        TreeNode u=root.left;
        TreeNode v=root.right;
        //3.安全性校验 root是否为空
        if (root == null ||(u==null && v==null)) return true;
        //4.root的左子结点和右子结点入栈
        q.offer(u);
        q.offer(v);
        //5.安全性校验 队列是否为空
        while (!q.isEmpty()){
            u=q.poll();
            v=q.poll();
            //判断 uv是否为空 或者 uv是否不对称
            if (u==null && v==null) continue;
            //6.左子结点和右子结点出队进行比较
            //7.比较左子结点和右子结点是否想等
            if ((u==null || v==null) || (u.val!=v.val)) return false;

            //8.左子结点的左子结点和右子结点的右子结点入栈
            q.offer(u.left);
            q.offer(v.right);
            //左子结点的右子结点和右子结点的左子结点入栈
            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }

}
