package com.company.advance;

// 一个数组中，主要元素指元素数量超过一半，找出主要元素，要求时间复杂度为O(n)，空间复杂度为O(1);
public class MainNumber {
    public static int mainNumber(int[] a) {
        int candidate=getCandidate(a);
        int count=0;
        for(int n:a){  // 确定候选元素是否为主要元素
            if(n==candidate) {
                count++;
            }
        }
        if(count>a.length/2) {
            return candidate;
        }
        else {
            return -1;
        }
    }

    private static int getCandidate(int[] a) {  // 获取可能的主要元素
        int count=0;
        int majority=0;
        for(int n:a) {
            if(count==0) {
                majority=n;
            }
            if(n==majority) {
                count++;
            }
            else {
                count--;
            }
        }
        return majority;
    }

    public static void main(String[] args) {
        int[] a=new int[]{2,4,5,5,4,5,5};
        System.out.println(mainNumber(a));
    }
}

