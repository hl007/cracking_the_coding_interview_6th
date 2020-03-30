package com.company.medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// 给定一个整数数组，返回总和最大的连续数列
public class GetMaxSum {
    public static Range getMaxSum(int[] a) {
        int sum=0;
        int start=0;
        Range best=null;
        for(int i=0;i<a.length;i++) {
            sum+=a[i];
            if(best==null || sum>best.sum) {
                best=new Range(start,i,sum);
            }

            if(sum<0) {
                start=i+1;
                sum=0;
            }
        }

        return best;
    }

    public static void main(String[] args) {
        int[] a=new int[]{2,3,-8,-1,2,4,-2,3,-4,2,-2,6};
        Range result=getMaxSum(a);
        System.out.println(result);
    }

}

class Range {
    int start;
    int end;
    int sum;

    Range(int start,int end,int sum) {
        this.start=start;
        this.end=end;
        this.sum=sum;
    }

    public String toString() {
        return start+","+end+"->"+sum;
    }
}

