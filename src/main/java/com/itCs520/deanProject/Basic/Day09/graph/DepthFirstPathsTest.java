package com.itCs520.deanProject.Basic.Day09.graph;

import com.itCs520.deanProject.Basic.Day04.linear.Stack;
import com.itCs520.deanProject.Basic.Day09.graph.DepthFirstPaths;
import com.itCs520.deanProject.Basic.Day09.graph.Graph;
import com.itCs520.deanProject.Basic.Day09.graph.Traffic_Project_Test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DepthFirstPathsTest {
    public static void main(String[] args) throws IOException {
        //构建缓冲读取流
        BufferedReader br = new BufferedReader(new InputStreamReader(Traffic_Project_Test2.class.getClassLoader().getResourceAsStream("road_finds.txt")));
        //读取第一行数据
        int totalNumber = Integer.parseInt(br.readLine());
        //根据第一行数据构建一幅图
        com.itCs520.deanProject.Basic.Day09.graph.Graph g = new Graph(totalNumber);
        //读取第二行数据
        int edgeNumbers = Integer.parseInt(br.readLine());
        //继续通过循环读取每一条边关联的两个顶点，调用addedge方法，添加边
        for (int i = 1; i <=edgeNumbers ; i++) {
            String edge= br.readLine();
            String[] str = edge.split(" ");
            int v=Integer.parseInt(str[0]);
            int w=Integer.parseInt(str[1]);
            g.addEdge(v,w);
        }
        //构建路径查找对象并设置起始点
        com.itCs520.deanProject.Basic.Day09.graph.DepthFirstPaths path = new DepthFirstPaths(  g, 0);
        //调用pathTo，找到从起点0到终点4的路径返回stack
        Stack<Integer> p = path.pathTo(4);
        StringBuilder sb = new StringBuilder();
        //遍历栈对象
        for (Integer v:p) {
            sb.append(v+"-");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
