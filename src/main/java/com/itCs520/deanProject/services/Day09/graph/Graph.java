package com.itCs520.deanProject.services.Day09.graph;


import com.itCs520.deanProject.services.Day04.linear.Queue;

public class Graph {
    //顶点数目
    private final int V;
    //边的数目
    private int E;
    //邻接表
    private Queue<Integer>[] adj;

    public Graph(int v){
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
    //向图中添加一条边
    public void addEdge(int V,int W){
        //在无向图中，边是没有方向的，所以该边即可以说是从v到w的边，也可以说是W到V的边，因此需要让W出现在V的邻接表中，V出现在W的邻接表中
        adj[W].enqueue(V);
        adj[V].enqueue(W);
        //边的数量+1
        E++;

    }
    //获取和顶点V相邻的所有顶点
    public Queue<Integer> adj(int v){
        return adj[v];
    }

}
