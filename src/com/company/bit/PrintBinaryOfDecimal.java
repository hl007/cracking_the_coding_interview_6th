package com.company.bit;

// 打印0到1之间（0.72）实数的二进制形式
// 小数转二进制：小数X2的整数部分为二进制的第1位，小数部分x2继续循环，直至没有小数
public class PrintBinaryOfDecimal {
    public static String printBinaryOfDecimal(double a) {
        if(a<=0 || a>=1) return "error";

        StringBuilder s=new StringBuilder();
        s.append(".");
        while(a!=0) {
            if(s.length()>32) return "error";
            a=a*2;
            s.append((int)a);
            a=a%1;
        }
        return s.toString();
    }

    public static void main(String[] args) {
        String result=printBinaryOfDecimal(0.375);
        System.out.println(Integer.toBinaryString(1775));
    }

}
