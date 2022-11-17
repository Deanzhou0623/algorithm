package com.itCs520.deanProject.Basic.Day10.Digraph;

import com.itCs520.deanProject.Basic.Day04.linear.Queue;

public class Digraph {
    //顶点数目
    private final int V;
    //边的数目
    private int E;
    //邻接表
    private Queue<Integer>[] adj;

    //构造器
    public Digraph(int v){
        //初始化顶点
        this.V=v;
        //初始化边
        this.E=0;
        //初始化邻接表
        this.adj=new Queue[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i]=new Queue<Integer>();
        }
    }
    //获取顶点数量
    public int V(){
        return V;
    }
    //获取边的数目
    public int E(){
        return E;
    }
    //向有向图中添加一条边V -> W
    public void addEdge(int V,int W){
        //只需要让顶点w出现在v的邻接表中，因为这是有方向的，最终，顶点v的邻接表中存储的相邻的含有是v->其他顶点
        adj[V].enqueue(W);
        //边的数量+1
        E++;

    }
    //获取由顶点V指出的边所连接的所有顶点
    public Queue<Integer> adj(int v){
        return adj[v];
    }

    //该图的反向图
    private Digraph reverse(){
        //组建有向图对象
        Digraph r = new Digraph(V);

        for (int v = 0; v < V; v++) {
            //获取该顶点V指出的所有边
            for (Integer w: adj(v)) {//原图中表示 v - > W
                addEdge(w,v);//反向添加 w->v
            }
        }
        return r;
    }

}
