package com.leet.strings.hard;
//https://leetcode.com/problems/reverse-words-in-a-string/

/**
 * NOTE: WE CAN ALSO SOLVE THE PROBLEM USING ARRAYDEQUEUE. CHECK FOR ANSWER IN  THE LEET LINK.
 */
public class ReverseWords {
    public String reverseWords(String s) {
        StringBuilder rev = new StringBuilder();
        int end = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            if (s.charAt(i) != ' ') {
                end = i;
                i = s.lastIndexOf(' ', end);
                rev.append(s.substring(i + 1, end + 1)).append(' ');
            }
        }
        return rev.toString().trim();
    }
}
