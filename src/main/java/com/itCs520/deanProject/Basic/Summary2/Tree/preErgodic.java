package com.itCs520.deanProject.Basic.Summary2.Tree;

import com.itCs520.deanProject.Basic.Day04.linear.Queue;
import com.itCs520.deanProject.Basic.Day05.Tree.BinaryTreePreErgodic;

public class preErgodic <Key extends Comparable<Key>,Value>{
    //记录根结点
    private Node root;
    //记录元素中的个数
    private int N;
    public class Node{
        //存储键
        public  Key key;
        //存储值
        public  Value value;
        //记录左子结点
        public Node left;
        //记录右子结点
        public Node right;

        //构造方法
        public  Node(Key key, Value value, Node left, Node right){
            this.key=key;
            this.value=value;
            this.left=left;
            this.right=right;
        }
    }
    //获取树中元素个数
    public int size(){
        return N;
    }
    //添加一个键值对，并返回添加后的新树
    public void put(Key key,Value val){
        root=put(root,key,val);
    }
    //从指定树X上，添加一个键值对，并返回添加后的新树
    public Node put(Node x, Key key, Value val){
        //如果x子树为null
        if (x==null){
            N++;
            return new Node(key,val,null,null);
        }
        //如果x子树不为空
        //比较x结点的键和key的大小
        int cmp=key.compareTo(x.key);
        if (cmp>0){
            //如果key大于x结点的键，则继续找x结点的右子树
            x.right = put(x.right,key,val);
        }else if (cmp<0){
            //如果key小于x结点的键，则继续找x结点的左子树
            x.left = put(x.left,key,val);
        }else {
            //如果key等于x结点的键,则替换x结点的值为value
            x.value=val;
        }
        return x;
    }
    //获得树中所有的键
    public Queue<Key> preErgodic(){
        Queue<Key> keys = new Queue<>();
        preErgodic(root,keys);
        return keys;
    }
    //获得指定树x中所有的键，并放到keys队列中
    private void preErgodic(Node x, Queue<Key> keys){
        //如果该树为空
        if (x==null){
            return;
        }
        //把x结点的key放在keys中
        keys.enqueue(x.key);
        //遍历左子树
        if (x.left!=null){
            preErgodic(x.left,keys);
        }
        //遍历x结点到右子树
        if (x.right!=null){
            preErgodic(x.right,keys);
        }
    }
}
