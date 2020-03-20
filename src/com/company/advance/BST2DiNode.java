package com.company.advance;

import com.company.graph.BST;

import java.lang.reflect.Array;
import java.util.ArrayList;

// 二叉搜索树转为双向链表：将节点的左子节点当作链表的前驱节点，右子节点当作链表的后继节点，要求值的顺序保存不变
public class BST2DiNode {
    BST.Node head;
    BST.Node tail;
    public ArrayList<BST.Node> transform(BST bst) {
        ArrayList<BST.Node> arr=new ArrayList<>();
        inOrderTraversal2(bst.root,arr);
        head=arr.get(0);
        tail=arr.get(arr.size()-1);
        for(int i=0;i<arr.size()-1;i++) {
            arr.get(i).right=arr.get(i+1);
            arr.get(i+1).left=arr.get(i);
        }
        return arr;
    }

    private void inOrderTraversal2(BST.Node x,ArrayList<BST.Node> arr) {
        if(x==null) return;

        inOrderTraversal2(x.left,arr);
        arr.add(x);
        inOrderTraversal2(x.right,arr);
    }

    public static void main(String[] args) {
        BST<Integer,String> bst=new BST<>();
        bst.put(4,"a");
        bst.put(2,"b");
        bst.put(6,"c");
        bst.put(5,"d");
        bst.put(9,"e");
        bst.put(8,"f");
        bst.put(12,"g");
        BST2DiNode bst2DiNode=new BST2DiNode();
        bst2DiNode.transform(bst);
        for(BST.Node x=bst2DiNode.head;x!=null;x=x.right) {
            System.out.println(x.key);
        }
    }

}
