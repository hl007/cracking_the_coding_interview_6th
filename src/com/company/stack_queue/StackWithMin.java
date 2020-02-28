package com.company.stack_queue;

// 一个栈，min()返回栈中最小值，pop()，push()，min()时间复杂度为O(1)
public class StackWithMin extends Stack {
    private Stack s;  // 辅助栈，记录每个状态的min
    private int min;

    public StackWithMin() {
        s=new Stack();
    }

    public void push(int item) {
        if(size()==0) {
            min=item;
        }
        super.push(item);

        if(item<=min) {
            min=item;
            s.push(min);
        }
    }

    public int pop() {
        int t=super.pop();
        if(t==min) {
            s.pop();
        }
        return t;
    }

    public int min() {
        return s.peek();
    }

    public static void main(String[] args) {
        StackWithMin sMin=new StackWithMin();
        sMin.push(3);
        sMin.push(4);
        sMin.push(5);
        sMin.push(2);
        sMin.push(2);

        while(!sMin.isEmpty()) {
            System.out.println(sMin.min());
            sMin.pop();
        }

    }
}
