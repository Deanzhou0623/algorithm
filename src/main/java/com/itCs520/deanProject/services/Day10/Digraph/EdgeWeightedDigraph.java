package com.itCs520.deanProject.services.Day10.Digraph;

import com.itCs520.deanProject.services.Day04.linear.Queue;

public class EdgeWeightedDigraph {
    //记录顶点数量
    private final int V;
    //记录边的数量
    private int E;
    //邻接表
    private Queue<DirectedEdge>[] adj;

    //创建一个V顶点的空加权有向图
    public EdgeWeightedDigraph(int V){
        //初始化顶点数量
        this.V= V;
        //初始化边数量
        this.E=0;
        //初始化邻接表
        this.adj=new Queue[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i]=new Queue<DirectedEdge>();
        }
    }
    //获取图中顶点的数量
    public int v(){
        return V;
    }
    //获取图中边的数量
    public int E(){
        return E;
    }
    //向加权有向图中添加一条边e
    public void addEdge(DirectedEdge e){
        //e是有方向的只需要让e出现在起点的邻接表中
        int v=e.from();
        adj[v].enqueue(e);
        //边的数量+1
        E++;


    }
    //获取和顶点v关联的所有边
    public Queue<DirectedEdge> adj(int v){
        return adj[v];
    }
    //获取加权有向图的所有边
    public Queue<DirectedEdge> edges(){
        //创建一个队列对象存储所有边
        Queue<DirectedEdge> allEdges = new Queue<>();
        //遍历图中的每一个顶点找到该图中的邻接表,遍历得到每一条边添加到队列即可
        for (int v = 0; v <V ; v++) {
            //遍历v顶点的邻接表，找到每一条和v关联的边
            for (DirectedEdge e: adj(v)){
                allEdges.enqueue(e);
            }
        }
        return allEdges;
    }

}
