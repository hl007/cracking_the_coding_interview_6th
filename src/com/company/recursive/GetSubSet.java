package com.company.recursive;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

// 返回一个集合的所有子集
public class GetSubSet {
    public static ArrayList<LinkedList<Integer>> getSubSet(LinkedList<Integer> s) {
        ArrayList<LinkedList<Integer>> arr=new ArrayList<>();
        arr.add(new LinkedList<>());
        Iterator<Integer> iterator= s.iterator();
        while(iterator.hasNext()) {
            int a=iterator.next();
            ArrayList<LinkedList<Integer>> temp=(ArrayList<LinkedList<Integer>>)arr.clone();
            for(LinkedList<Integer> list:temp) {
                LinkedList<Integer> list2=(LinkedList<Integer>) list.clone();
                list2.add(a);
                arr.add(list2);
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        LinkedList<Integer> s=new LinkedList<>();
        s.add(3);
        s.add(4);
        s.add(5);
        s.add(6);
        ArrayList<LinkedList<Integer>> arr=getSubSet(s);
        System.out.println(arr);
    }
}
