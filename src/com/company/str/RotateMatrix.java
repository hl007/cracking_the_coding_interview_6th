package com.company.str;

import java.util.Arrays;

// 旋转矩阵：一幅N*N的图像，旋转90°，要求不占用额外空间
public class RotateMatrix {
    public static void rotateMatirx(int[][] matrix) {
        int layer=matrix.length/2;
        for(int i=0;i<layer;i++) {
            for(int j=i;j<matrix.length-i-1;j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[matrix.length-j-1][i];  // 左边换到上边
                matrix[matrix.length-j-1][i]=matrix[matrix.length-i-1][matrix.length-j-1];  // 下边换到左边
                matrix[matrix.length-i-1][matrix.length-j-1]=matrix[j][matrix.length-i-1];  // 右边换到下边
                matrix[j][matrix.length-i-1]=temp;  // 上边换到右边
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix=new int[4][];
        matrix[0]=new int[]{1,2,3,4};
        matrix[1]=new int[]{5,6,7,8};
        matrix[2]=new int[]{9,10,11,12};
        matrix[3]=new int[]{13,14,15,16};
        rotateMatirx(matrix);
        for(int i=0;i<matrix.length;i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

    }
}
