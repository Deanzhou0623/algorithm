package com.itCs520.deanProject.services.Day05.Tree;

public class BinaryTree2 <Key extends Comparable<Key>,Value> {
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
        public  Node(Key key, Value value, Node left, Node right){
            this.key=key;
            this.value=value;
            this.left=left;
            this.right=right;
        }
    }
    //获取树中的元素
    public int size(){
        return N;
    }

    //添加一个键值对，并返回添加后的新树
    public void put(Key key,Value value){
        root=put(root,key,value);
    }
    //从指定x树上，添加一个键值对,并返回添加后对新树
    public Node put(Node x,Key key,Value value){
        //1. 子树为空，则直接添加新对结点并返回对象
        if (x==null){
            //子树个数+1
            N++;
            return new Node(key,value,null,null);
        }
        //2. 子树不为空
        //比较x结点的键和key的大小,查找二叉树按照键顺序存放值
        int cmp=key.compareTo(x.key);
        if (cmp>0){ //大于x放右边
            //如果key大于x结点的值，则继续寻找x结点的右子树
            x.right=put(x.right,key,value);
        }else if (cmp<0){
            //如果key小于x结点的键，则继续寻找x结点的左子树
            x.left = put(x.left,key,value);
        }else {
            //如果 key = x.key,则替换x结点的值为value
            x.value=value;
        }
        //返回添加到树中的结点
        return x;
    }

    //根据key从树中找出对应值
    public Value get(Key key){
        return get(root,key);
    }
    //从指定树x上，找出对应key的值
    public Value get(Node x,Key key){
        //1. x树为null的情况
        if (x==null){
            return null;
        }
        //2. x树不为空的情况
        int cmp= key.compareTo(x.key);
        //比较根结点的key值与要找元素的key
        if (cmp>0){
            //key大于x结点的键，则继续寻找右子树
            return get(x.right,key);
        }else if (cmp<0){
            //key小于x结点的键，则继续寻找左子树
            return get(x.left,key);
        }else{
            //key等于x结点的键，则返回x的结点值即可
            return x.value;
        }

    }

    //根据key删除树中对应的键值对
    public void delete(Key key){
        delete(root,key);
    }

    //删除指定树x上键为key的键值对,并返回删除后的新树
    public Node delete(Node x,Key key){
        //1. 如果x树为null
        if (x==null){
            return null;
        }
        //2. 如果x子树不为空
        //2.1 比较x结点的键和key的大小
        int cmp= key.compareTo(x.key);
        if (cmp>0){
            //2.2 如果key大于x结点的键，则继续找x结点的右子树
            x.right = delete(x.right,key);
        }else if (cmp<0){
            //2.3 如果key小于x结点的键，则继续找x结点的左子树
            x.left = delete(x.left,key);
        }else {
            //2.4 如果key等于x结点的键，则删除该结点
            //2.4.1 元素个数减1
            N--;
            //2.4.2 得到右子树中最小的点
            if (x.right==null){
                return x.left;
            }
            if (x.left==null){
                return x.right;
            }
            //找到右子树中的最小结点
            Node minNode=x.right;
            while (minNode!=null){ //子树 左子结点 小于右子结点
                minNode=minNode.left;
            }
            //删除右子树中的最小结点
            Node n=x.right;
            while (n.left!=null){
                if(n.left.left==null){
                    n.left=null;
                }else {
                    //变换n的结点即可
                    n=n.left;
                }
            }
            //让x结点的左子树成为minNode的左子树
            minNode.left=x.left;
            //让x结点的右子树成为minNode的右子树
            minNode.right=x.right;
            //让x结点的父结点指向minNode  因为采用递归调用，所以会指向父结点
            x=minNode;
        }
        //3. 返回结果
        return x;
    }
    //找出最小结点
    public Key min(){
        return min(root).key;
    }
    //在指定树中找出最小结点
    public Node min(Node x){
        //需要判断x还有没有左子结点，如果有则继续左找，如果没有，则x就是最小键所在结点
        if (x.left!=null){
            return min(x.left);
        }else {
            return x;
        }
    }

    //找出整个树的最大键
    public Key max(){
        return max(root).key;
    }
    //找出指定树中最大键所在结点
    public Node max(Node x){
        //需要判断x还有没有右子结点，如果有则继续向右找，如果没有，则x就是最大键所在结点
        if (x.right!=null){
            return max(x.right);
        }else {
            return x;
        }
    }
}
