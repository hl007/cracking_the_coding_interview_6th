package com.company.advance;

import java.lang.reflect.Array;
import java.util.*;

// 叠罗汉：给定若干人进行叠罗汉，上面的人比下面的人轻一点且矮一点，求最多能叠几人？
public class DoubleSort {
    public static int doubleSort(ArrayList<Man> arr) {
        Collections.sort(arr, new Comparator<Man>() {  // 先根据身高排序
            @Override
            public int compare(Man o1, Man o2) {
                return o1.height-o2.height;
            }
        });

        HashMap<Integer,ArrayList<Man>> map=new HashMap<>();
        for(int i=0;i<arr.size();i++) {
            sortHelper(arr,i,map);
        }
        System.out.println(map);

        int longest=0;
        for(int x:map.keySet()) {
            if(map.get(x).size()>longest) {
                longest=map.get(x).size();
            }
        }

        return longest;
    }

    private static void sortHelper(ArrayList<Man> arr, int index, HashMap<Integer,ArrayList<Man>> map) {  // 以a[x]结尾的最长序列
        if(index==0) {
            ArrayList<Man> a=new ArrayList<>();
            a.add(arr.get(0));
            map.put(0,a);
            return;
        }

        int max=0;
        int endIndex=-1;
        for(int i=0;i<index;i++) {
            int size=map.get(i).size();
            if(size>max & arr.get(index).weight>=map.get(i).get(size-1).weight) {
                endIndex=i;
                max=size;
            }
        }
        if(endIndex==-1) {
            ArrayList<Man> p=new ArrayList<>();
            p.add(arr.get(index));
            map.put(index,p);
        }
        else {
            ArrayList<Man> q=(ArrayList<Man>)map.get(endIndex).clone();
            q.add(arr.get(index));
            map.put(index,q);
        }
    }


    private static class Man{
        int height;
        int weight;

        Man(int height,int weight) {
            this.height=height;
            this.weight=weight;
        }

        public String toString() {
            return height+"/"+weight;
        }
    }

    public static void main(String[] args) {
        ArrayList<Man> arr=new ArrayList<>();
        arr.add(new Man(69,100));
        arr.add(new Man(65,88));
        arr.add(new Man(70,90));
        arr.add(new Man(80,110));
        arr.add(new Man(64,84));
        arr.add(new Man(83,10));
        arr.add(new Man(72,60));
        System.out.println(doubleSort(arr));
    }
}
