package com.company.medium;

// n阶乘有多少尾随零
public class FactorialZero {

    public static int factorial(int n) {
        int count=0;
        for(int i=2;i<=n;i++) {
            count+=sub(i);
        }
        return count;
    }

    private static int sub(int n) {  // 计算有几个5
        int count=0;
        while(n%5==0) {
            n=n/5;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(factorial(10));
    }
}
