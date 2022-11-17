package com.itCs520.deanProject.Basic.Day10.Digraph;

import com.itCs520.deanProject.Basic.Day04.linear.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DijkstraSPTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(DijkstraSPTest.class.getClassLoader().getResourceAsStream("min_route_test.txt")));
        int total = Integer.parseInt(br.readLine());
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(total);

        int edgeNumbers = Integer.parseInt(br.readLine());
        for (int i = 1; i <=edgeNumbers ; i++) {
            String line= br.readLine();
            String[] strs=line.split(" ");

            int v=Integer.parseInt(strs[0]);
            int w=Integer.parseInt(strs[1]);

            double weight=Double.parseDouble(strs[2]);

            //构建有向图的边
            DirectedEdge e = new DirectedEdge(v, w, weight);
            G.addEdge(e);
        }
        //创建DijkstraSP对象，查找最短路径树
        DijkstraSP dijkstraSP = new DijkstraSP(G, 0);
        //查找最短路径，0->6的最短路径
        Queue<DirectedEdge> edges = dijkstraSP.pathTo(6);

        //遍历打印
        for (DirectedEdge e : edges) {
            System.out.println(e.from()+"->"+e.to()+": :"+e.weight());
        }

    }
}
