package com.company.recursive;

import java.util.HashMap;

// 硬币有25分，10分，5分，1分，返回n分的所有表示方法
public class ArrayOfCoin {
    public static int arrayOfCoin(int x) {
        int[] amounts=new int[]{25,10,5,1};
        HashMap<Integer,Integer> map=new HashMap<>();
        return subArray(x,amounts,0,map);
    }

    private static int subArray(int x,int[] amounts,int index,HashMap<Integer,Integer> map) {
        if(map.containsKey(x)) return map.get(x);

        if(index>=amounts.length-1) return 1;  // 单一币值构成的情况

        int amount=amounts[index];
        int ways=0;
        for(int i=0;i*amount<=x;i++) {
            ways+=subArray(x - i * amount, amounts, index + 1, map);
        }
        map.put(x,ways);
        return ways;
    }

    public static void main(String[] args) {
        System.out.println(arrayOfCoin(100));
    }
}
