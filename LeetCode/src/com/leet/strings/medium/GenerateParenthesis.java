package com.leet.strings.medium;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/generate-parentheses/

/**
 *
 */
public class GenerateParenthesis {
    public List <String> generateParenthesis(int n) {
        List <String> res = new ArrayList <>();
        backtrack(res, n*2, 0, 0, new StringBuilder());
        return res;
    }

    private void backtrack(List<String> res, int max, int open, int close, StringBuilder cur) {
        if(cur.length()==max){
            res.add(cur.toString());
            return;
        }
        if(open<max/2){
            backtrack(res, max, open+1, close, cur.append("("));
            cur.deleteCharAt(cur.length()-1);
        }
        if(close<open){
            backtrack(res, max, open, close+1, cur.append(")"));
            cur.deleteCharAt(cur.length()-1);
        }
    }
}
