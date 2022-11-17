package com.itCs520.deanProject.Basic.Day10.Digraph;

import com.itCs520.deanProject.Basic.Day10.Digraph.Digraph;

public class DirectedCycle {
    //索引代表顶点，值表示当前顶点已经被搜索
    private boolean[] Marked;
    //记录图中是否有环
    private boolean hasCycle;
    //索引代表顶点,使用栈的思想，记录当前顶点有没有已经处于正在搜索的路径上
    private boolean[] onStack;

    //创建一个检测环对象,判断有向图g中是否有环
    public DirectedCycle(com.itCs520.deanProject.Basic.Day10.Digraph.Digraph G){
        //初始化Marked数组
        this.Marked=new boolean[G.V()];
        //初始化hasCycle
        this.hasCycle=false;
        //初始化onStack数组
        this.onStack=new boolean[G.V()];
        //找到图中的每一个顶点，让每一个顶点作为入口，调用一次dfs进行搜索
        for (int v = 0; v <G.V() ; v++) {
            //判断当前顶点还没被搜索过，则调用dfs进行搜索
            if (!Marked[v]){
                dfs(G,v);
            }
        }


    }
    //深度优先搜索找出G图中V顶点的所有想通顶点
    public void dfs(Digraph G, int v){
        //顶点V表示已经搜索过
        Marked[v]=true;
        //当前顶点进栈
        onStack[v]=true;
        //进行深度搜索
        for (Integer w:G.adj(v)) {
            //判断当前顶点w没有被搜索过，则继续递归调用dfs完成深度优先搜索
            if (!Marked[w]){
                dfs(G,w);
            }
            //判断当前顶点是否已经在栈中，则证明当前顶点之前属于搜索状态，那么需要进行搜索一次，检测到有环
            if (onStack[w]){
                hasCycle=true;
                return;
            }
        }
        //当前顶点出栈，给一个顶点进行dfs使用
        onStack[v]=false;

    }
    //判断有向图G中是否有环
    public boolean hasCycle(){
        return hasCycle;
    }

}
