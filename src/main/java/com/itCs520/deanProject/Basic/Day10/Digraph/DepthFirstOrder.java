package com.itCs520.deanProject.Basic.Day10.Digraph;


import com.itCs520.deanProject.Basic.Day04.linear.Stack;

public class DepthFirstOrder {
    //索引代表顶点，值表示当前顶点已经被搜索
    private boolean[] Marked;
    //使用栈存储顶点序列
    private Stack<Integer> reversePost;

    //创建一个检测环对象,判断有向图g中是否有环
    public DepthFirstOrder(com.itCs520.deanProject.Basic.Day10.Digraph.Digraph G){
        //初始化Marked数组
        this.Marked=new boolean[G.V()];
        //初始化Stack
        this.reversePost=new Stack<Integer>();
        //找到图中的每一个顶点，让每一个顶点作为入口，调用一次dfs进行搜索
        for (int v = 0; v <G.V() ; v++) {
            //判断当前顶点还没被搜索过，则调用dfs进行搜索
            if (!Marked[v]){
                dfs(G,v);
            }
        }


    }
    //深度优先搜索找出G图中V顶点，并进行排序
    public void dfs(Digraph G, int v){
        //顶点V表示已经搜索过
        Marked[v]=true;
        //进行深度搜索
        for (Integer w:G.adj(v)) {
            //判断当前顶点w没有被搜索过，则继续递归调用dfs完成深度优先搜索
            if (!Marked[w]){
                dfs(G,w);
            }
        }
        //顶点V进栈
        reversePost.push(v);
    }
    //　获取顶点线性序列
    public Stack<Integer> reversePost(){
        return  reversePost;
    }

}
