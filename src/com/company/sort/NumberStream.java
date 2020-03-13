package com.company.sort;

// 数字流的轶：读取一串整数，每读入一个数执行track()方法，getRankOfNumber()返回该数字的排名
public class NumberStream {  // 二叉搜索树，左子节点<=x<右子节点
    private Node root;

    private class Node{
        int val;
        int size;
        Node left,right;
        Node(int val,int size) {
            this.val=val;
            this.size=size;
        }
    }

    public int size(Node x) {
        if(x==null) return 0;
        else        return x.size;
    }

    public void track(int val) {  // 插入
        root=insert(root,val);
    }

    private Node insert(Node x,int val) {
        if(x==null) {
            return new Node(val,1);  // 插入
        }

        if(val==x.val)  {  // 相等
            Node same=new Node(val,size(x.left)+1);
            same.left=x.left;
            x.left=same;
        }
        else if(val<x.val) {  // 左子树
            x.left=insert(x.left,val);
        }
        else {
            x.right=insert(x.right,val);  // 右子树
        }

        x.size=size(x.left)+size(x.right)+1;

        return x;
    }

    public int getRankOfNumber(int val) {
        return getRankOfNumberHelper(root,val);
    }

    private int getRankOfNumberHelper(Node x,int val) {
        if(x==null) return 0;

        if(val<x.val) return getRankOfNumberHelper(x.left,val);
        else if(val>x.val) return size(x.left)+1+getRankOfNumberHelper(x.right,val);
        else return size(x.left);
    }

    public static void main(String[] args) {
        NumberStream s=new NumberStream();
        s.track(7);
        s.track(4);
        s.track(9);
        s.track(3);
        s.track(6);
        s.track(8);
        s.track(10);
        s.track(4);
        System.out.println(s.getRankOfNumber(6));
    }

}
