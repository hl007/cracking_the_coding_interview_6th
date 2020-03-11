package com.company.recursive;

// 递归乘法：两个正整数相乘，不用*
public class RecursiveMulti {
    public static int recursiveMult(int a,int b) {
        if(a<=0 || b<=0) throw new IllegalArgumentException("参数只能是正整数");

        int small=Math.min(a,b);
        int big=Math.max(a,b);
        int[] mem=new int[small+1];
        return subMult(small,big,mem);
    }

    private static int subMult(int small,int big,int[] mem) {
        if(small==0) {
            return 0;
        }
        else if(small==1) {
            return big;
        }

        if(mem[small]>0) {
            return mem[small];
        }

        int s=small/2;
        int side=subMult(s,big,mem);
        int side2;
        if(small%2==1) {
            side2=subMult(small-s,big,mem);
        }
        else {
            side2=side;
        }

        int result=side+side2;
        mem[small]=result;

        return result;
    }

    public static void main(String[] args) {
        System.out.println(recursiveMult(6,8));
    }
}
