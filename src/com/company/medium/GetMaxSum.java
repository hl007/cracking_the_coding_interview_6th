package com.company.medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// 给定一个整数数组，返回总和最大的连续数列
public class GetMaxSum {
    public static int getMaxSum(int[] a) {

        // 将数组转换成正负交替的序列
        HashMap<Integer,Range> map=new HashMap<>();
        ArrayList<Integer> x=new ArrayList<>();
        int start=0;
        int end=0;
        for(int i=0;i<a.length;i++) {
            if(i==0) {
                x.add(a[i]);
            }
            else {
                if(a[i]*a[i-1]<0) {
                    map.put(x.size()-1,new Range(start,end));
                    x.add(a[i]);
                    start=i;
                    end=i;
                }
                else {
                    x.set(x.size()-1,x.get(x.size()-1)+a[i]);
                    end++;
                }
            }
        }
        map.put(x.size()-1,new Range(start,end));

        int maxSum=0;
        int sum=0;
        ArrayList<Integer> maxArr=null;
        ArrayList<Integer> arr=new ArrayList<>();
        int maxStart=0;
        int maxEnd=0;
        for(int i=0;i<x.size();i++) {
            sum+=x.get(i);
            arr.add(x.get(i));
            if(sum>maxSum) {
                maxSum=sum;
                maxArr= new ArrayList<>(arr.subList(0,arr.size()));
                maxStart=i-arr.size()+1;
                maxEnd=i;
            }
            else if(sum<0) {
                sum=0;
                arr=new ArrayList<>();
            }
        }

        int originStart=map.get(maxStart).start;
        int originEnd=map.get(maxEnd).end;
        System.out.println(originStart+","+originEnd);
        return maxSum;
    }

    private static class Range {
        int start;
        int end;

        Range(int start,int end) {
            this.start=start;
            this.end=end;
        }

        public String toString() {
            return start+","+end;
        }
    }

    public static void main(String[] args) {
        int[] a=new int[]{2,3,-8,-1,2,4,-2,3,-4,2,-2,6};
        int[] b=new int[]{-4};
        int result=getMaxSum(b);
        System.out.println(result);
    }

}
