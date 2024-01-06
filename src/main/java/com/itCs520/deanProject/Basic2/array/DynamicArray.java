package com.itCs520.deanProject.Basic2.array;/*
 *ClassName:DynamicArray
 *Description:
 *@Author:deanzhou
 *@Date:2023/6/12 21:57
 */

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/*
* 头部插入： time:O(n)
* 中部位置： time:O(n)
* 尾部位置： time:O(1)
* */
public class DynamicArray implements Iterable<Integer> {
    /*三个属性
    * */
    private int size=0; // 逻辑大小
    private int capacity = 8; //容量大小
    private int[] array = {};

    //添加元素到最后一个位置
    public void addLast(int element){
        add(size,element);
    }
    //添加元素d到指定位置
    public void add(int index,int element){
        //1. check array
         ArrayExpansion();
        //2. 校验数据的合法性
        if (index >= 0 && index< size) {
            //3. 复制数组进行 -> 移位
            System.arraycopy(array,index,array,index+1,size-index);
        }
        //4. 添加元素
        array[index] = element;
        size++;
    }

    private void ArrayExpansion() {
        if (size ==0){
            array = new int[capacity];

        } else if(size == capacity){
            //进行扩容   size * 1.5
            capacity += capacity>>1;
            int[] newArray = new int[capacity];
            //复制数组
            System.arraycopy(array,0,newArray,0,size);
            //替换原数组
            array = newArray;
        }
    }

    //remove 方法
    public int remove(int index){
        //1. 安全性校验
        if (index >= 0 && index< size) {
            //2. 删除元素
            int removedElement=array[index];
            //3. 填补空缺位置
             //3.1最后一个元素无需移动
            if (index<size-1) {
                System.arraycopy(array, index + 1, array,
                        index, size - index - 1);
            }
            //4.数组减小-1
            size--;
            return removedElement;
        }
        return -1;
    }
    //get方法 ：查询数组
    public int get(int index){
        return array[index];
    }

    //foreach 遍历方法1
    public void foreach(Consumer<Integer> consumer){
        for (int i = 0; i < size; i++) {
//            System.out.println(array[i]);
            consumer.accept(array[i]);
        }
    }

    //遍历方法2 迭代器：iterable接口 在iterator方法里面实现hashNext/next方法
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator() {
            int i=0;
            @Override
            public boolean hasNext() { //有没有下一个元素
                return i < size ;
            }

            @Override
            public Integer next() { //返回当前元素，并移动到下一个元素
                //后++ 先返回再自增
                return array[i++];
            }
        };
    }

    //遍历方法3：stream流
    public IntStream stream(){
        return IntStream.of(Arrays.copyOfRange(array,0,size));
    }

    //
}
