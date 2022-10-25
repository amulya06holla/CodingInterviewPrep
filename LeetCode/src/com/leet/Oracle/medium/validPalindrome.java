package com.leet.Oracle.medium;
//https://leetcode.com/problems/valid-palindrome/
public class validPalindrome {
    public boolean isPalindrome(String s) {
        int i=0, j=s.length()-1;
        while(i<=j){
            if(!Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            if(!Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            if(Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j))) {
                System.out.println(i+ " "+j);
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    //https://leetcode.com/problems/valid-palindrome-ii/
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
