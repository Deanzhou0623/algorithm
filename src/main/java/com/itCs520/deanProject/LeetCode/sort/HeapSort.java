package com.itCs520.deanProject.LeetCode.sort;

public class HeapSort {
    //less
    private static boolean less(Comparable[] heap,int i,int j){
        return heap[i].compareTo(heap[j])<0;
    }
    //exch
    private static void exch(Comparable[] heap,int i,int j){
        Comparable temp;
        temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    //createHeap
    private static  void createHeap(Comparable[] source,Comparable[] heap){
        //把source中元素拷贝到heap中
        System.arraycopy(source,0,heap,1,source.length);
        //对堆元素做下沉调整
        for (int i = heap.length/2; i >2 ; i--) {
            sink(heap,i,heap.length-1);
        }
    }

    //sort
    public static void sort(Comparable[] source){
        //构建堆
        Comparable[] heap = new Comparable[source.length + 1];
        createHeap(source,heap);
        //定义一个变量，记录未排序元素中的最大索引
        int N= heap.length-1;
        //通过循环，交换1索引处堆元素和最大索引处堆元素
        while (N!=1){
            //交换元素
            exch(heap,1,N);
            //排序交换后最大元素所在索引，让它不要参与堆下沉
            N--;
            //需要对索引1处的元素进行下沉调整
            sink(heap,1,N);
        }
    }
    //sink
    private static void sink(Comparable[] heap,int target,int range){
        while (2*target<=range){
            //1找出当前结点较大的子结点
            int max;
            if (2*target+1<=range){
                if (less(heap,2*target,2*target+1)){
                    max = 2*target+1;
                }else {
                    max = 2*target;
                }
            }else {
                max = 2*target;
            }
                //2比较当前结点的值和较大子结点的值
            if (!less(heap,target,max)){
                break;
            }
            exch(heap,target,max);
            target=max;
        }

    }

}
