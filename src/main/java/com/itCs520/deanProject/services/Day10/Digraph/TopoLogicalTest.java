package com.itCs520.deanProject.services.Day10.Digraph;

import com.itCs520.deanProject.services.Day04.linear.Stack;

public class TopoLogicalTest {
    public static void main(String[] args) {
        //准备有向图
        Digraph d = new Digraph(6);
        d.addEdge(0,2);
        d.addEdge(0,3);
        d.addEdge(2,4);
        d.addEdge(3,4);
        d.addEdge(4,5);
        d.addEdge(1,3);

        //通过topological有向图中的顶点进行排序
        TopoLogical topoLogical = new TopoLogical(d);
        Stack<Integer> order = topoLogical.order();
        StringBuilder sb = new StringBuilder();
        for (Integer w:order){
            sb.append(w+"->");
        }
        String str=sb.toString();
        int index=str.lastIndexOf("->");
        str=str.substring(0,index);
        System.out.println(str);
    }
}
