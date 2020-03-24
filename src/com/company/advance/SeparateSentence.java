package com.company.advance;

import java.util.HashSet;

// 给定一个长字符串和字符串数组，将长字符串断开，使得不能被字符串数组识别的字符最少。
// 方法：选择第一个空格插入的位置，然后递归的选择第二个空格插入的位置，以此类推，直到处理完整个字符串
public class SeparateSentence {
    public static String separateSentence(HashSet<String> set,String sentence) {
        ParseResult[] mem=new ParseResult[sentence.length()];  // 对分割结果进行缓存

        ParseResult r=split(set,sentence,0,mem);
        return r==null?null:r.parsed;
    }

    private static ParseResult split(HashSet<String> set,String sentence,int start,ParseResult[] mem) {  // 在字符串的某个位置插入空格进行分割
        if(start>=sentence.length()) {  // 到字符串末尾
            return new ParseResult(0,"");
        }

        if(mem[start]!=null) return mem[start];

        int bestValid=Integer.MAX_VALUE;
        String bestParsing=null;
        String partial="";
        int index=start;
        while(index<sentence.length()) {
            char c=sentence.charAt(index);
            partial+=c;
            int invalid=set.contains(partial)?0:partial.length();
            if(invalid<bestValid) {  // 发现更少的无效字符
                ParseResult r=split(set,sentence,index+1,mem);  // 插入下一个空格
                if(invalid+r.invalid<bestValid) {  // 空格左边的无效字符+空格右边的无效字符
                    bestValid=invalid+r.invalid;
                    bestParsing=partial+" "+r.parsed;
                }
                if(bestValid==0) break;  // 如果找到没有无效字符的分割方法，则退出循环
            }
            index++;
        }

        mem[start]=new ParseResult(bestValid,bestParsing);
        return mem[start];
    }

    public static class ParseResult {  // 解析结果
        public int invalid=Integer.MAX_VALUE;  // 无效的字符数
        public String parsed=" ";  // 解析结果

        public ParseResult(int invalid,String parsed) {
            this.invalid=invalid;
            this.parsed=parsed;
        }
    }


    public static void main(String[] args) {
        String s="itisatestandveryinteresting";
        HashSet<String> set=new HashSet<>();
        set.add("interesting");
        set.add("is");
        set.add("test");
        set.add("it");
        set.add("very");
        System.out.println(separateSentence(set,s));
    }
}
