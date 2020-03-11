package com.company.recursive;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

// 八皇后：8x8的棋盘上放八个皇后，要求不同行、不同列、不同对角线
public class EightQueen {
    private int size=8;  // 棋盘大小

    public ArrayList<int[]> eightQueen() {
        ArrayList<int[]> arr=new ArrayList<>();
        int[] x=new int[8];  // 每个棋子的坐标
        queenHelper(0,x,arr);  // 从第一行开始
        return arr;
    }

    private void queenHelper(int row,int[] x,ArrayList<int[]> arr) {
        if (row == size) {
            arr.add(x.clone());
        }
        else {
            for (int i = 0; i < size; i++) {
                if (checkValid(x, row, i)) {
                    x[row] = i;
                    queenHelper(row + 1, x, arr);
                }
            }
        }
    }

    // 棋子是否有效
    private static boolean checkValid(int[] x,int row,int col) {
        for(int i=0;i<row;i++) {
            if(x[i]==col) return false; // 检查是否在同一列

            if(Math.abs(x[i]-col)==row-i) return false;  // 两行的距离等于两列的距离说明在同一对角线上
        }
        return true;
    }

    public static void main(String[] args) {
        EightQueen q=new EightQueen();
        ArrayList<int[]> arr=q.eightQueen();
        for(int[] a:arr) {
            System.out.println(Arrays.toString(a));
        }
    }
}
