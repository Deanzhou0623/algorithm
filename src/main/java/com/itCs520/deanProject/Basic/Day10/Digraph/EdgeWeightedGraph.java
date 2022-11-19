package com.itCs520.deanProject.Basic.Day10.Digraph;

import com.itCs520.deanProject.Basic.Day04.linear.Queue;
import com.itCs520.deanProject.Basic.Day10.Digraph.Edge;

public class EdgeWeightedGraph {
    //记录顶点数量
    private final int V;
    //记录边的数量
    private int E;
    //邻接表
    private Queue<com.itCs520.deanProject.Basic.Day10.Digraph.Edge>[] adj;

    //创建一个V顶点的空加权无向图
    public EdgeWeightedGraph(int V){
        //初始化顶点数量
        this.V= V;
        //初始化边数量
        this.E=0;
        //初始化邻接表
        this.adj=new Queue[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i]=new Queue<com.itCs520.deanProject.Basic.Day10.Digraph.Edge>();
        }
    }
    //获取图中顶点的数量
    public int V(){
        return V;
    }
    //获取图中边的数量
    public int E(){
        return E;
    }
    //向加权无向图中添加一条边e
    public void addEdge(com.itCs520.deanProject.Basic.Day10.Digraph.Edge e){
        //需要让e同时出现在e这个边的两个顶点的邻姐接表中
        int v = e.either();
        int w = e.other(v);

        adj[v].enqueue(e);
        adj[w].enqueue(e);

        //边的数量+1
        E++;


    }
    //获取和顶点v关联的所有边
    public Queue<com.itCs520.deanProject.Basic.Day10.Digraph.Edge> adj(int v){
        return adj[v];
    }
    //获取加权无向图的所有边
    public Queue<com.itCs520.deanProject.Basic.Day10.Digraph.Edge> edges(){
        //创建一个队列对象存储所有边
        Queue<com.itCs520.deanProject.Basic.Day10.Digraph.Edge> allEdges = new Queue<>();
        //遍历图中的每一个顶点找到该图中的邻接表,邻接表中存储了关联这个顶点的每一条边
        //因为这是无向图，所有同一条边出现了它关联的两个顶点邻接表中，需要让一条边只记录一次
        for (int v = 0; v <V ; v++) {
            //遍历v顶点的邻接表，找到每一条和v关联的边
            for (Edge e: adj(v)){
                if (e.other(v)<v){
                    allEdges.enqueue(e);
                }
            }
        }
        return allEdges;
    }

}
