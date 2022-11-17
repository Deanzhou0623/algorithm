package com.itCs520.deanProject.Basic.Day04.linear;

import java.util.Iterator;

public class SequenceList<T> implements Iterable<T> {
    //存储元素的数组
    private T[] eles;
    //记录当前顺序表中的元素个数
    private int N;
    //构造方法
    public SequenceList(int capacity){
        //初始化数组
        this.eles=(T[]) new Object[capacity];
        //初始化长度
        this.N = 0;
    }

    //将线性表置为空表
    public void clear(){
        this.N=0;
    }

    //判断线性表是否为空表
    public boolean isEmpty(){
        return N==0;
    }

    //获取线性表数组长度
    public int length(){
        return N;
    }

    //指定位置的值
    public T get(int i){
        return eles[i];
    }

    //向线性表中添加元素T
    public void insert(T t){
        eles[N++] = t;
    }

    //在i元素插入元素t
    public void insert(int i,T t){
        if (N == eles.length){
            resize(eles.length*2);
        }
        //先把i元素及其后面的元素依次向后移一位
        for (int index = N; index >i; index--) {
            eles[index] = eles[index-1];
        }
        //再把t元素放到i索引即可
        eles[i] = t;
        //元素个数
        N++;
    }

    //删除指定位置的元素i，并返回该元素
    public T remove(int i){
        //记录索引i出的值
        T current = eles[i];
        //索引i后面的值依次向前移动
        for (int index = i; index < N-1; index++) {
            eles[index] = eles[index+1];
        }
        //元素个数减少
        N--;
        //缩容
        if (N<eles.length/4){
            resize(eles.length/2);
        }
        return current;
    }

    //查找t元素第一次出现的位置
    public int indexOf(T t){
        for (int i = 0; i < N; i++) {
            if (eles[i].equals(t)){
                return i;
            }
        }
        return -1;
    }

    //根据参数newSize，重制eles大小
    public void resize(int newSize){
        //定义一个临时数组，指向原数组
        T[] temp=eles;
        // 创建新数组
        eles=(T[])new Object[newSize];
        //把原数组的数据拷贝到新数组即可
        for (int i = 0; i < N; i++) {
            eles[i]=temp[i];
        }
    }
    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator{
        private int cusor;
        public SIterator(){
            this.cusor  =0;
        }
    @Override
        public boolean hasNext() {
            return cusor<N;
        }

        @Override
        public Object next() {
            return eles[cusor++];
        }

        @Override
        public void remove() {
        }
    }
}
