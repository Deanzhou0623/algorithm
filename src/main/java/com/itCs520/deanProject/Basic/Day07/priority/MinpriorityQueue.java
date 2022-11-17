package com.itCs520.deanProject.Basic.Day07.priority;

public class MinpriorityQueue<T extends Comparable<T>> {
    //存储堆中堆元素
    private T[] items;
    //记录堆中元素个数
    private int N;
    //构造方法
    public MinpriorityQueue(int capacity){
        this.items=(T[])new Comparable[capacity+1];
        this.N=0;
    }

    //获取队列中的个数
    public int size(){
        return N;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return N==0;
    }

    //判断索引i处堆元素是否小于索引j出堆元素
    private boolean less(int i,int j){
        return items[i].compareTo(items[j])<0;
    }

    //交换heap堆中i索引和j索引处的值
    private void exch(int i,int j){
        T temp=items[i];
        items[i]=items[j];
        items[j]=temp;
    }

    //往元素队列中插入一个元素
    public void insert(T t){ //往往插入到最后然后使用上浮算法调整
        items[++N]=t;
        swim(N);
    }

    //删除队列中的最小元素并返回这个元素
    public T delMin(){
        //找到该元素所在位置
        T min=items[1];
        //交换开始索引处的值和最大索引处的值
        exch(1,N);
        //删除最大索引处的值
        N--;
        //使用下沉算法调整位置
        sink(1);
        return min;
    }

    //使用上浮算法，使索引k出的元素处于一个合适的位置
    private void swim(int k){
        while (k>1){//k到根结点不需要上浮
            if (less(k,k/2)){
                exch(k,k/2);
            }
            k=k/2;
        }
    }

    //使用下浮算法，使索引k出的元素处于一个合适的位置
    private void sink(int k){
        while (2*k<N){
            int min;
            if (2*k+1<=N){
                if (less(2*k,2*k+1)){
                    min=2*k;
                }else {
                    min=2*k+1;
                }
            }else {
                min=2*k;
            }
            if (less(k,min)){
                break;
            }
            exch(k,min);
            k=min;
        }
    }


}
