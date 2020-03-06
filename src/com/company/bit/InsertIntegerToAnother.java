package com.company.bit;

// 给定两个32位的整数n和m（较小），将M插入到N的i位到j位
public class InsertIntegerToAnother {
    public static int insertIntegerToAnother(int n,int m,int i,int j) {
        System.out.println(Integer.toBinaryString(m).length());
        if(j-i+1!=Integer.toBinaryString(m).length() || i<0 || i>Integer.toBinaryString(n).length()-1 || j<0 ||
                j>Integer.toBinaryString(n).length()-1) throw new IllegalArgumentException("i，j参数错误");
        if(Integer.toBinaryString(n).length()<Integer.toBinaryString(m).length()) throw new IllegalArgumentException("n，m参数错误");

        // 将n的i到j位设成0
        for(int x=i;x<=j;x++) {
            n=clearBit(n,x);
        }

        // 左移i
        m=m<<i;
        return n | m;
    }

    // 数位清零
    private static int clearBit(int num,int i) {
        int mask=~(1<<i);
        return num & mask;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(12000));
        System.out.println(Integer.toBinaryString(21));

        int result=insertIntegerToAnother(12000,21,2,6);
        System.out.println(Integer.toBinaryString(result));
    }
}
