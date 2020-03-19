package com.company.medium;

import java.util.ArrayList;
import java.util.HashMap;

// T9键盘：给一系列数字，返回有效的单词列表
public class T9Input {
    public static ArrayList<String> t9Input(String input) {
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('a',2);
        map.put('b',2);
        map.put('c',2);
        map.put('d',3);
        map.put('e',3);
        map.put('f',3);
        map.put('g',4);
        map.put('h',4);
        map.put('i',4);
        map.put('j',5);
        map.put('k',5);
        map.put('l',5);
        map.put('m',6);
        map.put('n',6);
        map.put('o',6);
        map.put('p',7);
        map.put('q',7);
        map.put('r',7);
        map.put('s',7);
        map.put('t',8);
        map.put('u',8);
        map.put('v',8);
        map.put('w',9);
        map.put('x',9);
        map.put('y',9);
        map.put('z',9);

        String[] list=new String[]{"tree","used","test","first"};

        HashMap<String,ArrayList<String>> map2=new HashMap<>();
        for(String s:list) {
            String key="";
            for(char c:s.toCharArray()) {
                key+=map.get(c);
            }
            if(map2.containsKey(key)) {
                map2.get(key).add(s);
            }
            else {
                ArrayList<String> temp=new ArrayList<>();
                temp.add(s);
                map2.put(key,temp);
            }
        }

        if(map2.containsKey(input)) {
            return map2.get(input);
        }
        else {
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(t9Input("8733"));
    }
}
