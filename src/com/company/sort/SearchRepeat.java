package com.company.sort;

// 搜寻重复数：给定一个数组，最多包含32000个整数，如果只有4kB内存可用，要求打印所有重复的数
public class SearchRepeat {
    public void searchRepeat(int[] arr) {
        BitSet bitSet=new BitSet(arr.length);
        for(int i:arr) {
            if(!bitSet.get(i)) {
                bitSet.set(i);
            }
            else {
                System.out.println(i);
            }
        }
    }

    private class BitSet{  // 位向量
        private int[] bitSet;
        public BitSet(int size) {
            bitSet=new int[(size>>5)+1];
        }

        public void set(int pos) {  // 设为1
            int index=pos>>5;  // 获取在数组中的索引
            int x=pos%32;
            bitSet[index]=bitSet[index] | (1<<x);
        }

        public boolean get(int pos) {
            int index=pos>>5;
            int x=pos%32;
            return (bitSet[index] & (1<<x))!=0;
        }
    }

    public static void main(String[] args) {
        int[] a=new int[]{12,14,15,16,13,16,10,12,13};
        SearchRepeat s=new SearchRepeat();
        s.searchRepeat(a);
    }
}
