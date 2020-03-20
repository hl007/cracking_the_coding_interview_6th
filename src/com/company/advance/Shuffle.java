package com.company.advance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

// 完美洗牌，要求52!种牌生成的概率相同
public class Shuffle {
    public static void shuffle(int[] cards) {
        Random r=new Random();
        for(int i=0;i<cards.length;i++) {
            int k=r.nextInt(i+1);
            int temp=cards[k];
            cards[k]=cards[i];
            cards[i]=temp;
        }
    }
    public static void main(String[] args) {
        int[] cards=new int[52];
        for(int i=0;i<52;i++) {
            cards[i]=i;
        }
        shuffle(cards);
        System.out.println(Arrays.toString(cards));
    }
}
