package com.company.advance;

import java.util.ArrayList;
import java.util.HashMap;

// 给定一个散列表，key为婴儿名，value为婴儿的数量，并且给定相似的婴儿名对，要求将散列表中相似的婴儿名进行合并
public class StatOfBabyName {
    public static HashMap<String,Integer> statOfBabyName(HashMap<String,Integer> map,ArrayList<ArrayList<String>> synonyms) {
        ArrayList<ArrayList<String>> merge=new ArrayList<>();

        for(ArrayList<String> x:synonyms) {
            boolean flag=false;
            for(ArrayList<String> y:merge) {
                if(y.contains(x.get(0))) {
                    y.add(x.get(1));
                    flag=true;
                    break;
                }
                else if(y.contains(x.get(1))) {
                    y.add(x.get(0));
                    flag=true;
                    break;
                }
            }
            if(!flag) {
                ArrayList<String> z = new ArrayList<>();
                z.add(x.get(0));
                z.add(x.get(1));
                merge.add(z);
            }
        }

        HashMap<ArrayList<String>,Integer> result=new HashMap<>();
        for(ArrayList<String> x:merge) {
            result.put(x,0);
        }

        for(String s:map.keySet()) {
            for(ArrayList<String> x:result.keySet()) {
                if(x.contains(s)) {
                    result.put(x,result.get(x)+map.get(s));
                    break;
                }
            }
        }

        HashMap<String,Integer> finalResult=new HashMap<>();
        for(ArrayList<String> x:result.keySet()) {
            finalResult.put(x.get(0),result.get(x));
        }

        return finalResult;
    }

    public static void main(String[] args) {
        HashMap<String,Integer> map=new HashMap<>();
        map.put("john",12);
        map.put("jon",23);
        map.put("jhn",23);
        map.put("jamie",5);
        map.put("jame",7);
        ArrayList<ArrayList<String>> a=new ArrayList<>();
        ArrayList<String> b=new ArrayList<>();
        b.add("john");
        b.add("jon");
        ArrayList<String> c=new ArrayList<>();
        c.add("jhn");
        c.add("jon");
        ArrayList<String> d=new ArrayList<>();
        d.add("jamie");
        d.add("jame");
        a.add(b);
        a.add(c);
        a.add(d);

        System.out.println(statOfBabyName(map,a));
    }
}

