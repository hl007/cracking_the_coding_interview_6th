package com.company.str;

import java.util.Arrays;
import java.util.HashMap;

// 两个字符串是否为互排
public class IsRearrange {
    public static boolean isRearrnge(String str,String str2) {
        char[] myArr=str.toCharArray();
        char[] myArr2=str2.toCharArray();
        Arrays.sort(myArr);
        Arrays.sort(myArr2);
        str=new String(myArr);
        str2=new String(myArr2);

        return str.equals(str2);
    }

    public static void main(String[] args) {
        boolean result=isRearrnge("daswd","dadwsj");
        System.out.println(result);
    }
}
