package com.itCs520.deanProject.Basic.Summary2.Tree;

import com.itCs520.deanProject.Basic.Day04.linear.Queue;
import com.itCs520.deanProject.Basic.Day05.Tree.BinaryTreeMidErgodic;

public class midErgodic<Key extends Comparable<Key>,Value> {
    //记录根结点
    private Node root;
    //记录树中元素个数
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
        public  Node(Key key, Value value,Node left,Node right){
            this.key=key;
            this.value=value;
            this.left=left;
            this.right=right;
        }
    }

    //获取树中的所有键
    public Queue<Key> midErgodic(){
        Queue<Key> keys = new Queue<>();
        midErgodic(root,keys);
        return keys;
    }
    //获得指定树x中所有的键，并放到keys队列中
    private void midErgodic(Node x,Queue<Key> keys){
        if (x==null){
            return;
        }
        //遍历x的左子树
        if (x.left!=null){
            midErgodic(x.left,keys);
        }
    }
}
