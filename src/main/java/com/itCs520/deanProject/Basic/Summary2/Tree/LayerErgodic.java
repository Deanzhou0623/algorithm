package com.itCs520.deanProject.Basic.Summary2.Tree;

import com.itCs520.deanProject.Basic.Day04.linear.Queue;

public class LayerErgodic <Key extends Comparable<Key>,Value>{
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
        public  Node(Key key, Value value, Node left,Node right){
            this.key=key;
            this.value=value;
            this.left=left;
            this.right=right;
        }
    }

    //获取整个树的key
    public Queue<Key> layerErgodic(){
        //定义两个对象分别存储树中的key和树中的结点
        Queue<Key> keys = new Queue<>();
        Queue<Node> nodes = new Queue<>();

        //默认往队列中存放入根结点
        nodes.enqueue(root);

        while (!nodes.isEmpty()){
            //从队列中弹入一个结点，把key放入keys中
            Node node=nodes.dequeue();
            keys.enqueue(node.key);
            //判断当前结点还有没有左子结点
            if (node.left!=null){
                nodes.enqueue(node.left);
            }
            //判断当前结点还有没有右子结点
            if (node.right!=null){
                nodes.enqueue(node.right);
            }
        }
        return keys;
    }
}
