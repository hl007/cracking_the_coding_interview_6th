package com.company.stack_queue;

import java.util.ArrayList;

// 堆盘子：由多个栈组成的集合，当一个栈填满时新建一个栈
public class SetOfStacks {
    private int subSize;  // 每个子栈的大小
    private int size;
    private ArrayList<Stack> arr;

    public SetOfStacks(int subSize) {
        this.subSize=subSize;
        arr=new ArrayList<>();
    }

    public void push(int item) {
        int r=size%subSize;
        int t=size/subSize;

        if(r==0) {
            if(t==arr.size()) {
                Stack s = new Stack();
                s.push(item);
                arr.add(s);
            }
            else {
                arr.get(t).push(item);
            }
        }
        else {
            arr.get(t).push(item);
        }
        size++;
    }

    public int pop() {
        int r=size%subSize;
        int t=size/subSize;
        size--;
        if(r==0) {
            return arr.get(t-1).pop();
        }
        else {
            return arr.get(t).pop();
        }
    }

    public static void main(String[] args) {
        SetOfStacks s=new SetOfStacks(4);
        s.push(4);
        s.push(7);
        s.push(10);
        s.push(6);
        s.push(12);
        s.push(3);
        while(s.size>0) {
            System.out.println(s.pop());
        }
    }

}
