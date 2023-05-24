package com.itCs520.deanProject.Basic.Day08.uf;/*
 *ClassName:UF2
 *Description:
 *@Author:deanzhou
 *@Date:2023/4/12 15:30
 */

public class UF2 {
    //1. 记录节点元素和该元素所在分组标识
    private int[] eleAndGroup;
    //2. 记录并查集中数据分组的个数
    private int count;
    //3. 初始化并查集
    public UF2(int N){
       this.count =N;
       this.eleAndGroup =new int[N];
        for (int i = 0; i < eleAndGroup.length; i++) {
            eleAndGroup[i] = i;
        }
    }
    //4. 获取当前并查集中有多少个分组
    public int count(){
        return count;
    }
    //5. 元素p所在分组标识符
    public int find(int p){
        return eleAndGroup[p];
    }
    //6.判断p和q是否在同一分组中
    public boolean connected(int p,int q){
        return find(p) ==find(q);
    }
    //7. p元素所在分组与q元素所在分组合并
    public void union(int p,int q){
        //判断元素p和元素q是否在同一个分组中,如果在则直接结束方法
        if (connected(p,q)){
            return;
        }
        //找到p所在分组
        int pGroup = find(p);
        //找到q所在分组
        int qGroup = find(q);
        //合并组：让p所在组的所有元素的组标识符变为q所在分组的标识符
        for (int i = 0; i < eleAndGroup.length; i++) {
            if (eleAndGroup[i] == pGroup){
                eleAndGroup[i] =qGroup;
            }
        }
        //分组个数-1
        this.count--;
    }

}
