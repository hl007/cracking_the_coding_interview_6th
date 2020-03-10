package com.company.recursive;

// 递归乘法：两个正整数相乘，不用*
public class RecursiveMulti {
    public static int recursiveMult(int a,int b) {
        if(a<=0 || b<=0) throw new IllegalArgumentException("参数只能是正整数");

        return 1;
    }
}
