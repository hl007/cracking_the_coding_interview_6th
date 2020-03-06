package com.company.graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

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
    public Node getFirstAncestor(Node x,Node y) {
        if(!cover(root,x) || !cover(root,y)) {  // 如果节点不在树中，返回
            return null;
        }
        return ancestorHelper(root,x,y);
    }

    private Node ancestorHelper(Node root,Node x,Node y) {
        if(root==null || root==x || root==y) {
            return root;
        }

        boolean xIsOnLeft=cover(root.left,x);  // 节点x是否在root左边
        boolean yIsOnLeft=cover(root.left,y);  // 节点y是否在root左边
        if(xIsOnLeft!=yIsOnLeft) {  // x,y在root两边
            return root;
        }
        else {
            Node childdNode=xIsOnLeft?root.left:root.right;
            return ancestorHelper(childdNode,x,y);
        }
    }

    //断root和x是否在一条链上
    private boolean cover(Node root,Node x) {
        if(root==null) return false;
        if(root==x) return true;

        return cover(root.left,x) || cover(root.right,x);
    }


    // 给定一个值，输出节点和等于该值的所有路径
    public ArrayList<Stack<Node>> pathsEqualValue(int val) {
        HashMap<Node,Node> edgeTo=new HashMap<>();
        HashMap<Node,Integer> distanceTo=new HashMap<>();  // 每个节点到根节点的距离

        ArrayList<Node> arr=new ArrayList<>();
        inOrderTraversal2(root,arr);

        // 广度优先搜索
        Queue<Node> q=new Queue<>();
        q.enqueue(root);
        distanceTo.put(root,0);
        while(!q.isEmpty()) {
            Node x=q.dequeue();
            if(x.left!=null) {
                distanceTo.put(x.left,distanceTo.get(x)+1);
                edgeTo.put(x.left,x);
                q.enqueue(x.left);
            }
            if(x.right!=null) {
                distanceTo.put(x.right,distanceTo.get(x)+1);
                edgeTo.put(x.right,x);
                q.enqueue(x.right);
            }
        }

        // 计算距离
        ArrayList<Stack<Node>> pathArr=new ArrayList<>();
        for(Node x:arr) {
            int sum=0;
            Stack<Node> s=new Stack<>();
            Node y;
            for(y=x;distanceTo.get(y)!=0;y=edgeTo.get(y)) {
                sum+=y.item;
                s.push(y);
                if(sum==val) {
                    System.out.println("sum: "+sum);
                    pathArr.add((Stack)s.clone());
                }
            }

            sum+=y.item;
            s.push(y);
            if(sum==val) {
                System.out.println("sum2: "+sum);
                pathArr.add((Stack)s.clone());
            }
        }

        return pathArr;
    }

    // 获取该二叉树的所有节点
    private void inOrderTraversal2(Node x,ArrayList<Node> arr) {
        if(x==null) return;

        inOrderTraversal2(x.left,arr);
        arr.add(x);
        inOrderTraversal2(x.right,arr);
    }

    // 给定一棵几百万节点的二叉树t1，一棵几百节点的二叉树t2，判断t2是否是t1的子树
    // 前序遍历结果相同的两棵树为同一棵树（只有一个子节点，需标记另一个空节点），
    public boolean isSonOfAnother(Node x) {
        StringBuilder s=new StringBuilder();
        StringBuilder s2=new StringBuilder();

        specialPreOrderTraversal(root,s);
        specialPreOrderTraversal(x,s2);

        System.out.println(s);
        System.out.println("another: "+s2);
        return s2.toString().contains(s.toString());  // 通过是否为子字符串判断
    }

    private void specialPreOrderTraversal(Node x,StringBuilder s) {
        if(x==null) {
            s.append("x");
            return;
        }

        s.append(x.item);
        specialPreOrderTraversal(x.left,s);
        specialPreOrderTraversal(x.right,s);
    }

    public static void main(String[] args) {
        BinaryTree bt=new BinaryTree(5);
        Node n2=bt.putLeft(bt.root,2);
        Node n3=bt.putRight(bt.root,8);
        Node n4=bt.putLeft(n3,7);
        Node n5=bt.putRight(n3,18);
        Node n6=bt.putLeft(n4,12);
        Node n7=bt.putLeft(n2,1);

        ArrayList<Stack<Node>> arr=bt.pathsEqualValue(8);
        for(Stack<Node> s:arr) {
            while(!s.empty()) {
                System.out.print(s.pop().item+"->");
            }
            System.out.println();
        }
    }
}
