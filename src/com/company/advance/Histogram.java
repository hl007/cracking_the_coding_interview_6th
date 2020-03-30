package com.company.advance;

import java.util.Arrays;

// 给定一个直方图，从上面不断倒水，返回最终的水量（直方图宽度为1）
public class Histogram {
    public static int getArea(int[] arr) {
        int[] maxLeft=new int[arr.length];
        int[] maxRight=new int[arr.length];

        // 获取每个长方形左侧最高的高度和右边最高的高度
        int max=0;
        int max2=0;
        for(int i=0;i<arr.length;i++) {
            if(arr[i]>=max) {
                max=arr[i];
            }
            maxLeft[i]=max;

            if(arr[arr.length-1-i]>=max2) {
                max2=arr[arr.length-1-i];
            }
            maxRight[arr.length-1-i]=max2;
        }

        System.out.println(Arrays.toString(maxLeft));
        System.out.println(Arrays.toString(maxRight));
        // 获取每个长方形的水位
        int total=0;
        for(int i=0;i<arr.length;i++) {
            int p=Math.min(maxLeft[i],maxRight[i]);
            total+=p-arr[i];
        }
        return total;
    }

    public static void main(String[] args) {
        int[] arr=new int[] {0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 5, 0, 1, 0, 0, 0};
        System.out.println(getArea(arr));
    }
}
