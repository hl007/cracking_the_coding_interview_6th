package com.company.str;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 字符串轮转：给定两个字符串，其中一个字符串经过一次轮转是否变成另一个字符串，比如"waterflower"，"terflowerwa"
public class RotateStr {
    public static boolean rotateStr(String str,String str2) {
        boolean flag=false;
        if(str.length()==str2.length()) {
            char c=str2.charAt(0);
            Pattern p=Pattern.compile(""+c);
            Matcher m=p.matcher(str);
            while(m.find()) {
                if(rotate(str,m.start()).equals(str2)) {
                    flag=true;
                    break;
                }
            }
        }

        return flag;
    }

    private static String rotate(String str,int pos) {
        return str.substring(pos)+str.substring(0,pos);
    }

    public static void main(String[] args) {
        boolean result=rotateStr("waterflowed","terflowerwa");
        System.out.println(result);
    }
}
