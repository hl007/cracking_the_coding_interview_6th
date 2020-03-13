package com.company.sort;

import java.util.ArrayList;
import java.util.Arrays;

// 两个有序数组A和B，A有足够的空间容纳B，将B合并到A中并排序
public class MergeTwoArrays {
    // 从a和b的右端向左移动，比较a和b的最大值，将较大者放入a的右端
    public static int[] mergeTwoArras(int[] a,int[] b,int lastA,int lastB) {
        int mergeIndex=lastA+lastB+1;
        while(lastB>=0) {
            if(b[lastB]>a[lastA]) {
                a[mergeIndex]=b[lastB];
                lastB--;
            }
            else {
                a[mergeIndex]=a[lastA];
                lastA--;
            }
            mergeIndex--;
        }
        return a;
    }

    public static void main(String[] args) {
       int[] a=new int[12];
       a[0]=3;
       a[1]=4;
       a[2]=6;
       a[3]=8;
       a[4]=10;
       int[] b=new int[10];
       b[0]=5;
       b[1]=7;
       b[2]=11;
       b[3]=13;

       int[] result=mergeTwoArras(a,b,4,3);
       System.out.println(Arrays.toString(result));
    }
}
