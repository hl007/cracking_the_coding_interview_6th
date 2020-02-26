package com.company.str;

// 利用字符出现的次数压缩字符串，比如"aaabbb"，"a3b3"
public class CompressStr {
    public static String compressStr(String str) {
        String str2="";
        int count=0;
        for(int i=0;i<str.length();i++) {
            char c=str.charAt(i);

            if(i==0) {
                str2+=c;
                count=1;
            }
            else {
                char cPre=str.charAt(i-1);
                if(c!=cPre) {
                    str2+=count;
                    str2+=c;
                    count=1;
                }
                else {
                    count+=1;
                }
            }

            if(i==str.length()-1) {
                str2+=count;
            }
        }

        if(str2.length()<str.length()) return str2;
        else                           return str;
    }

    public static void main(String[] args) {
        String result=compressStr("teeee");
        System.out.println(result);
    }
}
