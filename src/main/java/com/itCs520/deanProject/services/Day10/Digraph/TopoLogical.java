package com.itCs520.deanProject.services.Day10.Digraph;

import com.itCs520.deanProject.services.Day04.linear.Stack;

public class TopoLogical {
    //顶点的拓补排序
    private Stack<Integer> order;

    //构建拓补排序对象
    public TopoLogical(Digraph G){
        //创建一个检测有环对象
        DirectedCycle dc = new DirectedCycle(G);
        //判断图G是否有环，如果没环则进行顶点排序，创建一个顶点排序对象
        if (!dc.hasCycle()){
            DepthFirstOrder dfo = new DepthFirstOrder(G);
            order = dfo.reversePost();
        }
    }

    //判断图G是否有环
    private boolean isCycle(){
        return order==null;
    }
    //获取拓补排序的所有顶点
    public Stack<Integer> order(){
        return order;
    }
}
