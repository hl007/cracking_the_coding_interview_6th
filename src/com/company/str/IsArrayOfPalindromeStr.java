package com.company.str;

import java.util.HashMap;

// 判断一个字符串是否能排列成回文字符串
public class IsArrayOfPalindromeStr {
    public static boolean isArrayOfPalindromeStr(String str) {
        str=str.replace(" ","");
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<str.length();i++) {
            char c=str.charAt(i);
            if(map.containsKey(c)) {
                map.put(c,map.get(c)+1);
            }
            else {
                map.put(c,1);
            }
        }

        int num=0;  // 奇数字符数量的字符类型
        for(int i:map.values()) {
            if(i%2==1) {
                num+=1;
            }
        }
        boolean flag=true;
        if(num>1) flag=false;

        return flag;
    }

    public static void main(String[] args) {
        boolean result=isArrayOfPalindromeStr("a sszdasd");
        System.out.println(result);
    }
}
