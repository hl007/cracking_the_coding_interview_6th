package com.company.advance;

import com.company.graph.Queue;

// 给定3个素因子3、5、7生成数字序列，数字只能包含3个因子（不是必须），序列为1，3，5，7，9，15，21，25，27，35，...，返回第k个数
public class FactorCombination {
    public static int factorCombination(int k) {
        Queue<Integer> q=new Queue<>();
        q.enqueue(1);
        Queue<Integer> q3=new Queue<>();
        q3.enqueue(3);
        Queue<Integer> q5=new Queue<>();
        q5.enqueue(5);
        Queue<Integer> q7=new Queue<>();
        q7.enqueue(7);

        while(k>1) {
            factorHelper(q,q3,q5,q7);
            k--;
        }

        return q.tail();
    }

    // Ai+1可表示为: 3x前面列表中的某值、5x前面列表中的某值、7x前面列表中的某值
    private static void factorHelper(Queue<Integer> q,Queue<Integer> q3,Queue<Integer> q5,Queue<Integer> q7) {
        int min=q3.head();
        int flag=3;
        if(q5.head()<min) {
            min=q5.head();
            flag=5;
        }
        if(q7.head()<min) {
            min=q7.head();
            flag=7;
        }

        if(flag==3)      q3.dequeue();
        else if(flag==5) q5.dequeue();
        else             q7.dequeue();

        if(!q5.contains(3*min) && !q7.contains(3*min)) q3.enqueue(3*min);
        if(!q3.contains(5*min) && !q7.contains(5*min)) q5.enqueue(5*min);
        if(!q3.contains(7*min) && !q5.contains(7*min)) q7.enqueue(7*min);

        q.enqueue(min);
    }

    public static void main(String[] args) {
        System.out.println(factorCombination(10));
    }
}
