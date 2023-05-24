package com.itCs520.deanProject.LeetCode;/*
 *ClassName:GroupMerge
 *Description:
 *@Author:deanzhou
 *@Date:2023/4/24 18:42
 */

import java.util.LinkedList;
import java.util.Queue;

public class GroupMerge {
    public static void main(String[] args) {
        System.out.println(bfs(new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
        System.out.println(bfs(new int[][]{{1,0,0},{0,1,0},{0,0,1}}));
    }

    private static int bfs(int[][] citysConnected) {
        int citys = citysConnected.length;
        //if it's visited
        boolean[] visited = new boolean[citys];
        //counter
        int provinces = 0;
        Queue<Integer> queue = new LinkedList<>();
        // iterate city's
        for (int i = 0; i < citys; i++) {
            if (!visited[i]){
                queue.offer(i);
                while (!queue.isEmpty()){
                    int k= queue.poll();
                    visited[k] = true;
                    for (int j = 0; j <citys ; j++) {
                        if (citysConnected[i][j] == 1 && !visited[j]) {
                            queue.offer(j);
                        }
                    }
                }
                provinces++;
            }
        }
        return provinces;
    }
    // time: O(n2) space:O(n)
    private static int getProvince(int[][] citysConnected) {
        int citys = citysConnected.length;
        //if it's visited
        boolean[] visited = new boolean[citys];
        //counter
        int provinces = 0;
        // iterate city's
        for (int i = 0; i < citys; i++) {
            if (!visited[i]){
                //dfs
                dfs(i,citys,visited,citysConnected);    //O(n)
                provinces++;
            }
        }
        return provinces;
    }
    //dfs 
    private static void dfs(int i, int citys, boolean[] visited, int[][] citysConnected) {
        for (int j = 0; j < citys; j++) {
            if (citysConnected[i][j] == 1 && !visited[j]){
                visited[j] = true;
                dfs(j,citys,visited,citysConnected); //O(n)
            }
        }
    }


    //union- find
    private static int mergeFind(int[][] citysConnected){
        int citys = citysConnected.length;
        int[] head = new int[citys];
        int[] level = new int[citys];

        //initialize
        for (int i = 0; i < citys; i++) {
            head[i] = i;
            level[i] = 1;
        }
        //循环遍历 是否满足合并条件
        for (int i = 0; i < citys; i++) {
            for (int j = 0; j < citys; j++) {
                if (citysConnected[i][j] ==1){
                    merge(i,j,head,level);
                }
            }
        }
        //计算省份数量
        int count=0;
        for (int i = 0; i < citys; i++) {
            if(head[i] ==i){
                count++;
            }
        }
        return count;
    }
    //合并 low合并high的，这样 不会增加树的高度 ，可以有效降低时间复杂度
    static void merge(int x, int y, int[] head, int[] level) {
        int i = find(x,head);
        int j = find(y,head);

        if (i==j){
            return;
        }
        if (level[i] <= level[j]){
            head[i] = j;

        }else {
            head[j] =i;
        }
        if (level[i]==level[j]){
            level[i]++;
            level[j]++;
        }
    }
    //find root node
    private static int find(int x, int[] head) {
        if (head[x] == x){
            return x;
        }
        head[x] = find(head[x],head);
        return head[x];
    }

    /*省份数量问题 --> 其实就是 元素分组问题
    * */
}
