package com.leet.LinkedIn.Hard;

import java.util.*;

public class PrintAllPalindromicSubSeq {
        public static void main(String[] args) {
            System.out.println(palindromes("abac"));
            System.out.println(palindromes("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        }

        private static List <String> palindromes(String s) {
            if (s == null || s.length() == 0) return Collections.emptyList();
            int len = s.length();

            Set <String>[][] dp = new Set[len][len]; // dp[i][j] denotes all solutions in s.substring(i,j+1);
            for (int i=0; i<len; i++) {
                dp[i][i] = new HashSet <>();
                dp[i][i].add(String.valueOf(s.charAt(i)));
                dp[i][i].add("");
            }
            for (int i=1; i<len; i++) {
                dp[i][i-1] = new HashSet<>();
                dp[i][i-1].add("");
            }

            for (int j=1; j<len; j++) {
                for (int i=j-1; i>=0; i--) {
                    dp[i][j] = new HashSet<>();
                    for (String p:   dp[i][j-1]) dp[i][j].add(p);
                    for (String p:   dp[i+1][j]) dp[i][j].add(p);
                    for (String p: dp[i+1][j-1]) dp[i][j].add(p);
                    if (s.charAt(i) == s.charAt(j)) {
                        for (String p: dp[i+1][j-1]) dp[i][j].add(s.charAt(i) + p + s.charAt(j));
                    }
                }
            }

            dp[0][len-1].remove("");
            return new ArrayList <>(dp[0][len-1]);
        }
}
