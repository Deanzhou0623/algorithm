package com.itCs520.deanProject.Basic.Day06.heap;

public class HeapSort3 {
    //判断heap堆中索引i处堆元素是否会小于索引j处的值
    private static boolean less(Comparable[] heap,int i,int j){
        return heap[i].compareTo(heap[j])<0;
    }
    //交换heap堆中i索引处堆值和j索引处堆值
    public static void exch(Comparable[] heap,int i,int j){
        Comparable temp=heap[i];
        heap[i] = heap[j];
        heap[j] = temp;

    }
    //根据原数组构造出堆heap
    private static void createHeap(Comparable[] source,Comparable[] heap){
        //把source中的元素拷贝到heap中，heap中的元素形成一个无序堆
        System.arraycopy(source,0,heap,1,source.length);
        //对堆中堆元素做下沉调整（从长度一半开始扫描）
        for (int i = heap.length/2; i > 0; i--) {
            sink(heap,i, heap.length-1);
        }

    }
    //对source数组从小到大进行排序
    public static void sort(Comparable[] source){
        //1. 构建堆
        Comparable[] heap = new Comparable[source.length + 1];
        createHeap(source,heap);
        //2. 定义一个变量，记录未排序中元素最大的索引
        int N= heap.length-1;
        //通过循环，交换1处的索引的元素和元素中最大索引处的元素
        while (N!=1){
            //交换元素
            exch(heap,1,N);
            //排序交换后最大元素所在索引，让它不要参与堆的下沉调整
            N--;
            //需要对索引1处的元素进行下沉调整
            sink(heap,1,N);
        }
        //3. 把heap中的数据复制到source中
        System.arraycopy(heap,1,source,0,source.length);
    }
    //在heap堆中，对target元素做下沉，范围是0-range
    private static void sink(Comparable[] heap,int target,int range){
        while (2*target <=range){
            //1. 找出较大的子结点值
            int max;
            if (target*2+1 <=range){
                if (less(heap,2*target,2*target+1)){
                    max =2*target+1;
                }else {
                    max =2*target;
                }

            }else {
                max = 2*target;

            }
            //2.比较当前结点的值和较大结点的值
            if (!less(heap,target,max)){
                break;
            }
            exch(heap,target,max);
            target = max;
        }
    }
}
