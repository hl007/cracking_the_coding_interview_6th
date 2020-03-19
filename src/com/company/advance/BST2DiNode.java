package com.company.advance;

import com.company.graph.BST;

import java.lang.reflect.Array;
import java.util.ArrayList;

// 二叉搜索树转为双向链表：将节点的左子节点当作链表的前驱节点，右子节点当作链表的后继节点，要求值的顺序保存不变
public class BST2DiNode {
    public static void transform(BST bst) {
        ArrayList<BST.Node> arr=new ArrayList<>();
        inOrderTraversal2(bst.root,arr);
    }

    private static void inOrderTraversal2(BST.Node x,ArrayList<BST.Node> arr) {
        if(x==null) return;

        inOrderTraversal2(x.left,arr);
        arr.add(x);
        inOrderTraversal2(x.right,arr);
    }

}
