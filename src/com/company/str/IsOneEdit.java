package com.company.str;

// 给定两个字符串，判断一个字符串是否能通过一次操作（插入，删除或者替换一个字符）变成另一个字符串
public class IsOneEdit {
    public static boolean isOneEdit(String str,String str2) {
        boolean flag=true;
        int diff=str.length()-str2.length();
        if(Math.abs(diff)>1) {
            flag=false;
        }
        else if(Math.abs(diff)==1) {
            String max;
            String min;
            if(diff==-1) {
                max=str2;
                min=str;
            }
            else {
                max=str;
                min=str2;
            }

            int diffCount=0;  // 两个字符串不同字符的数量
            for(int i=0;i<min.length();i++) {
                if(diffCount==0) {
                    char cMax = max.charAt(i);
                    char cMin = min.charAt(i);
                    if(cMax!=cMin) diffCount=1;
                }
                else {
                    char cMax = max.charAt(i+1);
                    char cMin = min.charAt(i);
                    if(cMax!=cMin) {
                        flag=false;
                        break;
                    }
                }

            }

        }
        else {
            int diffCount=0;
            for(int i=0;i<str.length();i++) {
                char c=str.charAt(i);
                char c2=str2.charAt(i);
                if(c!=c2) {
                    if(diffCount==1) {
                        flag=false;
                        break;
                    }
                    else {
                        diffCount+=1;
                    }
                }
            }
        }

        return flag;
    }

    public static void main(String[] args) {
        boolean result=isOneEdit("tear","fear");
        System.out.println(result);
    }
}
