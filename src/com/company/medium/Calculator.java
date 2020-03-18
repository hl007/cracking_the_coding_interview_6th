package com.company.medium;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 计算器：给定一个包换+0*/的计算表达式，返回结果
public class Calculator {
    public static int calculator(String s) {
        s=s.replace(" ","");
        return calculatorHelper(s);
    }

    private static int calculatorHelper(String s) {  // 计算+-
        Pattern p=Pattern.compile("(.*)(\\+)(.*)");
        Pattern p2=Pattern.compile("(.*)(-)(.*)");
        Matcher m=p.matcher(s);
        Matcher m2=p2.matcher(s);
        if(!m.find()) {  // 没有+
            if(!m2.find()) {  // 没有-
                return calculatorHelper2(s);
            }
            else {
                return calculatorHelper(m2.group(1))-calculatorHelper(m2.group(3));
            }
        }
        else {
            return calculatorHelper(m.group(1))+calculatorHelper(m.group(3));
        }

    }

    private static int calculatorHelper2(String s) {  // 计算*/
        Pattern p=Pattern.compile("(.*)(\\*)(.*)");
        Pattern p2=Pattern.compile("(.*)(/)(.*)");
        Matcher m=p.matcher(s);
        Matcher m2=p2.matcher(s);
        if(!m.find()) {  // 没有*
            if(!m2.find()) {  // 没有/
                return Integer.parseInt(s);
            }
            else {
                return calculatorHelper2(m2.group(1))/calculatorHelper2(m2.group(3));
            }
        }
        else {
            return calculatorHelper2(m.group(1))*calculatorHelper2(m.group(3));
        }
    }

    public static void main(String[] args) {
        String s="1+2*6/3*3-4";
        System.out.println(calculatorHelper(s));
    }
}
