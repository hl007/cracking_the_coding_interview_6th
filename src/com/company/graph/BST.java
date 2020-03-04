package com.company.graph;

import java.util.ArrayList;
import java.util.NoSuchElementException;


// 二叉查找树，每个结点含有一个键值对，一个左子结点的引用，一个右子结点的引用，一个结点计数器
// 每个结点的键大于左子树的所有结点而小于右子树的所有结点
public class BST<Key extends Comparable<Key>,Value> implements OrderedSymbolTable<Key,Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int size;

        public Node(Key key,Value val,int size) {
            this.key=key;
            this.val=val;
            this.size=size;
        }
    }

    public BST(){

    }

    @Override
    public Value get(Key key) {
        return get(root,key);
    }

    private Value get(Node x,Key key) {
        if (key == null) throw new IllegalArgumentException("key不能为空");
        if (x==null) return null;  // 未命中

        int cmp=key.compareTo(x.key);
        if (cmp<0) return get(x.left,key);
        else if (cmp>0) return get(x.right,key);
        else return x.val;
    }


    @Override
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("key不能为空");
        if (val==null) {
            delete(key);
            return;
        }

        root=put(root,key,val);
    }

    private Node put(Node x,Key key,Value val) {
        if (x == null) return new Node(key, val, 1);  // 如果为空，创建新结点直接返回

        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);  // 如果key小于结点的key（未命中），则在他的左子树查找，返回时再更新子结点链接（主要用于插入新结点时）
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;  // 命中

        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("key不能为空");
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x==null) return 0;
        else return x.size;
    }


    @Override
    public int size(Key lo, Key hi) {
        if (lo == null || hi == null) throw new IllegalArgumentException("key不能为空");

        if (lo.compareTo(hi) > 0) return 0;
        if(contains(hi)) return rank(hi)-rank(lo)+1;
        else return rank(hi)-rank(lo);
    }

    @Override
    public Iterable<Key> keys() {
        return keys(min(),max());
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null || hi == null) throw new IllegalArgumentException("key不能为空");

        Queue<Key> queue = new Queue<Key>();
        if (lo.compareTo(hi) > 0) return queue;
        for (int i=rank(lo);i<rank(hi);i++) {
            queue.enqueue(select(i));
        }
        if (contains(hi)) queue.enqueue(hi);

        return queue;
    }

    @Override
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("表为空，无法调用");
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left==null) return x;
        else return min(x.left);
    }

    @Override
    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("表为空，无法调用");
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right==null) return x;
        else return max(x.right);
    }


    @Override
    public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException("key不能为空");

        int k=rank(key);
        if (contains(key)) return key;  // 命中

        // 未命中
        if (k==0) return null;
        else return select(k-1);
    }

    @Override
    public Key ceiling(Key key) {
        if (key == null) throw new IllegalArgumentException("key不能为空");

        int k=rank(key);
        return select(k);
    }

    @Override
    public int rank(Key key) {
        if (key == null) throw new IllegalArgumentException("key不能为空");
        return rank(root,key);
    }

    private int rank(Node x,Key key) {
        if (x==null) return 0;

        int cmp=key.compareTo(x.key);
        if (cmp<0) return rank(x.left,key);
        else if (cmp>0) return size(x.left)+1+rank(x.right,key);
        else return size(x.left);
    }

    @Override
    public Key select(int k) {
        if (k<0 || k>=size()) throw new IllegalArgumentException("key值无效");

        Node x=select(root,k);
        return x.key;
    }

    private Node select(Node x,int k) {
        if (x==null) return null;

        int t=size(x.left);
        if (k<t) return select(x.left,k);
        else if (k>t) return select(x.right,k-t-1);
        else return x;
    }

    @Override
    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("表为空，无法调用");
        root=deleteMin(root);
    }

    private Node deleteMin(Node x) {  // 不断深入该结点的左子树，直至遇到一个结点的左子树是空链接（返回这个结点的右链接）
        if (x.left==null) return x.right;

        x.left=deleteMin(x.left);
        x.size=size(x.left)+size(x.right)+1;
        return x;
    }

    @Override
    public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException("表为空，无法调用");
        root=deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if (x.right==null) return x.left;

        x.right=deleteMax(x.right);
        x.size=size(x.left)+size(x.right)+1;
        return x;
    }

    @Override
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("key不能为空");
        root=delete(root,key);
    }


    private Node delete(Node x,Key key) {
        if (x==null) return null;

        int cmp=key.compareTo(x.key);
        if (cmp<0) x.left=delete(x.left,key);
        else if (cmp>0) x.right=delete(x.right,key);
        else {  // 命中
            // 删除结点只有一个子结点
            if (x.left==null) return x.right;
            if (x.right==null) return x.left;
            // 删除结点只有两个子结点
            Node temp=x;
            x=min(temp.right);  // 用删除结点的右子树的最小结点代替删除结点，作为新结点
            x.left=temp.left;   // 新结点的左子结点指向删除结点的左子树
            x.right=deleteMin(temp.right);  // 新结点的右子结点指向删除了最小值的右子树
        }

        x.size=size(x.left)+size(x.right)+1;
        return x;
    }

    // 从左向右遍历数组插入树中，可生成二叉搜索树。给定一棵二叉搜索树，输出所有能生成此树的数组
    public int[][] arraysOfBST() {
        return null;
    }


    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<Integer, String>();
        bst.put(2, "a");
        bst.put(4, "b");
        bst.put(3, "c");
        bst.put(3, "f");
        bst.put(11, "d");
        bst.put(1, "g");
        bst.put(9, "h");
        bst.put(0, "w");
    }

}
