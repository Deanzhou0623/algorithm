package com.itCs520.deanProject.Basic.Day07.priority;

public class IndexMinPriorityQueue<T extends Comparable<T>> {
    //存储堆中堆元素
    private T[] items;
    //记录堆中元素个数
    private int N;
    //保存每一个元素在items数组中的索引，pq数组需要堆有序
    private int[] pq;
    //保存pq的逆序，pq的值为索引，pq的索引为值
    private int[] qp;


    //构造方法
    public IndexMinPriorityQueue(int capacity){
        this.items=(T[])new Comparable[capacity+1];
        this.pq=new int[capacity+1];
        this.qp=new int[capacity+1];
        this.N=0;

        //默认情况下，队列中没有存储任何数据，让qp中的元素都为-1
        for (int i = 0; i < qp.length; i++) {
            qp[i]=-1;
        }
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
        return items[pq[i]].compareTo(items[pq[j]])<0;
    }

    //交换heap堆中i索引和j索引处的值
    private void exch(int i,int j){
        //交换pq中的数据
        int temp=pq[i];
        pq[i]=pq[j];
        pq[j]= temp;
        //更新qp中的数据、
        qp[pq[i]]=i;
        qp[pq[j]]=j;

    }
    //判断k对应的元素是否存在
    public boolean contains(int k){
        return qp[k] !=-1;
    }

    //最小元素关联索引
    public int mindIndex(){
        return pq[1];
    }

    //往元素队列中插入一个元素
    public void insert(int i,T t){ //往往插入到最后然后使用上浮算法调整
       //判断i是否被关联，如果被关联，则停止插入
        if (contains(i)){
            return;
        }
        //元素个数+1
        N++;
        //把数据存储到items对应的i位置处
        items[i]=t;
        //把i存储到pq中
        pq[N]=i;
        //通过qp来记录pq
        qp[i]=N;
        //通过上浮调整堆顺序
        swim(N);

    }

    //删除队列中的最小元素并返回这个元素
    public int delMin(){
        //获取最小元素关联索引
        int minIndex=pq[1];
        //交换开始索引处的值和最大索引处的值
        exch(1,N);
        //删除qp中对应内容
        qp[pq[N]]= -1;
        //删除pq中最大索引处的内容
        pq[N]=-1;
        //删除items中对应的内容
        items[minIndex]=null;
        //元素个数减1
        N--;
        //使用下沉算法调整位置
        sink(1);
        return minIndex;
    }
    //删除索引i关联的元素
    public void delete(int i){
        //找到i在pq中的索引
        int k=qp[i];
        //交换pq中索引k处的值和索引n处的值
        exch(k,N);
        //删除qp中的内容
        qp[pq[N]] = -1;
        //删除pq中的内容
        pq[N] = -1;
        //删除items中的内容
        items[k]=null;
        //元素个数-1
        N--;
        //堆的调整
        sink(k);
        swim(k);
    }
    //把与索引i关联的元素修改为t
    public void changeItem(int i,T t){
        //修改items数组中i位置的元素为t
        items[i]=t;
        //找到i在pq中出现的位置
        int k=qp[i];
        //堆调整
        sink(k);
        swim(k);
    }

    //使用上浮算法，使索引k出的元素处于一个合适的位置
    private void swim(int k){
        while (k>1){//k到根结点不需要上浮
            if (less(k/2,k)){
                exch(k/2,k);
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
            if (!less(k,min)){
                break;
            }
            exch(k,min);
            k=min;
        }
    }


}
