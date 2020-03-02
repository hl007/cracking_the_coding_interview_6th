package com.company.stack_queue;

public class Queue<Item> {
    private Node first; //指向最早添加的结点的链接,队头（表尾）
    private Node last; //指向最近添加的结点的链接，队尾（表头）
    private int N;
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



    public static void main(String[] args) {
        Queue<String> q = new Queue<>();
        q.enqueue("d");
        q.enqueue("c");
        q.enqueue("a");
        if (!q.isEmpty()) System.out.println(q.dequeue() + " ");
    }

}
