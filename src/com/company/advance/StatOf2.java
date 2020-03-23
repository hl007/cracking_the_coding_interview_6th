package com.company.advance;

// 统计0~n之间2出现的次数
public class StatOf2 {
    public static int statOf2(int n) {
        int count=0;
        for(int i=0;i<String.valueOf(n).length();i++) {  // 是从最低位开始计算
            count+=subStat(n,i);
        }
        return count;
    }

    private static int subStat(int num,int digit) {  // 第i位数为2的数量
        int powerOf10=(int)Math.pow(10,digit);

        int roundDown=num-num%(powerOf10*10);
        int roundUp=roundDown+powerOf10*10;
        int right=num%powerOf10;  // 某位数右边的值

        int x=(num/powerOf10)%10;
        if(x<2) {
            return roundDown/10;
        }
        if(x>2) {
            return roundUp/10;
        }
        else {
            return num/powerOf10+right+1;
        }
    }

    public static void main(String[] args) {
         int[] a=new int[]{61523,63523,62523};
         String[] b=new String[]{"2000~2999","12000~12999","22000~22999","32000~32999", "42000~42999","52000~52999","62000~62999"};
         System.out.println(statOf2(61523));
    }
}
