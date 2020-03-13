package com.company.sort;

import java.util.Arrays;

// 给定一个数组，将元素大小交替排序
public class PeekValley {
    public static int[] peekValley(int[] a) {
        Arrays.sort(a);  // 先排序
        for(int i=0;i<a.length-1;i+=2) {
            int temp=a[i];
            a[i]=a[i+1];
            a[i+1]=temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a=new int[]{1,3,4,7,9,11};
        System.out.println(Arrays.toString(peekValley(a)));
    }
}
