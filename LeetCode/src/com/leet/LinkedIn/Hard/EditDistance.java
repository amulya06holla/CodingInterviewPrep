package com.leet.LinkedIn.Hard;
//https://leetcode.com/problems/edit-distance/
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if(len1==0) return len2;
        if(len2==0) return len1;

        int[][] dp = new int[len1+1][len2+1];

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                // If first string is empty, only option is
                // to insert all characters of second string
                if (i == 0)
                    dp[i][j] = j; // Min. operations = j

                    // If second string is empty, only option is
                    // to remove all characters of second string
                else if (j == 0)
                    dp[i][j] = i; // Min. operations = i

                    // If last characters are same, ignore last
                    // char and recur for remaining string
                else if (word1.charAt(i - 1)
                        == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];

                    // If the last character is different,
                    // consider all possibilities and find the
                    // minimum
                else
                    dp[i][j] = 1
                            + Math.min(Math.min(dp[i][j - 1], // Insert
                                                dp[i - 1][j]), // Remove
                                                dp[i - 1][j - 1]); // Replace
            }
        }

        return dp[len1][len2];
    }
}
