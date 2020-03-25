package com.company.advance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// 给定一个长字符串和一个单词列表，在长字符串中搜索单词
public class SearchWord {
    public static HashMap<String, ArrayList<Integer>> searchWord(String a,String[] b) {
        // 构造单词查找树
        TrieST tst=new TrieST();
        for(String s:b) {
            tst.put(s);
        }
        HashMap<String,ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<a.length();i++) {
            int pos=i;
            TrieST.Node x=tst.root.next[a.charAt(i)];
            while(x!=null) {
                if(x.isEnd) {
                    String p=a.substring(i,pos+1);
                    if(map.containsKey(p)) {
                        map.get(p).add(i);
                    }
                    else {
                        ArrayList<Integer> arr=new ArrayList<>();
                        arr.add(i);
                        map.put(p,arr);
                    }
                }

                pos++;
                if(pos<a.length()) {
                    x = x.next[a.charAt(pos)];
                }
                else {
                    break;
                }
            }
        }

        return map;
    }

    public static void main(String[] args) {
        String a="itistestismoreit";
        String[] b=new String[]{"it","is","test","more","none","i"};
        System.out.println(searchWord(a,b));
    }
}

class TrieST {  // 单词查找树
    Node root;

    class Node {
        Node[] next=new Node[128];
        boolean isEnd;  // 是否是单词结尾
    }

    public void put(String key) {
        root=put(root,key,0);
    }

    private Node put(Node x,String key,int d) {
        if(x==null) x=new Node();

        if(d==key.length()) {
            x.isEnd=true;
        }
        else {
            char c=key.charAt(d);
            x.next[c]=put(x.next[c],key,d+1);
        }
        return x;
    }

}


