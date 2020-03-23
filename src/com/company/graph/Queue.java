package com.company.graph;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
    private Node first; //指向最早添加的结点的链接,队头（表尾）
    private Node last; //指向最近添加的结点的链接，队尾（表头）
    private int N;

    @Override
    public Iterator iterator() {
        return new QueueIterator(first);
    }

    private class QueueIterator implements Iterator {
        private Node current;

        public QueueIterator(Node first) {
            current=first;
        }

        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Item next() {
            if(!hasNext()) throw new IllegalArgumentException("队列为空");

            Item item=current.item;
            current=current.next;
            return item;
        }
    }

    private class Node{
        Item item;
        Node next;
    }
    public boolean isEmpty(){
        return first==null;
    }
    public int size(){
        return N;
    }
    public void enqueue(Item item){
        Node oldlast=last;
        last=new Node();
        last.item=item;
        last.next=null;
        if(isEmpty()) first=last;
        else oldlast.next=last;
        N++;
    }
    public Item dequeue(){
        Item item=first.item;
        first=first.next;
        if(isEmpty()) last=null;
        N--;
        return item;
    }

    public Item getFirstItem() {
        return first.item;
    }

    public Item head() {
        return first.item;
    }

    public Item tail() {
        return last.item;
    }

    public boolean contains(Item item) {
        for(Node x=first;x!=null;x=x.next){
            if(x.item.equals(item)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Queue<String> q = new Queue<>();
        q.enqueue("d");
        q.enqueue("c");
        q.enqueue("a");
        if (!q.isEmpty()) System.out.println(q.dequeue() + " ");
    }

}
