package com.leet.strings.easy;
//https://leetcode.com/problems/valid-palindrome-ii/
public class ValidPalindrome2 {
    public boolean validPalindrome(String s) {
        return isPalindromeWithChance(s, 0, s.length()-1, 1);
    }

    private boolean isPalindromeWithChance(String s, int i, int j, int chance) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                if (chance-- == 0) return false;
                return isPalindromeWithChance(s, i+1, j, chance) || isPalindromeWithChance(s, i, j-1, chance);
            }
            i++;
            j--;
        }
        return true;
    }
}
