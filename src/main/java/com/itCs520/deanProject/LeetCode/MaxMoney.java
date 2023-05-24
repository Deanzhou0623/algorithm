package com.itCs520.deanProject.LeetCode;/*
 *ClassName:MaxMoney
 *Description:
 *@Author:deanzhou
 *@Date:2023/5/16 18:38
 */

public class MaxMoney {
    public static class TreeNode {
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
    /*
    *   打家劫舍
    * 你是一个专业小偷 ，计划沿街的房屋 ，每个房间内都藏有一定的现金，影响你偷窃的唯一制约因素
    * 就是相邻的房屋装有相互联通的防盗系统 ，如果两个房屋之间在同一个晚上被闯入，系统会自动报警
    * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动报警装置的前提下，一夜之间能够偷取的最高金额
    *
    * 输入：[1,2,3,1] max:4
    * 输入: [2,7,9,3,1] max: 12
    * */

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,9,3,1 };
//        System.out.println(maxMoney(nums, nums.length-1));
//        System.out.println(maxMoney1(nums));
        //第二题：
        //最后一个不要 /第一个不要
//        System.out.println(Math.max(maxMoney2(nums,0, nums.length-2),maxMoney2(nums,1,nums.length-1)));
        TreeNode treeNode5 = new TreeNode(1, null, null);
        TreeNode treeNode4 = new TreeNode(3, null, null);
        TreeNode treeNode3 = new TreeNode(3, null, treeNode5);
        TreeNode treeNode2 = new TreeNode(2, null, treeNode4);
        TreeNode treeNode1 = new TreeNode(3, treeNode2, treeNode3);

        int[] i = dfs(treeNode1);
        System.out.println(Math.max(i[0],i[0]));
    }
    //method1: recursion
    static int maxMoney(int[] nums,int index){
        if (nums == null || index <0) return 0;

        //下标只剩一个元素
        if (index == 0) return nums[0];

        return Math.max(maxMoney(nums, index-1),maxMoney(nums, index-2)+nums[index]);
    }
    //动态规划：最优子结构：每个最优解都包涵子问题的最优解  n -> n-1
    // 递推公式 （关系转移表达式）
    // 重叠子问题 递归
    static int maxMoney1(int[] nums){
        int length = nums.length;

        if (nums == null || length ==0) return 0;

        //下标只剩一个元素
        /*if (length == 1) return nums[0];
        //space：O(n)
        int[] dp=new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i <length ; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[length-1];*/

        //space:O(1)
        int first=nums[0] ,second = nums[1];
        for (int i = 2; i < length; i++) {
            int temp = second;
            second = Math.max(first+nums[i],second);
            first = temp;
        }
        return second;
    }


    /*
    * 升级版， 在（1）题的基础上 ， 首尾相连
    * [2,7,9,3,1,4,] 首的2 是和尾的1 相连
    * solution: 拆解 在方法1的基础上 排除 index为 length-1 或者 index为0
     * */
    static int maxMoney2(int[] nums,int start,int end){
        int first =nums[start], second =Math.max(nums[start],nums[start]+1);

        for (int i = start + 2; i <= end ; i++) {
            int temp = second;
            second = Math.max(first+ nums[i],second);
            first = temp;
        }
        return second;
    }

    /*
    * 新的可行窃的区域 。这个地区只有一个入口........
    * 类似于一颗二叉树 ，两个直接相连的房子在同一天被打劫，房屋将自动报警
    *
    * */
    public static int[] dfs(TreeNode node){
        //int[] {select的最优解，noselect的最优解}
        if (node ==null)
            return new int[]{0,0};

        int[] left=dfs(node.left);
        int[] right=dfs(node.right);
        int select = node.val+ left[1] + right[1];
        int notSelect=Math.max(left[0],left[1]) + Math.max(right[0],right[1] );
        return new int[]{select,notSelect};
    }
}
