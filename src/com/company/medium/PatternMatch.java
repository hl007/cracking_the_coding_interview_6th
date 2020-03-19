package com.company.medium;

// 给定两个字符串pattern和value，pattern由a和b组成（a，b各代表一种模式），判断value是否能匹配pattern
public class PatternMatch {
    public static boolean patternMatch(String pattern,String value) {
        if(pattern.length()==0) return value.length()==0;

        char mainChar=pattern.charAt(0);
        char secondChar='c';

        int countMain=0;
        for(char c:pattern.toCharArray()) {
            if(c==mainChar) {
                countMain++;
            }
            else {
                secondChar=c;
            }
        }
        int countSecond=pattern.length()-countMain;
        int indexSecond=pattern.indexOf(secondChar);

        for(int i=0;i<value.length()/countMain;i++) {
            String main=value.substring(0,i+1);

            String second;
            if(indexSecond!=-1) {
                int secondLength=(value.length()-countMain*(i+1))/countSecond;
                second=value.substring(main.length() * indexSecond, main.length() * indexSecond + secondLength);
            }
            else {
                second="";
            }

            String result="";
            for(char c:pattern.toCharArray()) {
                if(c==mainChar) {
                    result+=main;
                }
                else {
                    result+=second;
                }
            }

            if(result.equals(value)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String value="testgotest";
        System.out.println(patternMatch("aba",value));

    }
}
