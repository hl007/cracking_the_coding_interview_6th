package com.company.advance;

import com.company.medium.Random7;

import java.util.Arrays;
import java.util.Random;

// 随机集合：从大小为n的数组中选出m个数，要求每个元素被选中的概率相同
public class RandomSelect {
    public static int[] randomSelect(int[] a,int m) {
        int[] subset=new int[m];
        for(int i=0;i<m;i++) {
            subset[i]=a[i];
        }

        Random r=new Random();
        for(int i=m;i<a.length;i++){
            int k=r.nextInt(i+1);
            if(k<m) {
                subset[k]=a[i];
            }
        }
        return subset;
    }

    public static void main(String[] args) {
        int[] a=new int[]{1,4,5,6,2,3};
        System.out.println(Arrays.toString(randomSelect(a,4)));
    }
}
