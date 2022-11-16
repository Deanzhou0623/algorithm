package com.itCs520.deanProject.services.Day10.Digraph;

import com.itCs520.deanProject.services.Day04.linear.Queue;
import com.itCs520.deanProject.services.Day07.priority.MinpriorityQueue;
import com.itCs520.deanProject.services.Day08.uf.UF_tree_Weighted;

public class KruskalMST {
    //保留最小生成树的所有边
    private Queue<Edge> mst;
    //索引代表顶点,使用uf_connect(v,w)可以判断顶点v和顶点w是否在同一树中 使用uf.union(v,w)可以把顶点v所在的树和顶点w所在的树进行合并
    private UF_tree_Weighted uf;
    //存储图中的所有边，使用最小优先队列，对边按照权重进行排序
    private MinpriorityQueue<Edge> pq;

    //根据一副加权无向图，创造计算最小生成树的计算对象
    public KruskalMST(EdgeWeightedGraph G){
        //初始化mst
        this.mst = new Queue<Edge>();
        //初始化uf
        this.uf = new UF_tree_Weighted(G.v());
        //初始化pq
        this.pq = new MinpriorityQueue<>(G.E()+1); //从1开始存储
        //把图中所有的边存储到pq中
        for (Edge e : G.edges()) {
            pq.insert(e);
        }
        //遍历pq队列，拿到最小权重到边，进行处理
        while (!pq.isEmpty() && mst.size()<G.v()-1){
            //找到权重最小到边
            Edge e = pq.delMin();
            //找到该边到两个顶点
            int v=e.either();
            int w=e.other(v);
            //判断这两个顶点是否在同一颗树中，如果在则不做处理，不在则将这两颗树合成一棵树
            if (uf.connnected(v,w)){
                continue;
            }
            uf.union(v,w);

            //让边e进入到mst队列中
            mst.enqueue(e);
        }
    }
    //获取最小生成树的所有的边
    public Queue<Edge> edges(){
        return mst;
    }
}
