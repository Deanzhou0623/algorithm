package com.itCs520.deanProject.services.Day05.Tree;

/*后续遍历
* */
import com.itCs520.deanProject.services.Day04.linear.Queue;

public class BinaryTreeAfterErgodic<Key extends Comparable<Key>,Value> {
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

    //获得树中所有的键  后序遍历
    public Queue<Key> afterErgodic(){
        Queue<Key> keys = new Queue<>();
        afterErgodic(root,keys);
        return keys;
    }
    //获得指定树x中所有的键，并放到keys队列中  后序遍历
    private void afterErgodic(Node x, Queue<Key> keys){
        //该树为空
        if (x==null){
            return ;
        }
        //遍历x结点到左子树
        if (x.left!=null){
            afterErgodic(x.left,keys);
        }
        //遍历x结点到右子树
        if(x.right!=null){
            afterErgodic(x.right,keys);
        }
        //把x结点的key放入到keys中
        keys.enqueue(x.key);

    }
}
