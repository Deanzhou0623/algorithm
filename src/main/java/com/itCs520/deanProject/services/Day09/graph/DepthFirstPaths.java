package com.itCs520.deanProject.services.Day09.graph;

import com.itCs520.deanProject.services.Day04.linear.Queue;
import com.itCs520.deanProject.services.Day04.linear.Stack;

public class DepthFirstPaths {

    //索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean[] marked;
    //起点
    private int s;
    //索引代表顶点，值代表从起点s到当前顶点路径上的最后一个顶点
    private int[] edgoTo;

    //构建深度优先搜索对象，使用深度优先搜索找出G图中V顶点的所有想通顶点
    public DepthFirstPaths(Graph G,int s){
        //初始化marked 数组
        this.marked=new boolean[G.V()];
        //初始化顶点
        this.s=s;
        //初始化edgoTo数组
        this.edgoTo = new int[G.V()];

    }
    //深度优先搜索找出G图中V顶点的所有相通顶点
    private void dfs(Graph G,int v){
        //v顶点标识为已搜索
        marked[v] = true;
        //遍历v的邻接表，拿到每一个相邻的顶点，继续递归搜索
        for (Integer w : G.adj(v)) {
            //如果顶点w没有被搜索则继续递归搜索
            if (!marked[w]){
                edgoTo[w]=v;    //到达顶点w路径上最后一个顶点v
                dfs(G,w);
            }
        }
    }
    //判断w顶点和s顶点是否在路径上
    public boolean hasPathTo(int v){
        return marked[v];
    }
    //找出从起点s到顶点v的路径(就是该路径经过顶点)
    public Stack<Integer> pathTo(int v){
        //判断是否存在路径
        if (!hasPathTo(v)){
            return null;
        }
        //创建栈对象，保存路径中所有顶点
        Stack<Integer> stack = new Stack<>();
        //通过循环一直从顶点v开始找，找到起点位置
        for (int i = v; i!=s ; i=edgoTo[i]) {
            stack.push(i);
        }
        //把起点放入到栈中
        stack.push(s);
        return stack;
    }
}
