package com.leet.uber.easy;

import java.util.ArrayDeque;

//https://leetcode.com/problems/implement-strstr/submissions/
public class StrstrImpl {
    public int strStr(String haystack, String needle) {

        if (needle.isEmpty())
            return 0;

        // start iterating over the haystack (starting from 0 but end early to leave room for the tail end of the needle)
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {

            // start comparing the characters in the needle to the current view of the haystack
            // going in reverse allows you to exit early
            for (int j = needle.length() - 1; j >= 0; j--) {

                if (haystack.charAt(i+j) != needle.charAt(j)) // if at any point they dont equal we can break
                    break;

                if (j == 0) // if we reached the first/last char comparison without a break they must be equal
                    return i;
            }

        }
        return - 1; // iterated over the whole haystack, breaking every time on the inner loop
    }
}
