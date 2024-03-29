package com.itCs520.deanProject.Basic.Day10.Digraph;

import com.itCs520.deanProject.Basic.Day04.linear.Queue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PrimMSTTest {
    public static void main(String[] args) throws IOException {
        //准备一副加权无向图
        BufferedReader br = new BufferedReader(new FileReader("src/min_create_tree_test.txt"));
        int total = Integer.parseInt(br.readLine());
        EdgeWeightedGraph G = new EdgeWeightedGraph(total);

        int edgeNumbers = Integer.parseInt(br.readLine());
        for (int e = 1; e <=edgeNumbers ; e++) {
            String line= br.readLine();
            String[] strs=line.split(" ");

            int v=Integer.parseInt(strs[0]);
            int w=Integer.parseInt(strs[1]);

            double weight=Double.parseDouble(strs[2]);

            //构建加权无向图的边
            Edge edge = new Edge(v, w, weight);
            G.addEdge(edge);

        }
        //创建一个PrimMST对象，计算加权无向图中最小生成树
        PrimMST primMST = new PrimMST(G);
        //获取最小生成树的所有边
        Queue<Edge> edges = primMST.edges();
        //遍历打印所有边
        for (Edge e : edges) {
            int v=e.either();
            int w=e.other(v);
            double weight=e.weight();
            System.out.println(v+" - "+w+" :: "+weight);
        }
    }
}
