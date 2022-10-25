package com.leet.strings;

public class MinRemoveToMakeValid {
    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("(a(b(c)d)"));
    }
    public static String minRemoveToMakeValid(String s) {
        StringBuilder res = new StringBuilder();
        int close=0;
        int openUsed=0;
        //LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==')'){
                close++;
            }
        }
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)>='a' && s.charAt(i)<='z'){
                res = res.append(s.charAt(i));
            }else if (s.charAt(i)=='('){
                if(close>0 && openUsed<close){
                    openUsed++;
                    res = res.append(s.charAt(i));
                }

            }else if(s.charAt(i)==')'){
                if(openUsed>0){
                    res = res.append(s.charAt(i));
                    openUsed--;
                }
                --close;
            }
        }
        return res.toString();

    }


}
