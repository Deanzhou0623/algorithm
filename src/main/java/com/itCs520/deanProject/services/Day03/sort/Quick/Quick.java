package com.itCs520.deanProject.services.Day03.sort.Quick;

public class Quick {

    //交换元素
    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp;
        temp= a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /*比较数组内部的值 元素v是否小于元素w
     * */
    private static boolean less(Comparable v, Comparable w) {
        //compareTo 实质是做减法
        return v.compareTo(w) < 0;
    }

    /*对数组a内部进行排序
    * */
    public static void sort(Comparable[] a) {
        int lo = 0;
        int hi = a.length-1;
        sort(a,lo,hi);

    }
    /*对数组a中从lo到li的元素进行排序
    * */
    private static void sort(Comparable[] a, int lo, int hi) {
        //安全性校验
        if (hi <= lo){
            return;
        }
        //需要对数组中的lo索引到hi索引处的元素进行分组（左子组，和右子组）
        int partition = partition (a,lo,hi); //返回的是分组的分界值所在的索引，分界值位置变换后的索引

        //让左子组有序
        sort(a,lo,partition-1);
        //让右子组有序
        sort(a,partition+1,hi);
    }

    /*
    对数组中，从lo到mid为一组 ，从mid到hi为一组， 对这两组数据进行归并
    * */
    public static int partition(Comparable[] a, int lo, int hi) {
        //确定分界值
        Comparable key= a[lo];
        //定义两个指针，分别指向最小索引处和最大索引处的下一个位置
        int left = lo;
        int right = hi + 1;
        //切分
        while (true){
            //先从右往左扫描，移动right指针，找到一个比分界值小的元素 ,停止
            while (less(key,a[--right])){
                if (right == lo){
                    break;
                }
            }
            //再从左往右扫描，移动left指针，找到一个比分界值大的元素，停止
            while (less(a[++left],key)){
                if (left == hi){
                    break;
                }
            }
            //判断 left >= right ,如果是，则证明元素扫描完毕，结束循环。如果不是则交换元素即可
            if(left >= right){
                break;
            }else {
                exch(a, left, right);
            }
        }
        //交换分界值 ,重新找分界值
        exch(a,lo,right);
        return right ;
    }

}
