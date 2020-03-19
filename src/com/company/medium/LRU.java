package com.company.medium;

import java.util.HashMap;

// 设计一个LRU缓存，该缓存初始化时指定最大容量，在缓存满时，删除最近最少使用的元素（时间最久的）
// 基于双向链表和散列表
public class LRU {
    private HashMap<Integer,Node> map;
    private Node head;  // 表头，用于插入元素
    private Node tail;  // 表尾，用于删除元素
    private int capacity;  // 缓存容量

    public LRU(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
    }

    private class Node {
        int key;
        String value;
        Node pre,next;

        Node(int key,String value) {
            this.key=key;
            this.value=value;
        }
    }

    public void set(int key,String value) {  // 设置缓存
        Node x=map.get(key);
        removeFromLinkedList(x);  // 删除链表元素
        map.remove(key);  // 删除散列表元素

        if(map.size()==capacity) {  // 到达最大容量是删除表尾元素
            removeFromLinkedList(tail);
        }

        Node y=new Node(key,value);
        insertLinkedList(y);
        map.put(key,y);
    }

    public String get(int key) {  // 获取缓存
        Node x=map.get(key);
        if(x==null) {
            return null;
        }
        if(x!=head) {  // 访问的不是表头元素
            removeFromLinkedList(x);
            insertLinkedList(x);
        }

        return x.value;
    }

    // 移除链表的元素
    private void removeFromLinkedList(Node x) {
        if(x==null) return;

        if(x.pre!=null) x.pre.next=x.next;
        if(x.next!=null) x.next.pre=x.pre;
        if(x==head) head=x.next;
        if(x==tail) tail=x.pre;
    }

    // 插入元素到链表表头
    private void insertLinkedList(Node x) {
        if(head==null) {  //  空链表
            head=x;
            tail=x;
        }
        else {
            x.next=head;
            head.pre=x;
            head=x;
        }
    }

    public static void main(String[] args) {
        LRU lru=new LRU(3);
        if(lru.get(2)==null) {
            lru.set(2, "a");
        }
        if(lru.get(3)==null) {
            lru.set(3, "b");
        }
        if(lru.get(4)==null) {
            lru.set(4, "c");
        }
        System.out.println(lru.head.value);
        System.out.println(lru.tail.value);
    }
}
