package com.company.sort;

// 给定一个有序的字符串数组，其中散布若干空字符串，返回给定字符串的位置
public class SearchSparseArray {
    public static int searchSparseArray(String[] a,int start,int end,String x) {
        if(start>end) return -1;

        int mid=(start+end)/2;
        int temp=mid;
        while(temp>=start && a[temp].equals("")) {  // 如果是空字符串，向左移动直到非空字符串
            temp--;
        }
        if(temp>=start) {
            if (x.equals(a[temp])) {
                return temp;
            }
            if (x.compareTo(a[temp]) < 0) {  // 在左半边
                return searchSparseArray(a, start, temp-1, x);
            }
        }

        // 在右半边
        while(mid<=end && a[mid].equals("")) {
            mid++;
        }
        if(mid<=end) {
            if(x.equals(a[mid])) {
                return mid;
            }
            if(x.compareTo(a[mid])>0) {
                return searchSparseArray(a,mid+1,end,x);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String[] a=new String[]{"b","","","c","","d","","","e","",""};
        System.out.println(searchSparseArray(a,0,a.length-1,"e"));
    }
}
