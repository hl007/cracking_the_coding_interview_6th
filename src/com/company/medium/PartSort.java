package com.company.medium;

import java.util.Arrays;
import java.util.Collections;

// 给定一个数组a，找出最短序列a[m:n+1]，使得此序列有序后，整个数组也有序
public class PartSort {
    public static int[] partSort(int[] a) {
        int[] result=partSortHelper(a);

        int[] reverse=new int[a.length];
        for(int i=0;i<a.length;i++) {
            reverse[a.length-1-i]=a[i];
        }
        int[] result2=partSortHelper(reverse);
        if(result2!=null) {
            result2=new int[]{a.length-1-result2[1],a.length-1-result2[0]};
        }

        if(result==null) {
            return result2;
        }
        else {
            return result;
        }
    }

    private static int[] partSortHelper(int[] a) {  // 升序
        if(a.length<=2) {
            return null;
        }

        int m=0;
        while(m<a.length-1) {  // 先确定m
            int[] prev=Arrays.copyOfRange(a,0,m+1);
            int[] last=Arrays.copyOfRange(a,m+1,a.length);
            if(max(prev)<=min(last) && isSorted(prev) && a[1]-a[0]>=0) {
                m++;
            }
            else {
                break;
            }
        }


        if(m==a.length-1) {
            return null;
        }

        int n=a.length-1;
        while(n>=m) {  // 再确定n
            int[] prev=Arrays.copyOfRange(a,0,n);
            int[] last=Arrays.copyOfRange(a,n,a.length);
            if(max(prev)<=min(last) && isSorted(last) && (a[1]-a[0])*(a[a.length-1]-a[a.length-2])>=0) {
                n--;
            }
            else {
                break;
            }
        }

        if(n==a.length-1) {
            return null;
        }

        return new int[]{m,n};
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
    private static boolean isSorted(int[] a) {
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
        int[] a=new int[]{1, 2, 4, 3, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        int[] b=Arrays.copyOfRange(a,1,2);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(partSort(a)));
    }
}
