package com.company.advance;

import java.util.ArrayList;
import java.util.HashMap;

// 一个存放字符和数字的数组，找到最长的子数组，要求其字符和数字的个数相同
public class CharAndNumber {
    public static int[] getLongestArray(Object[] arr) {
        int countNumber=0;  // 数字的数量
        int countChar=0;  // 字符的数量

        int[] max=new int[]{0,0};
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++ ) {
            if(arr[i] instanceof Character) {
                countChar++;
            }
            else {
                countNumber++;
            }
            int diff=countChar-countNumber;
            if(map.containsKey(diff)) {
                if(i-map.get(diff)>max[1]-max[0]) {
                    max[0]=map.get(diff)+1;
                    max[1]=i;
                }
            }
            else {
                map.put(diff,i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Object[] a=new Object[]{1,'c',2,2,'d','e',4,3,'d','a','f',6};
        int[] result=getLongestArray(a);
        System.out.println(result[0]+","+result[1]);
    }
}
