package com.company.recursive;

import java.util.ArrayList;

// 返回某字符串的所有排列组合
public class ArrayOfString {
    // 字符不重复
    public static ArrayList<String> way(int len,String s) {
        if(len==1) {
            ArrayList<String> arr3=new ArrayList<>();
            for(int i=0;i<s.length();i++) {
                arr3.add(s.substring(i,i+1));
            }
            return arr3;
        }

        ArrayList<String> arr=way(len-1,s);
        ArrayList<String> arr2=new ArrayList<>();
        for(int i=0;i<s.length();i++) {
            String a=s.substring(i,i+1);
            for(String x:arr) {
                if(!x.contains(a)) {
                    arr2.add(x+a);
                }
            }
        }
        return arr2;
    }

    // 字符重复
    public static ArrayList<String> way2(int len,String s) {
        if(len==1) {
            ArrayList<String> arr3=new ArrayList<>();
            for(int i=0;i<s.length();i++) {
                String t=s.substring(i,i+1);
                if(!arr3.contains(t)) {
                    arr3.add(t);
                }
            }
            return arr3;
        }

        ArrayList<String> arr=way2(len-1,s);
        ArrayList<String> arr2=new ArrayList<>();
        for(int i=0;i<s.length();i++) {
            String a=s.substring(i,i+1);
            for(String x:arr) {
                if(stat(x,a)<stat(s,a) && (!arr2.contains(x+a))) {
                    arr2.add(x+a);
                }
            }
        }
        return arr2;
    }

    // 计算s中s2的个数
    private static int stat(String s,String s2) {
        int count=0;
        for(int i=0;i<s.length();i++) {
            if(s.substring(i,i+1).equals(s2)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ArrayList<String>  arr=way2(4,"forr");
        System.out.println(arr);
    }

}
