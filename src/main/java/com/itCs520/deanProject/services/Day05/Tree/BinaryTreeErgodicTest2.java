package com.itCs520.deanProject.services.Day05.Tree;

import com.itCs520.deanProject.services.Day04.linear.Queue;

public class BinaryTreeErgodicTest2 {
    public static void main(String[] args) {
        //创建二叉查找树
//        BinaryTreePreErgodic<String, String> tree = new BinaryTreePreErgodic<>();
//        BinaryTreeMidErgodic<String, String> tree = new BinaryTreeMidErgodic<>();
//        BinaryTreeAfterErgodic<String, String> tree = new BinaryTreeAfterErgodic<>();
//        BinaryTreeLayerErgodic<String, String> tree = new BinaryTreeLayerErgodic<>();
        BinaryTreeErgodic2<String, String> tree = new BinaryTreeErgodic2<>();
        //测试插入操作
        tree.put("E","5");
        tree.put("B","2");
        tree.put("G","7");
        tree.put("A","1");
        tree.put("D","4");
        tree.put("F","6");
        tree.put("H","8");
        tree.put("C","3");

//        Queue<String> strings = tree.preErgodic();
//
//        for (String string : strings) {
//            String value = tree.get(string);
//            System.out.println(string+"....."+value);
//        }
//
//        Queue<String> strings = tree.midErgodic();
//
//        for (String string : strings) {
//            String value = tree.get(string);
//            System.out.println(string+"....."+value);
//        }
//
//        Queue<String> strings = tree.afterErgodic();
//
//        for (String string : strings) {
//            String value = tree.get(string);
//            System.out.println(string+"....."+value);
//        }
//        Queue<String> strings = tree.layerErgodic();
//
//        for (String string : strings) {
//            String value = tree.get(string);
//            System.out.println(string+"....."+value);
//        }
        //最大深度
        int max = tree.maxDepth();
        System.out.println("最大深度为"+max);
    }
}
