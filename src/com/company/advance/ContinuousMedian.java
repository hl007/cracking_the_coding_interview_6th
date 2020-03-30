package com.company.advance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

// 连续随机产生一个数，每次产生时返回所有值的中间值并保存
public class ContinuousMedian {
    public static ArrayList<Double> continuousMedian() {
        ArrayList<Double> arr=new ArrayList<>();

        Random r=new Random();
        MaxHeap maxHeap=new MaxHeap(501);
        MinHeap minHeap=new MinHeap(501);
        for(int i=0;i<10;i++) {
            int x=r.nextInt(50);
            System.out.println("x: "+x);
            dealWith(x,maxHeap,minHeap,arr);
        }
        return arr;
    }

    public static void dealWith(int x,MaxHeap maxHeap,MinHeap minHeap,ArrayList<Double> arr) {
        if(maxHeap.size==0) {  // 第一个元素
            arr.add((double)x);
            maxHeap.insert(x);
            return;
        }

        if(x<=arr.get(arr.size()-1)) {  // 与之前的中间值比较
            maxHeap.insert(x);
        }
        else {
            minHeap.insert(x);
        }

        if(maxHeap.size-minHeap.size==2) {  // 如果最大堆的个数超过了最小堆两个
            int p=maxHeap.deleteMax();
            minHeap.insert(p);
        }
        else if(minHeap.size-maxHeap.size==1)  {  // 如果最小堆个数超过最大堆
            int p=minHeap.deleteMin();
            maxHeap.insert(p);
        }

        if(maxHeap.size==minHeap.size+1) {
            arr.add((double)maxHeap.max());
        }
        else {
            double median=(double)(maxHeap.max()+minHeap.min())/2;
            arr.add(median);
        }

    }

    public static void main(String[] args) {
        System.out.println(continuousMedian());
    }
}

class MaxHeap {  // 最大堆
    int size;  // 堆大小
    int[] arr;  // 存储堆的数组

    MaxHeap(int MaxN) {
        arr=new int[MaxN+1];
    }

    public int max() {
        if(size==0) throw new IllegalArgumentException("此堆中没有元素");

        return arr[1];
    }

    public void insert(int k) {
        arr[size+1]=k;
        size++;
        swim(size);
    }

    public int deleteMax() {
        if(size==0) throw new IllegalArgumentException("此堆中没有元素");

        int max=arr[1];
        swap(1,size);
        size--;
        sink(1);
        return max;
    }

    public void swim(int x) {  // 上浮
        while(x>1 && arr[x]>arr[x/2]) {
            swap(x,x/2);
            x=x/2;
        }
    }

    public void sink(int k) {  // 下沉
        while(2*k<=size) {
            int j=2*k;  // 左子节点
            if(j<size && arr[j+1]>arr[j]) j++;

            if(arr[k]>arr[j]) {
                break;
            }
            else {
                swap(k, j);  //与较大的子节点交换
            }
            k=j;
        }
    }

    public void swap(int x,int y) {
        int temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }

}

class MinHeap {  // 最小堆
    int size;  // 堆大小
    int[] arr;  // 存储堆的数组

    MinHeap(int MaxN) {
        arr=new int[MaxN+1];
    }

    public int min() {
        if(size==0) throw new IllegalArgumentException("此堆中没有元素");

        return arr[1];
    }

    public int deleteMin() {
        if(size==0) throw new IllegalArgumentException("此堆中没有元素");

        int min=arr[1];
        swap(1,size);
        size--;
        sink(1);
        return min;
    }

    public void insert(int k) {
        arr[size+1]=k;
        size++;
        swim(size);
    }

    public void swim(int x) {  // 上浮
        while(x>1 && arr[x]<arr[x/2]) {
            swap(x,x/2);
            x=x/2;
        }
    }

    public void sink(int k) {  // 下沉
        while(2*k<=size) {
            int j=2*k;  // 左子节点
            if(j<size && arr[j+1]<arr[j]) j++;

            if(arr[k]<arr[j]) {
                break;
            }
            else {
                swap(k, j);  //与较大的子节点交换
            }
            k=j;
        }
    }

    public void swap(int x,int y) {
        int temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }
}