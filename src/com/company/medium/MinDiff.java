package com.company.medium;

import java.util.Arrays;

// 给定两个整数数组，各取一个值，返回其最小差（非负）的一对值
public class MinDiff {
    public static int[] minDiff(int[] a,int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int i=0;
        int j=0;
        int diff=Integer.MAX_VALUE;
        int[] min=null;
        while(i<a.length && j<b.length) {
            if(Math.abs(a[i]-b[j])<diff) {
                diff=Math.abs(a[i]-b[j]);
                min=new int[]{a[i],b[j]};
            }

            if(a[i]<b[j]) {
                i++;
            }
            else {
                j++;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int[] a=new int[]{3,5,6,9,25};
        int[] b=new int[]{4,7,13,19};
        int[] result=minDiff(a,b);
        System.out.println(Arrays.toString(result));
    }
}
