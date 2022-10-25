package com.leet.LinkedIn.medium;

import java.util.Stack;

//https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/

// REF: //https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/


public class MinInsertionsBalancedParanthesis {
    public static void main(String[] args) {
        MinInsertionsBalancedParanthesis t = new MinInsertionsBalancedParanthesis();
        System.out.println(t.minInsertions("()())))()"));
    }
    public int minInsertions(String s) {
        int open=0;
        int res=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                open++;
            }
            else{
                if(i+1<s.length() && s.charAt(i+1)==')'){
                    i++;
                    if(open==0) {
                        res++;
                    }
                    else{
                        open--;
                    }
                }
                else{
                    if(open>0){
                        open--;
                        res++;
                    }
                    else{
                        res+=2;
                    }
                }
            }
        }
        res+=2*open;
        return res;
    }
}
