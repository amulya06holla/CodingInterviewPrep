package com.leet.strings.medium;
//https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
public class MinAddValidParenthesis {
    public static void main(String[] args) {
        MinAddValidParenthesis t = new MinAddValidParenthesis();
        System.out.println(t.minAddToMakeValid("())))"));
    }
    public int minAddToMakeValid(String s) {
        if(s.isEmpty()) return 0;
        int res =0;
        int close=0, open=0;
        for(int i=0; i<s.length();i++){
            if(s.charAt(i)=='(') {
                open++;
            }
            else {
                if(open==0) {
                    res++;
                }
                else{
                    open--;
                }
            }
        }
        if(open>0) res = res+open;

        return res;
    }
}
