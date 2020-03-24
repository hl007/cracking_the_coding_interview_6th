package com.company.advance;

import java.util.HashMap;
import java.util.HashSet;

// 给定一组单词，找到最长的单词，此单词是由其他单词组合而成
public class LongestWord {
    public static String longestWord(HashSet<String> set) {
        String longest="";
        HashMap<String,Boolean> mem=new HashMap<>();
        for(String s:set) {
            if(isCombine(set,s,true,mem)) {
                if(s.length()>longest.length()) {
                    longest=s;
                }
            }
        }
        return longest;
    }

    private static boolean isCombine(HashSet<String> set, String s,boolean isOrigin,HashMap<String,Boolean> mem) {
        if(mem.containsKey(s) && !isOrigin) {  // 获取缓存
            return mem.get(s);
        }

        if(s.length()==1) {
            if(set.contains(s) && !isOrigin) {
                mem.put(s,true);
                return true;
            }
            else {
                mem.put(s,false);
                return false;
            }
        }

        for(int i=0;i<s.length()-1;i++) {
            String left=s.substring(0,i+1);
            String right=s.substring(i+1);
            boolean isCombineLeft,isCombineRight;

            isCombineLeft=isCombine(set,left,false,mem);
            isCombineRight=isCombine(set,right,false,mem);
            if(isCombineLeft && isCombineRight) {
                mem.put(s,true);
                return true;
            }
        }

        if(set.contains(s)) {
            if(isOrigin) {
                return false;
            }
            else {
                mem.put(s,true);
                return true;
            }
        }
        else {
            mem.put(s,false);
            return false;
        }
    }

    public static void main(String[] args) {
        HashSet<String> set=new HashSet<>();
        set.add("test");
        set.add("walk");
        set.add("walker");
        set.add("tester");
        set.add("walktestertest");
        System.out.println(longestWord(set));
    }
}
