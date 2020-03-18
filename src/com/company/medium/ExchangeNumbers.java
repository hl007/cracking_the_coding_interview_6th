package com.company.medium;

// 不用临时变量交换两个数
public class ExchangeNumbers {
    public static void exchangeTwoNumbers(int a,int b) {
        b=b-a;
        a=a+b;
        b=a-b;
        System.out.println("a: "+a);
        System.out.println("b: "+b);
    }

    public static void main(String[] args) {
        int a=3,b=11;
        exchangeTwoNumbers(a,b);
    }
}
