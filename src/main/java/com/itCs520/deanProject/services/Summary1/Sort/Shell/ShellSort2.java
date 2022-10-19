package com.itCs520.deanProject.services.Summary1.Sort.Shell;

public class ShellSort2 {
    //比较
    public static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w)>0;
    }
    //交换
    public static void exch(Comparable[] a,int i ,int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    //排序
    public static void sort(Comparable[] a){
        //1 根据数组长度决定增长量
        int h=1;
        while (h<a.length/2) {
            h = 2 * h + 1;
        }
            //2 希尔排序
            while (h>=1){
                //3 根据增长量确定排序元素
                for (int i = h; i <a.length ; i++) {
                    for (int j = i; j >=h ; j-=h) {
                        //4 比较元素大小
                        if (greater(a[j-h],a[j])){
                            //5 交换元素
                        exch(a,j-h,j);
                        }else {
                            //6 元素找到合适位置插入结束循环
                            break;
                        }
                    }
                }
                //7 减小规则
                h=h/2;
            }

    }
}
