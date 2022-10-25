package com.leet.strings.easy;

import java.util.HashMap;

//https://leetcode.com/problems/longest-palindrome/
public class LongestPalindrome {
    public static void main(String[] args) {

    }
    public int longestPalindrome(String s) {
        int res =0;
        HashMap<Character, Integer> map = new HashMap <>();
        for(int i=0; i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                res = res+2;
                map.remove(s.charAt(i));
            }else{
                map.put(s.charAt(i),1);
            }
        }
        if(!map.isEmpty()){
            res = res+1;
        }
        return res;
    }
}
