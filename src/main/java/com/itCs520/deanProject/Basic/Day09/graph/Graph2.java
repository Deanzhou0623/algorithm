package com.itCs520.deanProject.Basic.Day09.graph;/*
 *ClassName:Graph2
 *Description:
 *@Author:deanzhou
 *@Date:2023/4/13 20:04
 */

import com.itCs520.deanProject.Basic.Day04.linear.Queue;

public class Graph2 {
    //1. 顶点数量
    private final int V;
    //2. 边的个数
    private int E;
    //3. 邻接表
    private Queue<Integer>[] adj;

    public Graph2(int V){
    this.V =V;
    this.E =0;
    this.adj =new Queue[V];

        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<Integer>();
        }
    }
    //获取顶点数目
    public int V(){
        return V;
    }

    public int E() {
        return E;
    }

    //向图中添加一条边
    public void addEdge(int v,int w){
        adj[v].enqueue(w);
        adj[w].enqueue(v);
        //边的数量+1
        E++;
    }
    //获取和顶点v相邻的所有顶点
    public Queue<Integer> adj(int v){
        return adj[v];
    }

}
