package com.company.advance;

import java.util.HashMap;

// 按摩师最长预约时间
public class MaxMinutes {
    public static int maxMinutes(int[] arr) {
        HashMap<Integer,Integer> mem=new HashMap<>();
        return maxMinutesHelper(arr,0,mem);
    }

    private static int maxMinutesHelper(int[] arr,int x,HashMap<Integer,Integer> mem) {
        if(mem.containsKey(x)) {
            return mem.get(x);
        }

        if(x>=arr.length) {
            return 0;
        }

        // 包含arr[x]的预约方案
        int with=arr[x]+maxMinutesHelper(arr,x+2,mem);

        // 不包含arr[x]的预约方案
        int without=maxMinutesHelper(arr,x+1,mem);

        int result=Math.max(with,without);
        mem.put(x,result);

        return result;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{45,60,15,75,90,60};
        System.out.println(maxMinutes(arr));
    }
}
