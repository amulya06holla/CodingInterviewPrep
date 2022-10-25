package com.leet.Apple.medium;
//https://leetcode.com/problems/valid-parenthesis-string/discuss/107570/JavaC%2B%2BPython-One-Pass-Count-the-Open-Parenthesis
public class CheckValidParenthesis {
    public boolean checkValidString(String s) {
        int cmin = 0, cmax = 0;
        // cmax counts the max number of parenthesis that COULD be matched with ).
        // cmin counts the min number of parenthesis that SHOULD DEFINITELY be matched with ).
        // cmin is decremented in all cases except when we encounter open braces.
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                cmax++;
                cmin++;
            } else if (c == ')') {
                cmax--;
                cmin = Math.max(cmin - 1, 0);
            } else {
                cmax++;
                cmin = Math.max(cmin - 1, 0);
            }
            if (cmax < 0) return false; // at any point if open brackets are less than 0, then that implies that close brackets are more than open already and hence no point in further looping.
        }
        return cmin == 0;
    }
}
