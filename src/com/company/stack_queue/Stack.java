package com.company.stack_queue;

import com.company.linkedlist.LinkedList;

//链表实现栈
public class Stack {
    //栈顶
    private Node first;
    private int N;
    private class Node{
        int item;
        Node next;
    }
    public boolean isEmpty(){
        return first==null;
    }
    public int size(){
        return N;
    }
    public void push(int item){
        Node oldfirst=first;
        first=new Node();
        first.item=item;
        first.next=oldfirst;
        N++;
    }
    public int pop(){
        if(size()==0) throw new IllegalArgumentException("栈为空");

        int item=first.item;
        first=first.next;
        N--;
        return item;
    }

    public int peek() {
        if(size()==0) throw new IllegalArgumentException("栈为空");

        return first.item;
    }

    // 对栈进行排序（栈顶为最小元素），最多用一个临时栈
    public void sortMin() {
        if(size()==0) throw new IllegalArgumentException("栈为空");

        Stack s=new Stack();  // 临时栈

        while(!isEmpty()) {
            int temp=pop();
            while(!s.isEmpty() && temp<s.peek()) {
                int a=s.pop();
                push(a);
            }
            s.push(temp);
        }

        // 将临时栈的数据复制到原栈
        while(!s.isEmpty()) {
            push(s.pop());
        }
    }

    public static void main(String[] args) {
        Stack s=new Stack();
        s.push(4);
        s.push(5);
        s.push(3);
        s.push(12);
        s.push(4);
        s.push(8);
        s.push(12);
        s.sortMin();
        while(!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

}
