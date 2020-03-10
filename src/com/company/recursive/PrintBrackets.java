package com.company.recursive;

import java.util.ArrayList;

// 输出n对括号所有的组合
public class PrintBrackets {
    public static void printBrackets(int n) {
        if(n<0) throw new IllegalArgumentException("参数不能为负");



    }

    public static void main(String[] args) {
        System.out.println("()");
        System.out.println("()()");
        System.out.println("(())");
        System.out.println("()()()");
        System.out.println("(())()");
        System.out.println("()(())");
        System.out.println("((()))");
        System.out.println("(()())");
    }
}
