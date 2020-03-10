package com.company.bit;

import java.sql.Array;
import java.util.*;

// 给定一个正整数，返回与其二进制中1的个数相同且大小最接近的两个数（一个略大，一个略小）
public class GetNext {
    // 获取较大的数：先找到右边非拖尾的0，然后将其右边的0和1重新排列
    public static int getNext(int x) {
        if(x<=0) throw new IllegalArgumentException("x必须为正整数");

        int c=x;
        int c0=0;  // 非拖尾的0右边0的数量
        int c1=0;  // 非拖尾的0右边1的数量
        while((c&1)==0) {  // 计算非拖尾的0右边0的数量
            c0++;
            c>>=1;
        }

        while((c&1)==1) {  // 计算非拖尾的0右边1的数量
            c1++;
            c>>=1;
        }

        if(c0+c1==31) {  // 0111110000...，不存在更大且1相同的值
            return -1;
        }

        int p=c0+c1;
        x=setBit(x,p,true);  // p位设为1
        // 重新排列p的右边
        for(int i=0;i<c1-1;i++) {
            x=setBit(x,i,true);
        }
        for(int i=c1-1;i<p;i++) {
            x=setBit(x,i,false);
        }

        return x;
    }

    // 获取较小的数：先找到右边非拖尾的1，然后将其右边的0和1重新排列
    public static int getPrev(int x) {
        if(x<=0) throw new IllegalArgumentException("x必须为正整数");

        int c=x;
        int c0=0;
        int c1=0;

        while((c&1)==1) {
            c1++;
            c>>=1;
        }

        while((c&1)==0) {
            c0++;
            c>>=1;
        }

        if(c0+c1==32) {  // 00000000111...，不存在更小且1相同的值
            return -1;
        }

        int p=c0+c1;
        x=setBit(x,p,false);  // p位设为0
        // 重新排列p的右边
        for(int i=0;i<c0-1;i++) {
            x=setBit(x,i,false);
        }
        for(int i=c0-1;i<p;i++) {
            x=setBit(x,i,true);
        }

        return x;
    }

    // 获取数位
    public static boolean getBit(int num,int i) {
        return (num & (1<<i))!=0;
    }

    // 更新数位
    private static int setBit(int num,int i,boolean bitIs1) {
        int val=bitIs1?1:0;
        int mask=~(1<<i);
        return (num & mask) | (val<<i);
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(1234554));
        System.out.println(Integer.toBinaryString(getPrev(1234554)));
        System.out.println(getPrev(1234554));
    }
}
