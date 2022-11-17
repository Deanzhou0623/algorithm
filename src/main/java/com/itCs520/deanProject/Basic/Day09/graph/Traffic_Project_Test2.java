package com.itCs520.deanProject.Basic.Day09.graph;

import com.itCs520.deanProject.Basic.Day09.graph.DepthFirstSearch;
import com.itCs520.deanProject.Basic.Day09.graph.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Traffic_Project_Test2 {
    public static void main(String[] args) throws IOException {
        //构建缓冲读取流
        BufferedReader br = new BufferedReader(new InputStreamReader(Traffic_Project_Test2.class.getClassLoader().getResourceAsStream("traffic_project.txt")));
        //读取第一行数据20
        int totalNumber = Integer.parseInt(br.readLine());
        //构建一个graph对象
        com.itCs520.deanProject.Basic.Day09.graph.Graph graph = new Graph(totalNumber);
        //读取第二行数据7
        int roadNumber = Integer.parseInt(br.readLine());
        //循环读取有限次数，读取已经修建好的道路
        for (int i = 0; i < roadNumber; i++) {
            String road = br.readLine();
            String[] s = road.split(" ");
            int v = Integer.parseInt(s[0]);
            int w = Integer.parseInt(s[1]);
            //调用addedge方法把边添加进图中
            graph.addEdge(v,w);

        }
        //构建深度优先搜索对象吗，起点为9
        com.itCs520.deanProject.Basic.Day09.graph.DepthFirstSearch search = new DepthFirstSearch(graph,9);
        //调用marked方法判断8顶点是否和10顶点与9顶点相通
        System.out.println("是否相通"+search.marked(8));
        System.out.println("是否相通"+search.marked(10));


    }
}
