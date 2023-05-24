package com.itCs520.deanProject.Basic.Day06.heap;/*
 *ClassName:Heap4
 *Description:
 *@Author:deanzhou
 *@Date:2023/4/14 16:47
 */

public class Heap4<T extends Comparable<T>> {
    //存储堆中的元素
    private T[] items;
    //记录堆的个数
    private int N;

    public Heap4(int capacity){
        this.items = (T[])new Object[capacity];
        this.N=0;
    }
    //判断堆中i索引处堆元素，是否小于j索引处堆元素
    private boolean less(int i,int j){
        return items[i].compareTo(items[j])<0;
    }
    //交换元素i和j处索引值
    private void exch(int i,int j){
        T temp=items[i];
        items[i] = items[j];
        items[j] = temp;
    }
    //往堆中插入一个元素
    public void insert(T t){
        items[++N] =t;
        swim(N);
    }

    //用上浮算法，使索引K处的元素能在堆中处于一个正确的位置
    private void swim(int k){
        //通过循环，不断比较当前节点的值和其父节点的值，如果发现父节点的值比当前节点的小，则交换位置
        while (k>1){
            //比较当前节点的值和父节点的值
            if (less(k/2,k)){
                exch(k/2,k);
            }
            k =k/2;
        }
    }
    //删除堆排序中最大的元素，并返回最大元素
    public T delMax(){
        T max= items[1];
        exch(1,N);
        items[N] =null;
        N--;
        sink(1);
        return max;
    }

    //使用下层算法，使索引k处的元素能够在堆中处于正确的位置
    private void sink(int k) {
        //1. 通过循环不断对比当前节点和其左子节点2k和呦子节点2k+1中元素较大值的 大小，如果如果小则交换位置
        while (2*k>N){
            int max;
            if (2*k+1<N){
                if (less(2*k,2*k+1)){
                    max = 2*k+1;
                }else {
                    max =2*k;
                }
            }else {
                max =2*k;
            }
            //如果比当前节点较大
            if (!less(k,max)){
                break;
            }
            //交换k索引处的值和max索引处的值
            exch(k,max);
            k = max;
        }
    }

}
