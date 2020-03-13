package com.company.sort;

import java.util.Arrays;

// 一个矩阵每行每列都是升序，查找某元素
public class SearchOrderedMatrix {
    public static int[] searchOrderedMatrix(int[][] matrix,int x) {
        int row=0;
        int col=matrix[0].length-1;
        while(row<matrix.length && col>=0) {
            if(matrix[row][col]==x) {
                return new int[]{row,col};
            }
            else if(matrix[row][col]>x) {
                col--;
            }
            else {
                row++;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[][] matrix=new int[4][];
        matrix[0]=new int[]{2,3,5,6,7};
        matrix[1]=new int[]{4,5,7,9,12};
        matrix[2]=new int[]{5,7,9,11,15};
        matrix[3]=new int[]{7,8,11,13,17};
        int[] result=searchOrderedMatrix(matrix,17);
        System.out.println(Arrays.toString(result));
    }
}
