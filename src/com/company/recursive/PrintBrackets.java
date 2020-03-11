package com.company.recursive;

import java.util.ArrayList;

// 输出n对括号所有的组合
public class PrintBrackets {
    public static ArrayList<String> printBrackets(int n) {
        if(n<0) throw new IllegalArgumentException("参数不能为负");

        ArrayList<String> arr=new ArrayList<>();
        char[] s=new char[n*2];
        add(arr,n,n,s,0);
        return arr;
    }

    private static void add(ArrayList<String> arr,int leftRem,int rightRem,char[] s,int index) {
        if(leftRem<0 || leftRem>rightRem) {
            return;
        }

        if(leftRem==0 && rightRem==0) {
            arr.add(String.copyValueOf(s));
        }
        else {
            s[index] = '(';
            add(arr, leftRem - 1, rightRem, s, index + 1);

            s[index] = ')';
            add(arr, leftRem, rightRem - 1, s, index + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(printBrackets(2));
     }
}
