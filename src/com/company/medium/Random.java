package com.company.medium;

// 已知一个rand5生成0到4的随机整数，要求rand7生成0到6的随机整数
public class Random {
    public static int rand7() {
        while(true) {
            int num=5*rand5()+rand5();
            while(num<21) {
                return num%7;
            }
        }
    }

    public static int rand5() {
        return 0;
    }
}
