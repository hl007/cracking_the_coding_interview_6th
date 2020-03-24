package com.company.advance;

// 将两个数相加，不用+和其他算术运算符
public class Plus {
    public static int plus(int a,int b) {
        while(b!=0) {
            int sum=a^b;   // 只相加，不进位
            int carry=(a&b)<<1;  // 只进位，不想加
            a=sum;
            b=carry;
        }
        return a;
    }


    public static void main(String[] args) {
        System.out.println(plus(3,-4));
    }
}
