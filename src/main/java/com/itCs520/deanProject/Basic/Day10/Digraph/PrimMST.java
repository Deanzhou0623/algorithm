package com.itCs520.deanProject.Basic.Day10.Digraph;

import com.itCs520.deanProject.Basic.Day04.linear.Queue;
import com.itCs520.deanProject.Basic.Day07.priority.IndexMinPriorityQueue;
import com.itCs520.deanProject.Basic.Day10.Digraph.Edge;
import com.itCs520.deanProject.Basic.Day10.Digraph.EdgeWeightedGraph;

public class PrimMST {
    //索引代表顶点，值表示当前顶点和最小生成树之间的最短边
    private com.itCs520.deanProject.Basic.Day10.Digraph.Edge[] edgeTo;
    //索引代表顶点，值表示当前顶点和最小生成树之间的最短边的权重
    private double[] distTo;
    //索引代表顶点，如果当顶点已经在树中，则值为true ，否为false
    private boolean[] marked;
    //存放树中的顶点与非树中顶点之间的有效横切边
    private IndexMinPriorityQueue<Double> pq;

    //根据一副加权无向图，创建最小生成树对象
    public PrimMST(EdgeWeightedGraph G){
        //初始化edgeTo
        this.edgeTo=new com.itCs520.deanProject.Basic.Day10.Digraph.Edge[G.v()];
        //初始化distTo
        this.distTo=new double[G.v()];
        for (int i = 0; i < distTo.length ; i++) {
            distTo[i]=Double.NEGATIVE_INFINITY;
        }
        //初始化marked
        this.marked=new boolean[G.v()];
        //初始化pq
        pq = new IndexMinPriorityQueue<Double>(G.v());
        //默认让顶点0进入树中，但是树中只有一个顶点，因此0顶点默认没有和其他顶点相连，所以让distTo默认存储0.0
        distTo[0] = 0.0;
        pq.insert(0,0.0);

        //遍历索引最小优先队列拿到最小和N切变对应的点，把该顶点加入到最小生成树中
        while (!pq.isEmpty()){
            visit(G,pq.delMin());
        }
    }

    //将顶点v添加到最小生成树中，并且更新数据
    public void visit(EdgeWeightedGraph G,int v){
        //把顶点V添加到最小生成树中
        marked[v] = true;
        //更新数据
        for (com.itCs520.deanProject.Basic.Day10.Digraph.Edge e : G.adj(v)) {
            //获取e边的另一个顶点
            int w=e.other(v);
            //判断另一个顶点是不是已经在树中，如果在树中，则不做任何处理，如果不在树中，则不做任何处理
            if (marked[w]){
                continue;
            }
            //判断边e的权重是否小于从w顶点到树中已经存在最小边的权重
            if (e.weight()<distTo[w]){
                //更新数据
                edgeTo[w] = e;
                distTo[w] = e.weight();

                if (pq.contains(w)){
                    pq.changeItem(w, e.weight());
                }else {
                    pq.insert(w, e.weight());
                }
            }
        }
    }
    //获取最小生成树的所有的边
    public Queue<com.itCs520.deanProject.Basic.Day10.Digraph.Edge> edges(){
        //创建队列对象
        Queue<Edge> AllEdges = new Queue<>();
        //遍历edgoTo，拿到每一条边，如果不为null则添加到树中
        for (int i = 0; i <edgeTo.length ; i++) {
            if (edgeTo[i]!=null){
                AllEdges.enqueue(edgeTo[i]);
            }
        }
        return AllEdges;
    }
}
