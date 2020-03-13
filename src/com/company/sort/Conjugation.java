package com.company.sort;

import java.lang.reflect.Array;
import java.util.*;

// 对字符串数组进行排序，将变位词排在一起
public class Conjugation {
    public static ArrayList<String> conjugation(String[] arr) {
        HashMap<String, ArrayList<String>> map=new HashMap<>();
        for(String s:arr) {
            char[] sArr=s.toCharArray();
            Arrays.sort(sArr);
            String sortedS=Arrays.toString(sArr);  // 排序后的字符串作为建
            if(map.containsKey(sortedS)) {
                map.get(sortedS).add(s);
            }
            else {
                ArrayList<String> arr2=new ArrayList<>();
                arr2.add(s);
                map.put(sortedS,arr2);
            }
        }

        ArrayList<String> result=new ArrayList<>();
        for(String key:map.keySet()) {
            ArrayList<String> valList=map.get(key);
            for(String s:valList) {
                result.add(s);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] arr=new String[5];
        arr[0]="estt";
        arr[1]="stli";
        arr[2]="lite";
        arr[3]="list";
        arr[4]="test";

        System.out.println(conjugation(arr));
    }
}
