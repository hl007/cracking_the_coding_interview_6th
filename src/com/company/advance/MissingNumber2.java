package com.company.advance;

// 给定一个数组，包含1~n的数，但缺少了一个，要求在O(n)时间复杂度和O(1)空间复杂度找出缺失的数
// 如果缺少两个...
public class MissingNumber2 {
    public static int status(int[] arr,int n) {  // 缺少一个数
        int complete=n*(n+1)/2;
        int sum=0;
        for(int x:arr) {
            sum+=x;
        }
        return complete-sum;
    }

    public static int[] status2(int[] arr,int n) {  // 缺少两个数
        int complete=n*(n+1)/2;
        int sum=0;
        for(int x:arr) {
            sum+=x;
        }
        int diff=complete-sum;

        int complete2=0;
        for(int i=1;i<=n;i++) {
            complete2+=i*i;
        }
        int sum2=0;
        for(int x:arr) {
            sum2+=x*x;
        }
        int diff2=complete2-sum2;
        double p=(2*diff+Math.sqrt(4*diff*diff-8*(diff*diff-diff2)))/4;
        double q=(2*diff-Math.sqrt(4*diff*diff-8*(diff*diff-diff2)))/4;
        return new int[]{(int)p,(int)q};
    }

    public static void main(String[] args) {
        int[] arr=new int[99];
        for(int i=1;i<100;i++) {
            if(i!=66 && i!=44) {
                arr[i-1]=i;
            }
        }

        int[] result=status2(arr,99);
        System.out.println(result[0]+","+result[1]);
    }
}
