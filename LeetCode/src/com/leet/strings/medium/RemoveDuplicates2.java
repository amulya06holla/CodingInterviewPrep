package com.leet.strings.medium;

import java.util.HashMap;
import java.util.Stack;

//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
public class RemoveDuplicates2 {
    public static void main(String[] args) {
        RemoveDuplicates2 rd = new RemoveDuplicates2();
        System.out.println(rd.removeDuplicates("yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy", 4));
    }
    // note : we are storing counts of elements and not the element itself in the stack.
        public String removeDuplicates(String s, int k) {
            StringBuilder sb = new StringBuilder(s);
            Stack<Integer> counts = new Stack<>();
            for (int i = 0; i < sb.length(); ++i) {
                if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                    counts.push(1);
                } else {
                    int incremented = counts.pop() + 1;
                    if (incremented == k) {
                        sb.delete(i - k + 1, i + 1);
                        i = i - k;
                    } else {
                        counts.push(incremented);
                    }
                }
            }
            return sb.toString();
        }

        // DynamicProgramming way
    public String removeDuplicatesMemoise(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int count[] = new int[sb.length()];
        for (int i = 0; i < sb.length(); ++i) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                count[i] = 1;
            } else {
                count[i] = count[i - 1] + 1;
                if (count[i] == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                }
            }
        }
        return sb.toString();
    }
}
