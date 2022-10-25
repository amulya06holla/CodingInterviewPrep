package com.leet.april;

import java.util.Comparator;
import java.util.PriorityQueue;

public class VerifyAlienDictSorted {
    public static void main(String[] args) {
        String[] words = new String[]{"hello", "leetcode"};

        System.out.println(isAlienSorted(words, "hlabcdefgijkmnopqrstuvwxyz"));
    }
    public static boolean isAlienSorted(String[] words, String order) {
        int[] rank = new int[26];
        for (int i = 0; i < order.length(); i++){
            rank[order.charAt(i) - 'a'] = i; // basically 0 to 26 (alphabets position in normal english lang) has been ranked as per order for this alien lang.
        }

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (j >= words[i + 1].length())
                    return false; // eg: apple and app

                if(words[i].charAt(j) != words[i + 1].charAt(j) ){ // when the letters of 2 adjacent words do not match,
                    if (rank[words[i].charAt(j)-'a'] > rank[words[i+1].charAt(j)-'a']) // if the order of the letters from current and next word are not sorted as per the order, then return
                        return false;
                    else
                        break; // because if there are DIFFERENT letters and if they are SORTED, then no need to check for rest of the letters.
                }


            }
        }
        return true;
    }
}
