package com.company.stack_queue;

// 动物收容所
public class DogCatQueue {
    Queue<int[]> q;
    Queue<int[]> qDog;
    Queue<int[]> qCat;

    public DogCatQueue() {
        q=new Queue<>();
        qDog=new Queue<>();
        qCat=new Queue<>();
    }

    public void enqueue(int[] item) {
        if(item[0]==0) qDog.enqueue(item);
        else           qCat.enqueue(item);
        q.enqueue(item);
    }

    public int dequeueAny() {
        int[] t=q.dequeue();
        if(t[0]==0) qDog.dequeue();
        else        qCat.dequeue();
        return t[1];
    }

//    public int dequeueDog() {
//
//    }

    public int dequeueCat() {
        return 0;
    }

}
