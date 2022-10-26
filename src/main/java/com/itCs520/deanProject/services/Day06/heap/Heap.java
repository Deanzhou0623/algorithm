package com.itCs520.deanProject.services.Day06.heap;

public class Heap <T extends Comparable <T>>{
    //存储堆中堆元素
    private T[] items;
    //记录堆中元素个数
    private int N;

    public Heap(int capacity){
        this.items =(T[])new Comparable[capacity+1];
        this.N=0;
    }

    //判断索引i处的元素是否小于索引j处的元素
    private boolean less(int i,int j){
        return items[i].compareTo(items[j])<0;
    }

    //交换元素i和j处索引值
    private void exch(int i,int j){
        T temp = items[i];
        items[i] = items [j];
        items[j] = temp;
    }
    //往堆中插入一个元素
    public void insert(T t){
        items[++N]=t;
        swim(N);
    }
    //用上浮算法，使索引K处的元素能在堆中处于一个正确的位置
    private void swim(int k){
        //通过循环，不断比较当前结点的值和父结点的值，如果发现父结点的值比当前结点值小，则交换位置
        while (k>1){
            //比较当前结点和父结点
            if (less(k/2,k)){
                exch(k/2,k);
            }
            k=k/2;
        }

    }


    //删除堆排序中最大的元素，并返回最大元素
    public T delMax(){
        T max = items[1];

        //交换索引1处的值和最大索引处的值,让完全二叉树的最右侧结点变为临时结点
        exch(1,N);
        //最大索引元素删除
        items[N]=null;
        //元素个数减一
        N--;
        //通过下衬调整堆，让堆重新有序
        sink(1);
        return max;
    }

    //使用下层算法，使索引k处的元素能够在堆中处于正确的位置
    public void sink(int k){
        //通过循环不断对比当前k结点和其左子结点2*K以及右子结点2K+1处中的较大值的元素大小，如果当前结点小，则交换位置
        while (2*k<N){ //保证有左子结点 左子结点索引大于最大索引
            //获取当前结点子结点中较大的值
            int max;//记录较大结点所在索引
            if(2*k+1<=N){
                if(less(2*k,2*k+1)){
                    max=2*k+1;
                }else {
                    max=2*k;
                }
            }else {
                max = 2*k;
            }

            //比较当前结点和较大结点的值
            if (!less(k,max)){
                break;
            }
            //交换k处的索引值和max索引处的值
            exch(k,max);
            //变换k的值,为下一次循环左做准备
            k=max;
        }

    }

}
