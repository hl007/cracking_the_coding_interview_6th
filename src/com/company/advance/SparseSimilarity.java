package com.company.advance;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.HashSet;

// 两个文档的相似度指交集的个数除以并集的个数。现有若干文档，任选两个文档，其相似度接近0，要求计算每一对文档的相似度
public class SparseSimilarity {
    public static HashMap<String,Double> sparseSimilarity(HashMap<Integer,int[]> map) {
        HashMap<String,Double> result=new HashMap<>();
        for(Integer key:map.keySet()) {
            for(Integer key2:map.keySet()) {
                String p=key+","+key2;
                String q=key2+","+key;
                if(!key.equals(key2) && !result.containsKey(p) && !result.containsKey(q)) {
                    double similarity=(double) intersection(map.get(key),map.get(key2))/union(map.get(key),map.get(key2));
                    result.put(p,similarity);
                }
            }
        }
        return result;
    }

    // 交集个数
    private static int intersection(int[] a,int[] b) {
        return a.length+b.length-union(a,b);
    }

    // 并集个数
    private static int union(int[] a,int[] b) {
        HashSet<Integer> set=new HashSet<>();
        for(int i:a) {
            set.add(i);
        }

        for(int i:b) {
            set.add(i);
        }

        return set.size();
    }



    public static void main(String[] args) {
        HashMap<Integer,int[]> map=new HashMap<>();
        map.put(1,new int[]{5,2,4,3,11,12});
        map.put(2,new int[]{12,4,6,5,23,45});
        map.put(3,new int[]{14,13,24,15,34,3,6,7});
        System.out.println(sparseSimilarity(map));
    }
}
