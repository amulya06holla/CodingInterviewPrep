package com.leet.uber.medium;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/generate-parentheses/
// TC: is related to catalan number. check leetcode solution link
public class GenerateParenthesis {

        public List <String> generateParenthesis(int n) {
            List<String> ans = new ArrayList();
            backtrack(ans, new StringBuilder(), 0, 0, n);
            return ans;
        }

        public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
            if (cur.length() == max * 2) {
                ans.add(cur.toString());
                return;
            }

            if (open < max) { // check if open is less than max
                cur.append("(");
                backtrack(ans, cur, open+1, close, max);
                cur.deleteCharAt(cur.length() - 1);
            }
            if (close < open) { // BUT check if close is less than open
                cur.append(")");
                backtrack(ans, cur, open, close+1, max);
                cur.deleteCharAt(cur.length() - 1);
            }
        }

}
