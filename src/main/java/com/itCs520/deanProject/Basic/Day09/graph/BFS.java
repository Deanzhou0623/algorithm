package com.itCs520.deanProject.Basic.Day09.graph;

import com.itCs520.deanProject.Basic.Day04.linear.Queue;

public class BFS {
    //索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean[] marked;
    //记录多少个顶点被搜索
    private int count;
    //用来存储待搜索邻接表的点
    private Queue<Integer> waitSearch;

    //构建广度优先搜索对象，使用深度优先搜索找出G图中V顶点的所有想通顶点
    public BFS(Graph G, int s){
        //初始化marked 数组
        this.marked=new boolean[G.V()];
        //初始化顶点
        this.count=0;
        //初始化存储待搜索邻接表的队列
        this.waitSearch = new Queue<Integer>();

        bfs(G,s);
    }
    //广度优先搜索找出G图中V顶点的所有相通顶点
    private void bfs(Graph G, int v){
        //v顶点标识为已搜索
        marked[v] = true;
        //顶点v进入队列，待搜索
         waitSearch.enqueue(v);

        //通过循环,如果队列不为空则弹出顶点进行搜索
        while (!waitSearch.isEmpty()) {
            //弹出一个待搜索的顶点
            Integer wait= waitSearch.dequeue();
            //通过循环遍历wait顶点邻接表
            for (Integer w : G.adj(wait)) {
                //判断当前w顶点没有被搜索过，如果没有被搜索，则递归调用bfs方法进行广度搜索
                if (!marked[w]){
                    bfs(G,w);
                }
            }
        }
        //相同顶点+1
        count++;
    }

    //判断w顶点与s顶点是否想通
    public boolean marked(int w){
        //是否搜索过，如果搜索过则代表相通
        return marked[w];
    }
    //获取与顶点s相通的所有顶点总数
    public int count(){
        return count;
    }
}
