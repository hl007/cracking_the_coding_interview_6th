package com.company.bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

// 给定一个整数，可将一个数位从0变为1，使得一串1的长度最长，返回其长度
public class GetLength {
    public static int getLength(int x) {  // 将二进制序列看成0序列和1序列交替而成
        if(~x==0) return Integer.BYTES*8;

        int previous_length=0;  // 0序列之前的1序列长度
        int current_length=0;  // 当前的1序列长度
        int maxLength=1;
        while(x!=0) {
            if((x&1)==1) {  // 当前位为1
                 current_length++;
            }
            else {  // 当前位为0
                current_length=0;
                if((x&2)==1) {  // 前一位为1
                    previous_length=current_length;
                }
                else {  // 前一位为0
                    previous_length=0;
                }
            }
            maxLength=Math.max(previous_length+1+current_length,maxLength);
            x>>>=1;  // 从低位向高位移动
      }
      return maxLength;
    }



    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(125612));
        System.out.println(getLength(125612));
    }
}
