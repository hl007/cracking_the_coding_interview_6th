package com.company.node;

import java.util.ArrayList;

public class LinkedList {
    private Node first;
    private int N;

    public void push(Integer item) {
        Node oldfirst=first;
        first=new Node();
        first.item=item;
        first.next=oldfirst;
        N++;
    }

    public void push(Node x) {
        Node oldfirst=first;
        first=x;
        x.next=oldfirst;
    }

    public int size() {
        return N;
    }

    // 移除无序链表中重复的节点（节点中的元素相同即为重复）
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

    // 删除链表中间的某个节点（只能访问此节点）
    public boolean deleteOneNode(Node x) {
        if(x==null || x.next==null) {
            return false;
        }
        else {
            x.item = x.next.item;
            x.next = x.next.next;
            return true;
        }
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

    // 给定两个链表，每个链表的节点表示一个数位，个位在链表尾部（1->2->3，3是个位）
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

        // 将less前面补0
        int diff=more.size()-less.size();
        while(diff>0) {
            less.push(0);
            diff--;
        }

        for(Node x=less.first,y=more.first;x!=null && y!=null;x=x.next,y=y.next) {
            x.item=x.item+y.item;
        }

        less.print();

        less.first=dealWithNumber(less.first);

        int t=less.first.item/10;
        if(t>0) {
            less.first.item=less.first.item%10;
            less.push(t);
        }

        return less;
    }

    private Node dealWithNumber(Node x) {
        if(x.next!=null && x.next.next==null) {
            int t=x.next.item/10;
            x.next.item=x.next.item%10;
            x.item=x.item+t;
        }
        else {
            x.next=dealWithNumber(x.next);
            int t=x.next.item/10;
            x.next.item=x.next.item%10;
            x.item=x.item+t;
        }
        return x;
    }

    // 给定两个链表，判断是否相交（有同一个节点的引用）
    public Node getSameNodeOfAnotherList(LinkedList s) {
       // 寻找链表的尾节点，尾部不同不存在交点
        Node tail=null;
        for(Node x=first;x!=null;x=x.next) {
            tail=x;
        }
        Node tail2=null;
        for(Node x=s.first;x!=null;x=x.next) {
            tail2=x;
        }
        if(tail!=tail2) return null;

        LinkedList more,less;
        if(size()>=s.size()) {
            more=this;
            less=s;
        }
        else {
            more=s;
            less=this;
        }
        int diff=more.size()-less.size();
        Node start=more.first;
        while(diff>0) {
            start=start.next;
            diff--;
        }

        for(Node x=start,y=less.first;x!=null;x=x.next,y=y.next) {
            if(x==y) return x;
        }
        return null;
    }

    // 环路检测
    public Node detectCycle() {
        ArrayList<Node> arr=new ArrayList<>();
        for(Node x=first;x!=null;x=x.next) {
            System.out.println(x.item);
            System.out.println(x.next.item);
            if(x.next!=null) {
                if(arr.contains(x.next)) {
                    return x.next;
                }
                else {
                    arr.add(x);
                }
            }
        }
        System.out.println(arr);
        return null;
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
        Node x=new Node();
        x.item=12;
        Node y=new Node();
        y.item=4;
        LinkedList list=new LinkedList();
        list.push(x);
        list.push(y);
        list.push(9);
        list.push(8);
        list.print();
        x.next=y;

        System.out.println(list.detectCycle().item);

    }
}

class Node{
    Integer item;
    Node next;
}
