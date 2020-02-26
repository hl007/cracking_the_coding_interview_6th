package com.company.node;

import java.util.ArrayList;

public class LinkedList {
    private Node first;
    private int N;
    private class Node{
        Integer item;
        Node next;
    }

    public void push(Integer item) {
        Node oldfirst=first;
        first=new Node();
        first.item=item;
        first.next=oldfirst;
        N++;
    }

    public int size() {
        return N;
    }

    // 移除无序链表中重复的节点
    public void removeDuplicatedNode() {
        ArrayList<Integer> arr=new ArrayList<>();
        for(Node x=first;x!=null && x.next!=null;x=x.next) {
            if(arr.contains(x.next.item)) {
                x.next=x.next.next;
            }
            else {
                arr.add(x.item);
            }
        }
    }

    // 删除链表中间的某个节点
    public void delete(Integer x) {

    }

    // 以x分割链表，使得小于x的节点集合在前，大于等于x的集合在后
    public LinkedList separate(Integer s) {
        LinkedList less=new LinkedList();
        LinkedList more=new LinkedList();
        for(Node x=first;x!=null;x=x.next) {
            if(x.item<s) {
                less.push(x.item);
            }
            else {
                more.push(x.item);
            }
        }
        Node last=null;
        for(Node x=less.first;x!=null;x=x.next) {
            last=x;
        }
        last.next=more.first;

        return less;
    }

    // 给定两个链表，每个链表的节点表示一个数位，个位在链表首部（1->2->3，1是个位）
    public LinkedList plusAnotherList(LinkedList s) {
        LinkedList more;
        LinkedList less;
        if(s.size()>=size()) {
            more=s;
            less=this;
        }
        else {
            more=this;
            less=s;
        }

        int t=0;
        Node last=null;
        for(Node x=more.first,y=less.first;x!=null && y!=null;x=x.next,y=y.next) {
            int temp=x.item+y.item+t;
            x.item=temp%10;
            t=temp/10;
            last=x.next;
        }
        for(Node x=last;x!=null;x=x.next) {
            int temp=x.item+t;
            x.item=temp%10;
            t=temp/10;
        }

        return more;
    }

    // 个位在链表尾部（1->2->3，3是个位）
    public LinkedList plusAnotherList2(LinkedList s) {
        LinkedList more;
        LinkedList less;
        if(s.size()>=size()) {
            more=s;
            less=this;
        }
        else {
            more=this;
            less=s;
        }

        int t=0;
        Node last=null;
        for(Node x=more.first,y=less.first;x!=null && y!=null;x=x.next,y=y.next) {
            int temp=x.item+y.item+t;
            x.item=temp%10;
            t=temp/10;
            last=x.next;
        }
        for(Node x=last;x!=null;x=x.next) {
            int temp=x.item+t;
            x.item=temp%10;
            t=temp/10;
        }

        return more;
    }

    public void print() {
        for(Node x=first;x!=null;x=x.next) {
            if(x.next!=null) {
                System.out.print(x.item + " --> ");
            }
            else {
                System.out.print(x.item);
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        LinkedList list=new LinkedList();
        list.push(3);
        list.push(4);
        list.push(2);
        list.push(6);
        list.push(2);
        list.push(3);
        list.push(7);
        list.print();

        LinkedList list2=new LinkedList();
        list2.push(8);
        list2.push(4);
        list2.push(7);
        list2.push(1);
        list2.print();

        list2.plusAnotherList(list).print();


    }
}
