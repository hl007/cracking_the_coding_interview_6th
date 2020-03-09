package com.company.bit;

import java.sql.Array;
import java.util.*;

// 给定一个正整数，返回与其二进制中1的个数相同且大小最接近的两个数（一个略大，一个略小）
public class GetNext {
    public static int[] getNext(int x) {
        if(x<=0) throw new IllegalArgumentException("x必须为正整数");

        // 找出最低位的0
        boolean[] a=new boolean[32];
        for(int i=0;i<32;i++) {
            a[31-i]=getBit(x,i);
        }
        int lowIndex=0;
        for(int i=0;i<32;i++) {
             if(!a[i]) lowIndex=i;
        }

        // 计算1的个数
        ArrayList<Integer> arrOf1=new ArrayList<>();
        for(int i=0;i<32;i++) {
            if(a[i]) arrOf1.add(i);
        }

        if(arrOf1.size()==1) {
            return new int[]{2,4};
        }
        else if(arrOf1.size()==2) {
            int temp=setBit(x,arrOf1.get(0),true);
            int closet=setBit(temp,arrOf1.get(0),false);
            int closet2=setBit(temp,arrOf1.get(1),false);

            return new int[]{closet,closet2};
        }
        else {
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int i:arrOf1) {
                map.put(i,Math.abs(i-lowIndex));
            }

            System.out.println("map: "+map);

            // 根据值排序
            List<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
            Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>() {
                public int compare(Map.Entry<Integer, Integer> o1,
                                   Map.Entry<Integer, Integer> o2) {
                    return o1.getValue().compareTo(o2.getValue());
                }
            });

            int temp=setBit(x,arrOf1.get(0),true);
            int closet=setBit(temp,list.get(0).getKey(),false);
            int closet2=setBit(temp,list.get(1).getKey(),false);
            int closet3=setBit(temp,list.get(2).getKey(),false);

            HashMap<Integer,Integer> map2=new HashMap<>();
            map2.put(closet,Math.abs(closet-x));
            map2.put(closet2,Math.abs(closet2-x));
            map2.put(closet3,Math.abs(closet3-x));
            List<Map.Entry<Integer,Integer>> list2 = new ArrayList<Map.Entry<Integer,Integer>>(map2.entrySet());
            Collections.sort(list2,new Comparator<Map.Entry<Integer,Integer>>() {
                public int compare(Map.Entry<Integer, Integer> o1,
                                   Map.Entry<Integer, Integer> o2) {
                    return o1.getValue().compareTo(o2.getValue());
                }
            });
            return new int[]{list.get(0).getKey(),list.get(1).getKey()};
        }

    }

    // 获取数位
    public static boolean getBit(int num,int i) {
        return (num & (1<<i))!=0;
    }

    // 更新数位
    private static int setBit(int num,int i,boolean bitIs1) {
        int val=bitIs1?1:0;
        int mask=~(1<<i);
        return (num & mask) | (val<<i);
    }


    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(123456));
        System.out.println(Arrays.toString(getNext(123456)));
    }
}
