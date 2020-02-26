package com.company.str;

import java.util.ArrayList;
import java.util.Arrays;

// 零矩阵：一个MxN的矩阵，将元素为0的行和列的元素变为0
public class ZeroMatrix {
    public static void zeroMatrix(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        ArrayList<Integer> rowArr=new ArrayList<>();
        ArrayList<Integer> colArr=new ArrayList<>();
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(matrix[i][j]==0) {
                    rowArr.add(i);
                    colArr.add(j);
                }
            }
        }

        for(int i:rowArr) {
            matrix[i]=new int[col];
        }
        for(int i:colArr) {
            for(int j=0;j<row;j++) {
                matrix[j][i]=0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix=new int[3][];
        matrix[0]=new int[]{1,3,6,8};
        matrix[1]=new int[]{3,0,5,6};
        matrix[2]=new int[]{6,8,4,0};

        zeroMatrix(matrix);
        for(int i=0;i<matrix.length;i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

}
