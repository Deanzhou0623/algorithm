package com.itCs520.deanProject.Basic.Day09.graph;

public class DepthFirstSearch2 {
    //索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean[] marked;
    //记录多少个顶点被搜索
    private int count;

    //构建深度优先搜索对象，使用深度优先搜索找出G图中V顶点的所有想通顶点
    public DepthFirstSearch2(Graph G, int s){
        //初始化marked数组
        this.marked =new boolean[G.V()];
        //初始化跟顶点s相同的顶点
        this.count =0;
        dfs(G,s);

    }
    //深度优先搜索找出G图中V顶点的所有相通顶点
    private void dfs(Graph G, int v){
        //v顶点标识为已搜索
        marked[v] =true;
        //遍历v的所有想通的顶点，如果没有被搜索过则调用dfs
        for (Integer w:G.adj(v)) {
            if (!marked[w]){
                dfs(G,w);
            }
        }
        //相通数量+1
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
