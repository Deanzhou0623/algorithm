package com.itCs520.deanProject.Basic2.array;/*
 *ClassName:Array
 *Description:
 *@Author:deanzhou
 *@Date:2023/6/12 21:19
 */

public class Array {

    /*
    * 数组： 一组元素组成的数据结构，每个元素至少有个索引或者标识符
    *       数组内元素是连续存储的
    * 计算索引i元素地址： BaseAddress + i*size (int 是4 ，double是8)
    *
    * int[] class  一共16个字节
    *              markword(8个字节) + 类指针(4个字节)+数组大小(4个字节) 2的32次方
    *
    * int[] array = {1,2,3,4,5}   一共40个字节 16+ 5x4 + 4个（alignment 对齐字节）
    *
    * 动态数组： dynamicArray
    *
    * 二维数组：
    * cpu     缓存（提高读写速度）   内存
    * 皮秒                         纳秒
    *
    *         缓存64个字节 cache Line 缓存读取最小单位
    *
    * 空间局限性：
    *
    * */
}
