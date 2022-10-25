package com.leet.dds;
//https://leetcode.com/problems/buddy-strings/solution/
public class BuddyString {
    public boolean buddyStrings(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        // there can be 2 cases. one when both strings are equal and one when they are not equal
        // when 2 strings are equal, ex: "aa" and "aa" which should return true  OR "ab" and "ab" which should return false.
        // we are hence counting the characters. if any of the characters appears more than once, that means it should return true.
        if (s.equals(goal)) {
            int[] count = new int[26];
            for (int i = 0; i < s.length(); ++i)
                count[s.charAt(i) - 'a']++;

            for (int c: count)
                if (c > 1) return true;
            return false;
        }else {
            // here we need to find if 2 characters are different. and exactly 2 has to be different. more than 2 should return false.
            int first = -1, second = -1;
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) != goal.charAt(i)) {
                    if (first == -1)
                        first = i;
                    else if (second == -1)
                        second = i;
                    else
                        return false;
                }
            }

            // here we are seeing if first and second both are not -1.
            // by checking second !=-1 we have also indirectly checked if first!=-1/
            // also the characters that are different should be in each other's position in the next string.
            //for example: "ac" and "ca". a is in c's location and c is in a's location. only then it should be true.
            return (second != -1 && s.charAt(first) == goal.charAt(second) &&
                    s.charAt(second) == goal.charAt(first));
        }
    }

    public static void main(String[] args) {
        BuddyString bs = new BuddyString();
        System.out.println(bs.buddyStrings("aba", "abaa"));
    }
}
