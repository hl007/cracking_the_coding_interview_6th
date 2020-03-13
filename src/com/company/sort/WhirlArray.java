package com.company.sort;

// 给定一个有序数组（升序），旋转若干次后，返回数组中的某个元素的索引
// [1,2,3,4,5,6] 旋转=> [4,5,6,1,2,3]
public class WhirlArray {
    // 二分查找
    public static int search(int[] a,int start,int end,int x) {
        if(start>end) {
            return -1;  // 没找到
        }

        int mid=(start+end)/2;
        if(x==a[mid]) {
            return mid;
        }

        if(a[mid]<a[start]) {  // 右侧有序
            if(x>=a[mid+1] && x<=a[end]) {
                return search(a,mid+1,end,x);
            }
            else {
                return search(a,start,mid-1,x);
            }
        }
        else {  // 左侧有序
            if(x>=a[start] && x<=a[mid-1]) {
                return search(a,start,mid-1,x);
            }
            else {
                return search(a,mid+1,end,x);
            }
        }
    }

    public static void main(String[] args) {
        int[] a=new int[]{1,2,3,4,5,6,7};
        int[] b=new int[]{4,5,6,7,1,2,3};
        int[] c=new int[]{2,3,4,5,6,7,1};
        System.out.println(search(c,0,6,4));
    }

}
