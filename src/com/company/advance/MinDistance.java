package com.company.advance;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// 一个超大文本中有若干单词，给定两个单词，查找两个单词在文本中的最短距离
public class MinDistance {
    public static int minDistance(String[] arr,String a,String b) {
        HashMap<String, ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<arr.length;i++) {
            if(map.containsKey(arr[i])) {
                map.get(arr[i]).add(i);
            }
            else {
                ArrayList<Integer> x=new ArrayList<>();
                x.add(i);
                map.put(arr[i],x);
            }
        }

        if(map.containsKey(a) && map.containsKey(b)) {
            ArrayList<Integer> p=map.get(a);
            Integer[] p2=new Integer[p.size()];
            p.toArray(p2);

            ArrayList<Integer> q=map.get(b);
            Integer[] q2=new Integer[q.size()];
            q.toArray(q2);

            int[] z=minDiff(p2,q2);
            System.out.println(Arrays.toString(z));
            return Math.abs(z[0]-z[1]);
        }

        return -1;
    }

    public static int[] minDiff(Integer[] a,Integer[] b) {
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
        String[] a=new String[]{"t","s","a","b","t","b","s","a"};
        System.out.println(minDistance(a,"t","a"));
    }
}
