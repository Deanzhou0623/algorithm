package com.itCs520.deanProject.Basic.Day05.Tree;

import com.itCs520.deanProject.Basic.Day05.Tree.BinaryTreeMaxDepth;

public class BinaryTreeMaxDepthTest {
    public static void main(String[] args) {
        //创建二叉查找树
        com.itCs520.deanProject.Basic.Day05.Tree.BinaryTreeMaxDepth<String, String> tree = new BinaryTreeMaxDepth<>();
        //测试插入操作
        tree.put("E","5");
        tree.put("B","2");
        tree.put("G","7");
        tree.put("A","1");
        tree.put("D","4");
        tree.put("F","6");
        tree.put("H","8");
        tree.put("C","3");

        //最大深度
        int max = tree.maxDepth();
        System.out.println("最大深度为"+max);
    }
}
