package com.leet.strings.easy;

import java.util.Stack;

//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
public class RemoveAdjDuplicates {

    public String removeDuplicates(String s) {
        String res = "";
        Stack<Character> st = new Stack <>();
        for(int i=0; i<s.length(); i++){
            if(st.isEmpty() || (!st.isEmpty() && st.peek()!=s.charAt(i)))
                st.push(s.charAt(i));
            else
                st.pop();
        }
        while(!st.isEmpty()){
            res = res+st.pop();
        }
        return res;
    }
}
