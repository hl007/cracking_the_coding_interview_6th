package com.company.stack_queue;

// 用两个栈实现一个队列
public class MyQueue {
    private int size;
    private Stack s;
    private Stack s2;  // 临时栈

    public MyQueue() {
        s=new Stack();
        s2=new Stack();
    }

    public void enqueue(int item) {
        s.push(item);
        size++;
    }

    public int dequeue() {
        if(size==0) throw  new IllegalArgumentException("空队列不能出列");

        int deValue=0;
        // 将s数据转到s2中
        while(!s.isEmpty()) {
            s2.push(s.pop());
        }
        deValue=s2.pop();

        // 再将s2数据还原到s中
        while(!s2.isEmpty()) {
            s.push(s2.pop());
        }

        size--;
        return deValue;
    }

    public static void main(String[] args) {
        MyQueue q=new MyQueue();
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        while(q.size>0) {
            System.out.println(q.dequeue());
        }
    }

}
