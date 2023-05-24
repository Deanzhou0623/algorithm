package com.itCs520.deanProject.Basic.Day09.graph;/*
 *ClassName:KruskalMST
 *Description:
 *@Author:deanzhou
 *@Date:2023/4/12 20:18
 */

import com.itCs520.deanProject.Basic.Day04.linear.Queue;
import com.itCs520.deanProject.Basic.Day07.priority.MinpriorityQueue;
import com.itCs520.deanProject.Basic.Day08.uf.UF_tree_Weighted;
import com.itCs520.deanProject.Basic.Day10.Digraph.Edge;
import com.itCs520.deanProject.Basic.Day10.Digraph.EdgeWeightedGraph;



public class KruskalMST {
    //1. 保存最小生成数的所有边
    private Queue<Edge> mst;
    //2. 索引代表顶点，使用uf.connect(v,w)可以判断顶点v和顶点w是否在同一颗树中，使用uf.union(v,w)
        //可以把顶点v和顶点w所在的树合并
    private UF_tree_Weighted uf;
    //3. 保存图中所有的边，使用最小优先队列，对边按照权重进行排序
    private MinpriorityQueue<Edge> pq;

    //4. 根据一副加权无向图，创造最小生成树的计算对象
    public KruskalMST(EdgeWeightedGraph G){
        //1.初始化mst
        this.mst = new Queue<Edge>();
        //2.初始化uf
        this.uf = new UF_tree_Weighted(G.V());
        //3.初始化pq 由于底层是heap实现，heap 废除0索引，因此需要加1 ，但是底层已经加过1
        this.pq = new MinpriorityQueue< >(G.E()+1);
        //4.把图中所有的边存储到pq中
        for (Edge edge : G.edges()) {
            pq.insert(edge);
        }
        //5.遍历队列pq拿到最小权重边
        while (!pq.isEmpty() && mst.size()<G.V()-1){
            //6.找到权重最小边
            Edge e = pq.delMin();
            //7.找到该edge的两个顶点
            int v=e.either();
            int w=e.other(v);
            //8.判断是否在同一棵树中，如果在同一颗树中，则不对该边进行处理，如果不在，则合并
            if (uf.connnected(v,w)){
                continue;
            }
            //9.合并
            uf.union(v,w);
            //让边e进入到mst队列中
            mst.enqueue(e);

        }

    }
    //5. 获取最小生成树的所有边
    public Queue<Edge> edges(){
        return mst;
    }
}
