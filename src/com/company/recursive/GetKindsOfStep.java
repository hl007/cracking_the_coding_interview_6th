package com.company.recursive;

import java.util.HashMap;

// 一个楼梯n阶台阶，小孩一次可上1、2、3阶，共有多少种上楼梯的方式
public class GetKindsOfStep {
    public static int getKindsOfStep(int n) {
        if(n<=0) throw new IllegalArgumentException("参数必须为正整数");

        HashMap<Integer,Integer> map=new HashMap<>();

        if(n==1) return 1;
        if(n==2) return 2;
        if(n==3) return 4;

        int way,way2,way3;
        if(map.containsKey(n-1)) {
            way=map.get(n-1);
        }
        else {
            way=getKindsOfStep(n-1);
            map.put(n-1,way);
        }

        if(map.containsKey(n-2)) {
            way2=map.get(n-2);
        }
        else {
            way2=getKindsOfStep(n-2);
            map.put(n-2,way2);
        }
        if(map.containsKey(n-3)) {
            way3=map.get(n-3);
        }
        else {
            way3=getKindsOfStep(n-3);
            map.put(n-3,way3);
        }

        return way+way2+way3;
    }

    public static void main(String[] args) {
        System.out.println(getKindsOfStep(5));
    }
}
