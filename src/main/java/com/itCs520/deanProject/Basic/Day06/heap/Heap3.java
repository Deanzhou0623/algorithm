package com.itCs520.deanProject.Basic.Day06.heap;

public class Heap3<T extends Comparable <T>>{
    //存储堆中堆元素
    private T[] items;
    //记录堆中元素个数
    private int N;

    public Heap3(int capacity){
        this.items = (T[])new Object[capacity+1];
        this.N = 0;
    }

    //判断索引i处的元素是否小于索引j处的元素
    private boolean less(int i,int j){
      return items[i].compareTo(items[j])<0;
    }

    //交换元素i和j处索引值
    private void exch(int i,int j){
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;

    }
    //往堆中插入一个元素
    public void insert(T t){
        items[++N] = t;
        swim(N);
    }
    //用上浮算法，使索引K处的元素能在堆中处于一个正确的位置
    private void swim(int k){
        //通过循环，不断比较当前结点的值和其父节点的值，如果发现父结点的值比当前结点的小，则交换位置
        while (k>1){
            if (less(k/2,k)){ //k/2为父节点 ， k为子结点
                exch(k/2,k);
            }
            //往上走一层 走到当前父节点位置
            k = k/2;
        }
    }


    //删除堆排序中最大的元素，并返回最大元素
    public T delMax(){
        T max = items[1];
        //交换索引1处的元素和最大索引处的元素，让完全二叉树最右侧的结点变为临时根结点
        exch(1,N);
        //最大索引处的元素删除
        items[N] =null;
        //元素个数-1
        N--;
        //通过下沉调整堆，让堆重新有序
        sink(1);

      return max;
    }

    //使用下层算法，使索引k处的元素能够在堆中处于正确的位置
    public void sink(int k){
        //通过循环不断的对比当前k结点和其左子节点2k和右子结点2k+1处中的较大值的元素大小，如果当前结点小，则需要交换位置
        while (2*k<=N){
            //获取当前子节点中的较大结点
            int max; // 记录较大结点所在的索引
            if (2*k+1 <=N){
                if (less(2*k,2*k+1)){
                    max = 2*k+1;
                }else {
                    max = 2*k;
                }

            }else {
                max = 2*k;
            }
            //比较当前结点和较大结点的值
            if (!less(k,max)){
                break;
            }
            //交换位置
            exch(k,max);
            //交换r的值
            k = max;
        }
    }

}
