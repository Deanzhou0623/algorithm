package com.itCs520.deanProject.Basic.Day09.graph;/*
 *ClassName:DFS
 *Description:
 *@Author:deanzhou
 *@Date:2023/4/14 13:55
 */

public class DFS {
    //索引代表顶点，值代表顶点是否被搜索过
    private boolean[] marked;
    //记录有多少个顶点与顶点s相通
    private int count;

    //构造深度优先搜索对象，使用深度优先搜索找出图G与vertex S相邻的所有顶点
    public DFS(Graph G,int s){
        //初始化marked数组
        this.marked = new boolean[G.V()];
        //初始化跟顶点s相通的数量
        this.count = 0;
        dfs(G,s);
    }
    //使用深度优先搜索找出图G中v顶点所有相通的顶点
    private void dfs(Graph G, int v) {
        //1. 标记为已搜索
        marked[v] = true;
        //2. 判断顶点是否被搜索过，如果没有被搜索，则递归调用dfs进行搜索
        for (Integer w : G.adj(v)) {
            if (!marked[w]){
                dfs(G,w);
            }
        }
        //3. 相通数量+1
        count++;
    }
    //判断w顶点是否与s顶点相通
    public boolean marked(int w){
        return marked[w];
    }

    //获取与顶点s相通的所有顶点总数
    public int count(){
        return count;
    }
}
