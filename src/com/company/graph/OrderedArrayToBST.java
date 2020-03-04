package com.company.graph;

// 给定一个有序且元素不重复的数组，将其转换成二叉搜索树，要求高度最小
public class OrderedArrayToBST {
    public Node root;

    public void transformArrayToBST(int[] arr) {
        root=put(0,arr.length-1,arr);
    }

    private Node put(int start,int end,int[] arr) {
        int mid=(start+end)/2;   // 获取当前节点的索引
        Node x=new Node(arr[mid]);

        if(end<start) {
            return null;
        }

        x.left = put(start, mid - 1, arr);
        x.right = put(mid + 1, end, arr);
        return x;
    }

    private class Node {
        private int item;
        private Node left,right;

        public Node(int item) {
            this.item=item;
        }
    }

    public static void main(String[] args) {
        int[] arr=new int[]{2,4,6,8,9,10};
        OrderedArrayToBST t=new OrderedArrayToBST();
        t.transformArrayToBST(arr);
        System.out.println(t.root.item);
        System.out.println(t.root.left.item);
        System.out.println(t.root.left.right.item);
        System.out.println(t.root.right.item);
        System.out.println(t.root.right.left.item);
        System.out.println(t.root.right.right.item);
    }
}
