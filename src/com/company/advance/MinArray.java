package com.company.advance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// 给定两个数组，一长一短，短的元素各不相同，要求在长数组中找到包含短数组元素的最短序列（不考虑顺序）
public class MinArray {
    public static int[] minArray(int[] shorter,int[] longer) {
        int[][] pos=new int[shorter.length][];
        for(int i=0;i<shorter.length;i++) {
            pos[i]=new int[longer.length];
            int prev=Integer.MAX_VALUE;
            for(int j=longer.length-1;j>=0;j--) {  // 从后向前遍历长数组
                if (shorter[i] == longer[j]) {
                    prev = j;
                }
                pos[i][j] = prev;
            }
        }

        int min=Integer.MAX_VALUE;
        int[] minArr=null;
        for(int i=0;i<longer.length;i++) {  // 获取索引i开头的最短数组
            int max=Integer.MIN_VALUE;
            for(int j=0;j<shorter.length;j++) {
                if(pos[j][i]>max) {
                    max=pos[j][i];
                }
            }
            if(max!=Integer.MAX_VALUE) {  // 存在这样的数组
                int diff=max-i;
                if(diff<min) {
                    min=diff;
                    minArr=new int[]{i,max};
                }
            }
        }

        return minArr;
    }

    public static void main(String[] args) {
        int[] shorter=new int[]{1,5,7};
        int[] longer=new int[]{1,3,5,9,7,4,1,3,5,9,5,7,1,12,14};
        int[] result=minArray(shorter,longer);
        System.out.println(result[0]+","+result[1]);
    }
}
