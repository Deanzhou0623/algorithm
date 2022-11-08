package com.itCs520.deanProject.services.Day08.uf;

public class UF_tree {
    //记录结点元素和该元素所在标识
    private int[] eleAndGroup;
    //记录并查集中数据的分组个数
    private int count;
    //初始化并查集
    public UF_tree(int N){
         //初始化分组数量，默认情况下有N个分组
        this.count=N;
        //初始化eleAndGroup数组
        this.eleAndGroup = new int[N];
        //初始化elementAndGroup中的元素及其所在的标识符，让eleAndGroup数组的索引作为并查集的每个结点的元素，并且让每个索引处的值就是该索引
        for (int i = 0; i < eleAndGroup.length; i++) {
            eleAndGroup[i] = i;
        }

    }
    //获取当前并查集中的数据有多少个分组
    public int count(){
        return count;
    }
    //元素p所在分组的标识符
    public int find(int p){
        while (true){
            if (p== eleAndGroup[p]){
                return p;
            }
            p = eleAndGroup[p];
        }
    }
    //判断并查集中元素p和q是否在同一组中
    public boolean connnected(int p,int q){
        return find(p) == find(q);
    }
    //把p元素的分组和q元素的分组合并
    public void union(int p,int q){
        //找到p所在分组标识符
        int pRoot=find(p);
        //找到q所在标识符
        int qRoot=find(q);
        //判断元素p和q是否在同一组中
        if (pRoot==qRoot){
            return ;
        }
        //让p所在结点的根结点的父结点为q所在树的根结点即可
        eleAndGroup[pRoot]=qRoot;
        //分组个数减-1
        this.count--;
    }
}
