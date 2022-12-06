package com.itCs520.deanProject.LeetCode;

public class LeetCode226 {
    /*给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。

    示例 1：
            (4)                                (4)
          /     \                            /     \
        (2)     (7)            --->        (7)     (2)
       /   \    /   \                     /   \    /   \
     (1)   (3) (6)   (9)               (9)   (6) (3)   (1)

    输入：root = [4,2,7,1,3,6,9]
    输出：[4,7,2,9,6,3,1]

    示例 2：

    输入：root = [2,1,3]
    输出：[2,3,1]
    * */

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
    /*solution1: 递归调用
    * */
    public TreeNode invertTree(TreeNode root) {
        //1. 安全性校验
        if (root == null) return null;
        //2. 递归调用反转左子树
        invertTree(root.left);
        //3. 递归调用反转右子树
        invertTree(root.right);
        //4. 交换左子结点和右子结点
        TreeNode temp=root.left;
        root.left = root.right;
        root.right = temp;
        //5. 返回对象
        return root;

    }
}
