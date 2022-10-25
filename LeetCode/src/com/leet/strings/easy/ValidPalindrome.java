package com.leet.strings.easy;

import java.util.Locale;

/**
 * use Character class in Java
 * or use regex if you remember. replace all special characters, space and also make the alphabets to lower case. at once.
 */
//https://leetcode.com/problems/valid-palindrome/
public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        System.out.println(vp.isPalindrome("race a car"));
    }

        public boolean isPalindrome(String s) {
            for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
                while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                    i++;
                }
                while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                    j--;
                }

                if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                    return false;
            }

            return true;
        }

    //Alternate original solution
    public boolean isPalindromeOriginal(String s) {
        String append = "";
        for(int i=0; i<s.length();i++){
            if((s.charAt(i)>='a' && s.charAt(i)<='z')|| (s.charAt(i)>='A' && s.charAt(i)<='Z') || (s.charAt(i)>='0' && s.charAt(i)<='9')){
                    append = append+s.charAt(i);
            }
        }
        int i=0, j=append.length()-1;
        append = append.toLowerCase(Locale.ROOT);
        while(i<j){
            if(append.charAt(i)==append.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        //System.out.println(append);
        return true;
    }
}
