package com.company.advance;

import java.util.ArrayList;

// 数组A包含0~n的所有整数，但缺少一个；数组元素以二进制形式保存，唯一的访问方式为"A[i]取第j位数"，该操作时间复杂度为常量，
// 要求以O(n)时间找到这个数。
public class MissingNumber {
    public static void missingNumber(ArrayList<BitInteger> arr) {
        missingNumberHelper(arr,0);
    }

    private static int missingNumberHelper(ArrayList<BitInteger> arr,int column) {  // 确定第i数位
        if(column>=BitInteger.INTEGER_SIZE) {
            return 0;
        }

        ArrayList<BitInteger> oneBits=new ArrayList<>(arr.size()/2);
        ArrayList<BitInteger> zeroBits=new ArrayList<>(arr.size()/2);

        for(BitInteger b:arr) {  // 计算第i位上0和1的数量
            if(b.fetch(column)==0) {
                zeroBits.add(b);
            }
            else {
                oneBits.add(b);
            }
        }

        if(zeroBits.size()<=oneBits.size()) {  // 由于缺少了0，丢失的数此数位为0，缩小数组范围
            int v=missingNumberHelper(zeroBits,column+1);
            return (v<<1) | 0;
        }
        else {
            int v=missingNumberHelper(oneBits,column+1);
            return (v<<1) | 1;
        }

    }

    private static class BitInteger {  // 二进制元素
        static int INTEGER_SIZE=4;

        int fetch(int column){  // 获取数位
            return 0;
        }
    }

    public static void main(String[] args) {
        for(int i=0;i<6;i++) {
            System.out.println(String.format("%3s", Integer.toBinaryString(i)));
        }
    }

}
