package com.company.advance;

import java.util.ArrayList;
import java.util.Random;

// 完美洗牌，要求52!种牌生成的概率相同
public class Shuffle {
    public static ArrayList<Integer> shuffle() {
        ArrayList<Integer> arr=new ArrayList<>();
        Random r=new Random();
        for(int i=0;i<52;i++) {
            int num=r.nextInt(52);
            while(arr.contains(num)) {
                num=r.nextInt(52);
            }
            arr.add(num);
        }
        return arr;
    }
    public static void main(String[] args) {
        Random r=new Random();
        System.out.println(shuffle());
    }
}
