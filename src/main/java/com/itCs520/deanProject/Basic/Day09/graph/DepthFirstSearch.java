package com.itCs520.deanProject.Basic.Day09.graph;

import com.itCs520.deanProject.Basic.Day09.graph.Graph;

public class DepthFirstSearch {
    //索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean[] marked;
    //记录多少个顶点被搜索
    private int count;

    //构建深度优先搜索对象，使用深度优先搜索找出G图中V顶点的所有想通顶点
    public DepthFirstSearch(com.itCs520.deanProject.Basic.Day09.graph.Graph G, int s){
        //初始化marked 数组
        this.marked=new boolean[G.V()];
        //初始化顶点
        this.count=0;

        dfs(G,s);
    }
    //深度优先搜索找出G图中V顶点的所有相通顶点
    private void dfs(Graph G, int v){
        //v顶点标识为已搜索
        marked[v] = true;
        //通过循环搜索与V相通的所有顶点
        for (Integer w : G.adj(v)) {
            //判断当前w顶点没有被搜索过，如果没有被搜索，则递归调用dfs方法进行深度搜索
            if (!marked[w]){
                dfs(G,w);
            }
        }
        //相同顶点+1
        count++;
    }

    //判断w顶点与s顶点是否想通
    public boolean marked(int w){
        //是否搜索过，如果搜索过则代表相通
        return marked[w];
    }
    //获取与顶点s相通的所有顶点总数
    public int count(){
        return count;
    }
}
