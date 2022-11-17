package com.itCs520.deanProject.Basic.Day08.tree;

import com.itCs520.deanProject.Basic.Day08.tree.RedBlackTree;

public class RedBlackTreeTest {
    public static void main(String[] args) {
         //创建红黑树
        com.itCs520.deanProject.Basic.Day08.tree.RedBlackTree<String, String> tree = new RedBlackTree<>();

        //插入数据
        tree.put("1","AA");
        tree.put("2","BB");
        tree.put("3","CC");
        tree.put("4","DD");
        //从树中获取元素
        String s = tree.get("1");
        System.out.println(s);

        String s2 = tree.get("2");
        System.out.println(s2);
        String s3 = tree.get("3");
        System.out.println(s3);
    }
}
