package com.itCs520.deanProject.services.Day05.Tree;

public class BinaryTreeMaxDepth<Key extends Comparable<Key>,Value> {
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
        public  Node(Key key,Value value,Node left,Node right){
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
    public Node put(Node x,Key key,Value val){
        //如果x子树为空
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
    //根据Key从树中找出对应值
    public Value get(Key key){
        return get(root,key);
    }
    //从指定树X上，找出对应的key值
    public Value get(Node x,Key key){
        //x树为null的情况
        if (x==null){
            return  null;
        }

        //x树不为空的情况
        int cmp= key.compareTo(x.key);
        if (cmp>0){
            //如果key大于x结点的键，则继续找x结点的左子树
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
    public  Node delete(Node x,Key key){
        //如果x树为null
        if (x==null){
            return  null;
        }
        //如果x子树不为空
        //比较x结点的键和key的大小
        int cmp=key.compareTo(x.key);
        if (cmp>0){
            //如果key大于x结点的键，则继续找x结点的右子树
            x.right = delete(x.right,key);
        }else if (cmp<0){
            //如果key小于x结点的键，则继续找x结点的左子树
            x.left = delete(x.left,key);
        }else {
            //如果key等于x结点的键,则完成真正删除的动作
            //元素个数-1
             N--;
            //得到右子树中最小的结点
            if (x.right==null){
                return x.left;
            }
            if (x.left==null){
                return x.right;
            }
            //找到右子树中最小的结点
            Node minNode=x.right;
            while (minNode!=null){
                minNode=minNode.left;
            }
            //删除右子树中的最小结点
            Node n=x.right;
            while (n.left !=null){
                if (n.left.left==null){
                    n.left=null;
                }else {
                    //变换n的结点即可
                    n=n.left;
                }
            }
            //让x结点的左子树成为minNode的左子树
                minNode.left = x.left;
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

    //获取整个树最大深度
    public int maxDepth(){
        return maxDepth(root);
    }
    /*获取指定树x的最大深度
    * */
    private int maxDepth(Node x) {
        //考虑当前树不存在情况
        if (x==null){
            return 0;
        }
        //初始化x的最大深度
        int max=0;
        //左子树最大深度
        int maxL=0;
        //右子树最大深度
        int maxR=0;
        //计算x结点左子树的最大深度
        if (x.left!=null){
            maxL=maxDepth(x.left);
        }
        //计算x结点右子树的最大深度
        if (x.right!=null){
            maxR=maxDepth(x.right);
        }
        //比较左子树的最大深度和右子树的最大深度，取较大值+1即可
        max = maxL>maxR?maxL+1:maxR+1;

        return max;
    }

}
