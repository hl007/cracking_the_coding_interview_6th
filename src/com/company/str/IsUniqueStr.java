package com.company.str;

import java.util.HashMap;

// 判断字符串的字符是否全都不同
public class IsUniqueStr {
    public static boolean isUniqueStr(String str) {
        if(str.length()>128) return false;  // ascii字符串
        boolean[] arr=new boolean[128];
        for(int i=0;i<str.length();i++) {
            if(arr[str.charAt(i)]) {
                return false;
            }
            else {
                arr[str.charAt(i)]=true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        boolean result=isUniqueStr("test");
        System.out.println(result);

    }
}
