package com.company.str;


// 字符串的url化
public class UrlFormatOfStr {
    public static String urlFormatOfStr(String str) {
        str=str.trim().replace(" ","%20");
        return str;
    }
    public static void main(String[] args) {
        String result=urlFormatOfStr(" it is a test ");
        System.out.println(result);
    }
}
