package com.company.medium;

import java.util.Arrays;

// 给定一个数组a，找出最短序列a[m:n+1]，使得此序列有序后，整个数组也有序
public class PartSort {
    public static int[] partSort(int[] a) {
        int m=0;
        int n=a.length-1;
        while(m<=n) {
            int[] prev=Arrays.copyOfRange(a,0,m-1);

        }
        return null;
    }

    private static int min(int[] a) {
        int[] b=a.clone();
        Arrays.sort(b);
        return b[0];
    }

    private static int max(int[] a) {
        int[] b=a.clone();
        Arrays.sort(b);
        return b[b.length-1];
    }

    // 判断是否有序
    private boolean isSorted(int[] a) {
        boolean flag=true;
        for(int i=0;i<a.length-1;i++) {
            if(i==0) {
                flag=a[i]-a[i+1]>0;
            }
            else {
                boolean this_flag=a[i]-a[i+1]>0;
                if(flag!=this_flag) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] a=new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        System.out.println();
    }
}
