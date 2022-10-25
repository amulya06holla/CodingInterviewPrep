package com.leet.strings.hard;

import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("))(("));
    }
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int max=0; int counter=0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    // this is an easy O(n) method
    public int longestValidParen(String s) {
        // Variable to store the longest valid parentheses
        int count = 0;
        // Left counter will count the number of '('
        int left = 0;
        // Right counter will count the number of ')'
        int right = 0;
        // Loop through the string from left to right.
        // This will take care of extra right parentheses
        for (int i = 0; i < s.length(); i++) {
            // Current character
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            }
            if (c == ')') {
                right++;
            }
            // If both left and right are equal,
            // it means we have a valid substring
            if (left == right) {
                count = Math.max(count, left + right);
            }
            // If right is greater than left,
            // it means we need to set both
            // counters to zero
            if (right > left) {
                left = right = 0;
            }
        }
        // Reset left and right
        left = right = 0;
        // Follow the same approach but now loop the string
        // from right to left. This will take care of extra
        // left parentheses
        for (int i = s.length() - 1; i >= 0; i--) {
            // Current character
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            }
            if (c == ')') {
                right++;
            }
            // If both left and right are equal,
            // it means we have a valid substring
            if (left == right) {
                count = Math.max(count, left + right);
            }
            // If right is greater than left,
            // it means we need to set both
            // counters to zero
            if (left > right) {
                left = right = 0;
            }
        }
        return count;
    }
}
