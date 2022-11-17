package com.itCs520.deanProject.Basic.Day05.Tree;

import com.itCs520.deanProject.Basic.Day04.linear.Queue;

public class BinaryTreeErgodic2<Key extends  Comparable<Key>,Value>{
    //记录根结点
    private Node root;
    //记录树中元素个数
    private int N;

    public class Node {
        //存储键
        public Key key;
        //存储值
        public Value value;
        //记录左子结点
        public Node left;
        //记录右子结点
        public  Node right;

        //构造方法
        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    //获取树中的元素个数
    public int size(){
        return N;
    }

    //添加一个键值对，并返回添加后的新树
    public void put(Key key,Value value){
        root=put(root,key,value);
    }

    //从指定树X上，添加一个键值对，并返回添加后的新树
    public Node put(Node x,Key key,Value value){
        //如果子树为空,则添加的结点为该树的根结点
        if (x==null){
            N++;
            return new Node(key,value,null,null);
        }
        //如果子树不为空
        //比较x结点的键和key的大小
        int cmp=key.compareTo(x.key);
        if (cmp>0){
            //如果key大于x结点的键，则继续找x结点的右子树
            x.right = put(x.right,key,value);
        }else if (cmp<0){
            //如果key小于x结点的键，则继续找x结点的左子树
            x.left = put(x.left,key,value);
        }else {
            //如果key等于x结点的键,则替换x结点的值为value
            x.value=value;
        }
        return x;
    }
    //根据Key从树中找出对应值
    public Value get(Key key){
        return get(root,key);
    }
    //从指定树X上，找出对应的key值
    public Value get(Node x, Key key){
        //x树为null的情况
        if (x==null){
            return null;
        }
        //x树不为空的情况
        int cmp=key.compareTo(x.key);
        if (cmp>0){
            //如果key大于x结点的键，则继续找x结点的右子树
            return get(x.right,key);
        }else if (cmp<0){
            //如果key小于x结点的键，则继续找x结点的左子树
            return get(x.left,key);
        }else {
            //如果key等于x终点的键，就找到了键为key的结点，只需要返回x的结点值即可
            return x.value;
        }
    }
    //根据key删除树中对应的键值对
    public void delete(Key key){
        delete(root,key);
    }
    //删除指定树x上的键为key的键值对，并返回删除后的新树
    public Node delete(Node x, Key key){
        //如果x树为null
        if (x==null){
            return  null;
        }
        //如果x子树不为空
        //比较x结点的键和key的大小
        int cmp=key.compareTo(x.key);
        if (cmp>0){
            //如果key大于x结点的键，则继续找x结点的右子树
            x.right=delete(x.right,key);
        }else if (cmp<0){
            //如果key小于x结点的键，则继续找x结点的左子树
            x.left=delete(x.left,key);
        }else {
            //如果key等于x结点的键,则完成真正删除的动作
            //元素个数减1
            N--;
            //得到右子树中最小的结点 ,因为结点要比左子树最大结点大
            if (x.right==null){
                return x.left;
            }
            if (x.left==null){
                return x.right;
            }
            //得到右子树中的最小结点
            Node minNode=x.right;
            while (minNode!=null){
                minNode=minNode.left;
            }
            //删除右子树中最小结点
            Node n=x.right;
            while (n.left!=null){
                if (n.left.left==null){
                    n.left=null;
                }else {
                    n=n.left;
                }
            }
            //让x结点的左子树成为minNode的左子树
            minNode.left=x.left;
            //让x结点的右子树成为minNode的右子树
            minNode.right = x.right;
            //让x结点的父结点指向minNode
            x=minNode;
        }
        return x;
    }
    //超找出最小结点
    public Key min(){
        return min(root).key;

    }
    //具体方法的实现
    //在指定树中找出最小结点
    public Node min(Node x){
        //需要判断x还有没有左子结点，如果有则继续向左找，如果没有，则x就是最小键所在结点
        if(x.left!=null){
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
        if(x.right!=null){
            return max(x.right);
        }else {
            return x;
        }
    }
//前序遍历
    //获取树中所以的键
    public Queue<Key> preErgodic(){
        Queue<Key> keys = new Queue<>();
        preErgodic(root,keys);
        return keys;
    }
    //获得指定树x中所有的键，并放到keys队列中
    private void preErgodic(Node x, Queue<Key> keys){
        //该树为空
        if (x==null){
            return ;
        }
        //该树不为空
        //把x结点的key放入到keys中
        keys.enqueue(x.key);
        //遍历x结点的左子树
        if (x.left!=null){
            preErgodic(x.left,keys);
        }
        //遍历x结点右子树
        if (x.right!=null){
            preErgodic(x.right,keys);
        }
    }

 //中序遍历
 //获取树中所以的键
    public Queue<Key> midErgodic(){
         Queue<Key> keys = new Queue<>();
         midErgodic(root,keys);
         return keys;
    }
    //获得指定树x中所有的键，并放到keys队列中
    private void midErgodic(Node x, Queue<Key> keys){
        //该树为空
        if (x==null){
            return ;
        }
        //该树不为空
        //遍历x结点的左子树
        if (x.left!=null){
            midErgodic(x.left,keys);
        }
        //把x结点的key放入到keys中
        keys.enqueue(x.key);
        //遍历x结点右子树
        if (x.right!=null){
            midErgodic(x.right,keys);
        }
    }
        //后续遍历
        public Queue<Key> afterErgodic(){
            Queue<Key> keys = new Queue<>();
            afterErgodic(root,keys);
            return keys;
        }
    //获得指定树x中所有的键，并放到keys队列中
    private void afterErgodic(Node x, Queue<Key> keys){
        //该树为空
        if (x==null){
            return ;
        }
        //该树不为空
        //遍历x结点的左子树
        if (x.left!=null){
            afterErgodic(x.left,keys);
        }
        //遍历x结点右子树
        if (x.right!=null){
            afterErgodic(x.right,keys);
        }
        //把x结点的key放入到keys中
        keys.enqueue(x.key);
    }
 //层序遍历
    //使用层序遍历，获得整个树种的key
    public Queue<Key> layerErgodic(){
        //定义两个队列分别存储树中的key和树中的结点
        Queue<Key> keys = new Queue<>();
        Queue<Node> nodes = new Queue<>();

        //默认往队列添加根结点
        nodes.enqueue(root);

        while (!nodes.isEmpty()){
            //从列表中弹出一个结点放入keys中
            Node node = nodes.dequeue();
            keys.enqueue(node.key);
            //判断当前结点有没有左结点
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
    //获取整个树的最大深度
    public int maxDepth(){
        return maxDepth(root);
    }
    //获取指定树的最大深度
    private int maxDepth(Node x){
        //考虑树不存在的情况
        if (x==null){
            return 0;
        }
        //树存在
        //初始化深度x
        int max=0;
        //左子树最大深度
        int maxL=0;
        //右子树最大深度
        int maxR=0;
        //计算左子树的最大深度
        if (x.left!=null){
            maxL=maxDepth(x.left);
        }
        //计算右子树的最大深度
        if (x.right!=null){
            maxR=maxDepth(x.right);
        }
        //比较左子树的最大深度和右子树的最大深度，取较大值+1即可
        max=maxL>maxR?maxL+1:maxR+1;
        return max;
    }
}
