package com.company.stack_queue;

// 动物收容所
public class DogCatQueue {
    private Queue<int[]> qDog;
    private Queue<int[]> qCat;
    private int order;  // 顺序
    private int size;

    public DogCatQueue() {
        qDog=new Queue<>();
        qCat=new Queue<>();
        order=0;
        size=0;
    }

    public void enqueue(int[] item) {
        if(item[0]==0) qDog.enqueue(new int[]{item[1],order});
        else           qCat.enqueue(new int[]{item[1],order});
        order++;
        size++;
    }

    public int dequeueAny() {
        size--;

        if(qDog.size()==0) {
            if(qCat.size()==0) {
                throw new IllegalArgumentException("队列为空");
            }
            else {
                return qCat.dequeue()[0];
            }
        }
        else if(qCat.size()==0) {
            return qDog.dequeue()[0];
        }
        else {
            int[] dogItem = qDog.getFirstItem();
            int[] catItem = qCat.getFirstItem();
            if (dogItem[1] < catItem[1]) {
                qDog.dequeue();
                return dogItem[0];
            } else {
                qCat.dequeue();
                return catItem[0];
            }
        }
    }

    public int dequeueDog() {
        if(qDog.size()==0) throw new IllegalArgumentException("狗队列为空");

        size--;
        return qDog.dequeue()[0];
    }

    public int dequeueCat() {
        if(qCat.size()==0) throw new IllegalArgumentException("猫队列为空");

        size--;
        return qCat.dequeue()[0];
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        DogCatQueue dc=new DogCatQueue();
        dc.enqueue(new int[]{0,4});
        dc.enqueue(new int[]{1,6});
        dc.enqueue(new int[]{1,31});
        dc.enqueue(new int[]{0,22});
        dc.enqueue(new int[]{1,23});

        while(dc.qCat.size()>0) {
            System.out.println(dc.dequeueCat());
        }
    }

}
