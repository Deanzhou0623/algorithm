package com.itCs520.deanProject.Basic.Day10.Digraph;

public class Edge implements Comparable<Edge>{
    //顶点一
    private final int v;
    //顶点二
    private final int w;
    //当前边的权重值
    private final double weight;

    //构造器
    public Edge(int v,int w,double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    //获取边的权重值
    public double weight(){
        return weight;
    }

    //获取边上的一个点
    public int either(){
        return v;
    }
    //获取除了vertex外的另一个顶点
    public int other(int vertex){
        if (vertex == v){
            return w;
        }else {
            return v;
        }
    }
    @Override
    public int compareTo(Edge that) {
        //使用一个变量比较结果
        int cmp;
        if (this.weight()>that.weight()){
            //当前权重大，返回1
            cmp=1;
        } else if (this.weight()<that.weight()) {
            // 当前权重小，返回-1
            cmp=-1;
        }else {
            //当前权重一样大，返回0
            cmp=0;
        }
        return cmp;
    }
}
