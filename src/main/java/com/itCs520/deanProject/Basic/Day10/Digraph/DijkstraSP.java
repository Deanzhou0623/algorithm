package com.itCs520.deanProject.Basic.Day10.Digraph;


import com.itCs520.deanProject.Basic.Day04.linear.Queue;
import com.itCs520.deanProject.Basic.Day07.priority.IndexMinPriorityQueue;

public class DijkstraSP {
    //索引代表顶点，值表示从顶点s到当前顶点的最短路径上的最后一条边
    private DirectedEdge[] edgeTo;
    //索引代表顶点，值从顶点s到当前顶点的最短路径的总权重
    private double[] distTo;
    //存储树中顶点与非树中顶点之间的有效横切边
    private IndexMinPriorityQueue<Double> pq;

    //根据一副加权有向图和顶点s，创建一个计算顶点s的最短路径树的对象
    public DijkstraSP(EdgeWeightedDigraph G, int s){
        //初始化edgeTo
        this.edgeTo = new DirectedEdge[G.V()];
        //初始化distTo
        this.distTo = new double[G.V()];
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Double.NEGATIVE_INFINITY;
        }
        //初始化pq
        this.pq = new IndexMinPriorityQueue<>(G.V());

        //找到图G中以顶点s为起点对最短路径树
        distTo[s]=0.0;
        pq.insert(s,0.0);

        //遍历pq
        while (!pq.isEmpty()){
            relax(G,pq.delMin());
        }

    }

    //松弛G中对顶点V
    public void relax(EdgeWeightedDigraph G,int v){
        for (DirectedEdge edge : G.adj(v)) {
            //获取到该边到终点w
            int w = edge.to();

            //通过松弛技术，判断从起点s到顶点w的最短路径是否需要先从顶点s到顶点v，再到顶点w
            if (distTo(v)+edge.weight()<distTo(w)){
                distTo[w]=distTo[v]+edge.weight();
                edgeTo[w]=edge;

                //判断pq中是否已经存在顶点w如果存在则更新权重，如果不存在则直接添加
                if (pq.contains(w)){
                    pq.changeItem(w,distTo(w));
                }else {
                    pq.insert(w,distTo(w));
                }
            }
        }
    }
    //获取从顶点s到顶点v的最短路径的总权重
    public double distTo(int v){
        return distTo[v];
    }
    //判断从顶点s到顶点v是否可达
    public boolean hashPathTo(int v){
        return distTo[v]<Double.NEGATIVE_INFINITY;
    }
    //查询从起点s到到顶点v的最短路径所有的边
    public Queue<DirectedEdge> pathTo(int v){
        //判断从起点s到到顶点v是否可达
        if (!hashPathTo(v)){
            return null;
        }
        //创建队列对象
        Queue<DirectedEdge> allEdges = new Queue<>();
        while (true){
            DirectedEdge e=edgeTo[v];
            if (e==null){
                break;
            }
            allEdges.enqueue(e);
        }
        return allEdges;
    }
}
