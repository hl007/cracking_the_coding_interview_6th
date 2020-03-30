package com.company.advance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// 给定字典的两个单词，长度相等，要求将其中一个单词转为另一个单词，每次只能改变一个字符，且新单词要在字典中
public class WordTransform {
    public static String[] wordTransform(ArrayList<String> words,String a,String b) {
        HashMap<Integer,ArrayList<String>> map=new HashMap<>();
        for(String s:words) {
            int count=compare(a,s);
            if(map.containsKey(count)) {
                map.get(count).add(s);
            }
            else {
                ArrayList<String> arr=new ArrayList<>();
                arr.add(s);
                map.put(count,arr);
            }
        }

        System.out.println(map);
        String[] result=new String[a.length()+1];
        result[0]=a;
        wordTransformHelper(a,1,map,result);

        if(result[result.length-1]==null) return null;

        if(result[result.length-1].equals(b)) {
            return result;
        }
        else{
            return null;
        }
    }

    private static void wordTransformHelper(String source,int count,HashMap<Integer,ArrayList<String>> map,String[] result) {
        if(count==source.length()+1) return;

        if(map.containsKey(count)) {
            ArrayList<String> arr=map.get(count);
            for(String s:arr) {
                if(compare(s,result[count-1])==1) {
                    result[count]=s;
                    wordTransformHelper(source,count+1,map,result);
                }
            }
        }

    }

    private static int compare(String source,String x) {
        if(source.length()!=x.length()) {
            return -1;
        }

        int count=0;
        for(int i=0;i<source.length();i++) {
            if(source.charAt(i)!=x.charAt(i)) {
                count++;
            }
        }

        return count;
    }


    public static void main(String[] args) {
        ArrayList<String> words=new ArrayList<>();
        words.add("DAMP");
        words.add("DBMP");
        words.add("LAMP");
        words.add("LAPP");
        words.add("LIMP");
        words.add("LIME");
        words.add("LIKE");
        String[] result=wordTransform(words,"DAMP","LIKE");
        System.out.println(Arrays.toString(result));
    }
}
