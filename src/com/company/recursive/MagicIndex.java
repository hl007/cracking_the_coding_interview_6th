package com.company.recursive;

import java.util.Arrays;

// 一个有序整数数组，找出满足a[i]=i的一个i
public class MagicIndex {
    // 数组元素各不相同
    public static int magicIndex(int[] arr,int start,int end) {  // 二分查找
        if(start>end) {
            return -1;
        }

        int mid=(start+end)/2;
        if(arr[mid]>mid) {  // 查找左半边
            return magicIndex(arr,start,mid-1);
        }
        else if(arr[mid]<mid) {  // 查找右半边
            return magicIndex(arr,mid+1,end);
        }
        return mid;
    }

    // 有重复元素
    public static int magicIndex2(int[] arr,int start,int end) {  // 二分查找
        if(start>end) {
            return -1;
        }

        int mid=(start+end)/2;
        int midVal=arr[mid];
        if(mid==midVal) {
            return mid;
        }

        int leftIndex=Math.min(midVal,mid-1);
        int left=magicIndex2(arr,start,leftIndex);  // 查找左半边
        if(left>=0) {
            return left;
        }

        int rightIndex=Math.max(midVal,mid+1);
        int right=magicIndex2(arr,rightIndex,end);  // 查找右半边
        return right;
    }

    public static void main(String[] args) {
        int[] a=new int[]{-1,0,2,4,5,7,9};
        Arrays.sort(a);
        System.out.println(magicIndex(a,0,a.length-1));
    }
}
