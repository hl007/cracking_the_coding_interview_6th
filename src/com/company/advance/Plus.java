package com.company.advance;

import java.awt.*;

// 将两个数相加，不用+和其他算术运算符
public class Plus {
    public static int plus(int a,int b) {
        return 0;
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
        System.out.println(Integer.toBinaryString(-4));
        System.out.println(Integer.toBinaryString(3));
        System.out.println(Integer.toBinaryString(3|10));
    }
}
