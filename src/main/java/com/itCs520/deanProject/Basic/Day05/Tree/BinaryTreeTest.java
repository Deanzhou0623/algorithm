package com.itCs520.deanProject.Basic.Day05.Tree;

import com.itCs520.deanProject.Basic.Day05.Tree.BinaryTree2;

public class BinaryTreeTest {
    public static void main(String[] args) {
        //创建二叉查找树
        com.itCs520.deanProject.Basic.Day05.Tree.BinaryTree2<Integer, String> tree = new BinaryTree2<>();
        //测试插入操作
        tree.put(1,"aa");
        tree.put(2,"bb");
        tree.put(3,"cc");
        tree.put(4,"dd");
        System.out.println("插入完毕后元素的个数:"+tree.size());

        //测试获取
        System.out.println("键2对应的元素是："+tree.get(2));
//        //测试删除
        tree.delete(3);
        System.out.println("删除后的元素个数："+tree.size());
        System.out.println(tree.get(3));
    }
}
