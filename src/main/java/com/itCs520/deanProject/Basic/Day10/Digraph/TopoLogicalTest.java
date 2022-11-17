package com.itCs520.deanProject.Basic.Day10.Digraph;

import com.itCs520.deanProject.Basic.Day04.linear.Stack;
import com.itCs520.deanProject.Basic.Day10.Digraph.Digraph;
import com.itCs520.deanProject.Basic.Day10.Digraph.TopoLogical;

public class TopoLogicalTest {
    public static void main(String[] args) {
        //准备有向图
        com.itCs520.deanProject.Basic.Day10.Digraph.Digraph d = new Digraph(6);
        d.addEdge(0,2);
        d.addEdge(0,3);
        d.addEdge(2,4);
        d.addEdge(3,4);
        d.addEdge(4,5);
        d.addEdge(1,3);

        //通过topological有向图中的顶点进行排序
        com.itCs520.deanProject.Basic.Day10.Digraph.TopoLogical topoLogical = new TopoLogical(d);
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
