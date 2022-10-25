package com.leet.strings.easy;

import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses/
public class ValidParentheses {
    public static void main(String[] args) {

    }
    public boolean isValid(String s) {
        Stack<Character> st = new Stack <>();
        for(int i=0; i<s.length();i++){
            Character t =s.charAt(i);
            if(t=='(' || t=='{'|| t=='['){
                st.push(t);
            }else{
                if(st.isEmpty()) return false;
                Character stackPeek = st.peek();
                if(t==')' && !st.isEmpty() && stackPeek.equals('(')) {
                    st.pop();
                }else if(t==')' && (st.isEmpty()|| !stackPeek.equals('('))) {
                    st.push(t);
                }
                if(t==']' && !st.isEmpty() && stackPeek.equals('[')) {
                    st.pop();
                }else if(t==']' && (st.isEmpty()|| !stackPeek.equals('['))) {
                    st.push(t);
                }
                if(t=='}' && !st.isEmpty() && stackPeek.equals('{')) {
                    st.pop();
                }else if(t=='}' && (st.isEmpty()|| !stackPeek.equals('{'))) {
                    st.push(t);
                }
            }
        }
        if(st.isEmpty()) return true;
        else return false;
    }
}
