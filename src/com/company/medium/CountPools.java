package com.company.medium;

import java.util.ArrayList;
import java.util.HashMap;

// 统计所有水塘的大小
public class CountPools {
    private ArrayList<Integer> arr;

    public ArrayList<Integer> countPools(int[][] matrix) {  // dfs
        boolean[][] marked=new boolean[matrix.length][];
        for(int i=0;i<marked.length;i++) {
            marked[i]=new boolean[matrix[0].length];
        }

        arr=new ArrayList<>();

        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                if(!marked[i][j]) {
                    int count=dfs(matrix,marked,i,j,0);
                    if(count>0) arr.add(count);
                }
            }
        }

        return arr;
    }

    private int dfs(int[][] matrix,boolean[][] marked,int i,int j,int count) {
        marked[i][j]=true;

        if(matrix[i][j]==0) {
            count+=1;
            if(j-1>=0 && !marked[i][j-1]) count=dfs(matrix,marked,i,j-1,count);  // 左侧
            if(j-1>=0 && i+1<=matrix.length-1 && !marked[i+1][j-1]) count=dfs(matrix,marked,i+1,j-1,count);  // 左下角
            if(i+1<=matrix.length-1 && !marked[i+1][j]) count=dfs(matrix,marked,i+1,j,count);  // 下方
            if(j+1<=matrix[0].length-1 && !marked[i][j+1]) count=dfs(matrix,marked,i,j+1,count);  // 右侧
            if(i+1<=matrix.length-1 && j+1<=matrix[0].length-1 && !marked[i+1][j+1]) count=dfs(matrix,marked,i+1,j+1,count);  // 右下角
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] matrix=new int[4][];
        matrix[0]=new int[]{0,2,1,0};
        matrix[1]=new int[]{0,1,0,1};
        matrix[2]=new int[]{1,1,0,1};
        matrix[3]=new int[]{0,1,0,1};

        CountPools c=new CountPools();
        System.out.println(c.countPools(matrix));
    }
}
