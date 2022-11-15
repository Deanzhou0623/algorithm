package com.itCs520.deanProject.services.Day09.graph;

public class BreadthFirstSearchTest {
    public static void main(String[] args) {
        //准备Graph对象
        Graph G = new Graph(13);
        G.addEdge(0,5);
        G.addEdge(0,1);
        G.addEdge(0,2);
        G.addEdge(0,6);
        G.addEdge(5,3);
        G.addEdge(5,4);
        G.addEdge(3,4);
        G.addEdge(4,6);

        G.addEdge(7,8);

        G.addEdge(9,11);
        G.addEdge(9,10);
        G.addEdge(9,12);
        G.addEdge(11,12);

        //准备广度优先搜索对象
        BreadthFirstSearch search = new BreadthFirstSearch(G, 0);
        //测试与某个顶点相通的数量
        int count = search.count();
        System.out.println("相通的数量"+count);
        //测试是否相通
        boolean marked = search.marked(5);
        System.out.println("顶点0是否与顶点5"+marked);

        boolean marked1 = search.marked(7);
        System.out.println("顶点0是否与顶点7"+marked1);
    }
}
