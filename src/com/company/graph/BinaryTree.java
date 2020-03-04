package com.company.graph;

import java.util.ArrayList;

// 二叉树
public class BinaryTree {
    private Node root;
    private int N;

    public BinaryTree(int ele) {
        root=new Node(ele);
    }

    private class Node {
        private int item;
        private Node left;
        private Node right;

        public Node(int item) {
            this.item=item;
        }
    }

    public Node putLeft(Node x,int ele) {
        if(x==null) throw new IllegalArgumentException("该节点为空");

        x.left=new Node(ele);
        N++;
        return x.left;
    }

    public Node putRight(Node x,int ele) {
        if(x==null) throw new IllegalArgumentException("该节点为空");

        x.right=new Node(ele);
        N++;
        return x.right;
    }

    public int size() {
        return N;
    }

    // 获取某一层的所有节点（广度优先搜索）
    public ArrayList<Queue<Node>> getOneFloorNodesByBFS() {
        ArrayList<Queue<Node>> arr=new ArrayList<>();

        // 初始化
        Queue<Node> current=new Queue<>();
        current.enqueue(root);
        arr.add(current);

        while(!current.isEmpty()) {
            Queue<Node> parents=current;
            current=new Queue<>();
            for(Node x:parents) {
                if(x.left!=null) {
                    current.enqueue(x.left);
                }
                if(x.right!=null) {
                    current.enqueue(x.right);
                }
            }
            arr.add(current);
        }
        return arr;
    }

    //  获取某一层的所有节点（深度优先搜索）
    public ArrayList<Queue<Node>> getOneFloorNodesByDFS() {
        ArrayList<Queue<Node>> arr=new ArrayList<>();
        getOneFloorNodes(0,root,arr);

        return arr;
    }

    public void getOneFloorNodes(int level,Node x,ArrayList<Queue<Node>> arr) {
        if(x==null) return;

        Queue<Node> current;
        if(arr.size()==level) {
            current=new Queue<>();
            arr.add(current);
        }
        else {
            current=arr.get(level);
        }
        current.enqueue(x);
        getOneFloorNodes(level+1,x.left,arr);
        getOneFloorNodes(level+1,x.right,arr);
    }

    // 检查树的平衡性：任意节点两棵子树的高度差不超过1
    public boolean isBalance() {
        Queue<Node> qMain=new Queue<>();
        qMain.enqueue(root);
        while(!qMain.isEmpty()) {
            Node x=qMain.dequeue();
            if(x.left!=null) qMain.enqueue(x.left);
            if(x.right!=null) qMain.enqueue(x.right);

            int heightLeft=getHeight(x.left);
            int heightRight=getHeight(x.right);

            if(Math.abs(heightLeft-heightRight)>1) {
                return false;
            }
        }
        return true;
    }

    // 获取一棵树的高度
    public int getHeight(Node x) {
        if(x==null) return 0;

        int heightLeft=getHeight(x.left);
        int heightRight=getHeight(x.right);
        return Math.max(heightLeft,heightRight)+1;
    }

    // 判断是否为二叉搜索树：中序遍历
    public boolean isBSTByInOrderTraversal() {
        ArrayList<Integer> arr=new ArrayList<>();
        inOrderTraversal(root,arr);
        System.out.println(arr);
        for(int i=0;i<arr.size()-1;i++) {
            if(arr.get(i)>=arr.get(i+1)) {
                return false;
            }
        }
        return true;
    }

    private void inOrderTraversal(Node x,ArrayList<Integer> arr) {
        if(x==null) return;

        inOrderTraversal(x.left,arr);
        arr.add(x.item);
        inOrderTraversal(x.right,arr);
    }

    // 找出两个节点的首个共同祖先
    public Node firstAncestor(Node x,Node y) {
        return null;
    }

    // 给定一个值，输出节点和等于该值的所有路径
    public Queue<Node>[] paths() {
        return null;
    }


    public static void main(String[] args) {
        BinaryTree bt=new BinaryTree(5);
        Node n2=bt.putLeft(bt.root,2);
        Node n3=bt.putRight(bt.root,8);
        Node n4=bt.putLeft(n3,7);
        Node n5=bt.putRight(n3,18);
        Node n6=bt.putLeft(n4,12);

        System.out.println(bt.isBSTByInOrderTraversal());
//        for(Queue<Node> q:arr) {
//            for(Node x:q) {
//                System.out.print(x.item+"\t");
//            }
//            System.out.println();
//        }

    }
}
