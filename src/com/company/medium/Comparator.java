package com.company.medium;

// 不用比较运算符和if-else，找出两个数中较大的值
public class Comparator {
    public static int comparator(int a,int b) {
        int c=a-b;
        int ka=sign(a);  // a>=0为1，否则为0
        int kb=sign(b);  // b>=0为1，否则为0
        int kc=sign(c);  // 处理溢出

        int useSignA=ka^kb;  // a和b符号不同为1，相同为0
        int useSignC=flip(ka^kb);

        int k=useSignA*ka+useSignC*kc;  // a和b不同时返回ka，相同时返回kc
        int q=flip(k);

        return a*k+b*q;
    }

    private static int flip(int bit) {  // 0变成1，1变成0
        return 1^bit;
    }

    private static int sign(int n) {  // >=0变成1，<0变成0
        return flip(n>>31 & 0x1);
    }

    public static void main(String[] args) {
        System.out.println(-3>>31 & 1);
    }
}
