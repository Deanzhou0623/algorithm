package com.itCs520.deanProject.Basic.Summary2.Tree;


public class MaxDepth<Key extends Comparable<Key>,Value>  {
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
    //获取树中的最大深度
    public int maxDepth(){return maxDepth(root);}
    /*获取指定树x的最大深度
    * */
    private int maxDepth(Node x){
        //考虑当前树不存在情况
        if (x==null){
            return 0;
        }
        //初始化最大深度
        int max=0;
        //左子树最大深度
        int maxL=0;
        //右子树最大深度
        int maxR=0;
        //计算x结点左子树的最大深度
        if(x.left!=null){
            maxL=maxDepth(x.left);
        }
        //计算x结点右子树的最大深度
        if (x.right!=null){
            maxR=maxDepth(x.right);
        }
        //比较左子树的最大深度和右子树最大深度,取较大值+1
        max = maxL>maxR?maxL+1:maxR+1;
        return max;
    }
}
