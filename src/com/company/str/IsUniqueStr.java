package com.company.str;

import java.util.HashMap;

// 判断字符串的字符是否全都不同
public class IsUniqueStr {
    // dict
    public static boolean wayOfDict(String myStr) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<myStr.length();i++) {
            char myChar=myStr.charAt(i);
            if(map.containsKey(myChar)) {
                map.put(myChar,map.get(myChar)+1);
            }
            else {
                map.put(myChar,1);
            }
        }

        boolean flag=true;
        for(char c:map.keySet()) {
            if(map.get(c)>1) {
                flag=false;
                break;
            }
        }

        return flag;
    }

    // 数组
    public static boolean wayOfArray(String myStr) {
        int[] myArr=new int[1000];
        for(int i=0;i<myStr.length();i++) {
            char myChar=myStr.charAt(i);
            myArr[myChar]+=1;
        }

        boolean flag=true;
        for(int i:myArr) {
            if(i>1) {
                flag=false;
                break;
            }
        }

        return flag;
    }

    public static void main(String[] args) {
//        boolean result=wayOfDict("dasjk");
        boolean result=wayOfArray("dasjka");
        System.out.println(result);

    }
}
