package com.leet.LinkedIn.newquestions;
import java.util.*;

public class PrintPalindromeSubSequences {
    public static void main(String[] args) {
        PrintPalindromeSubSequences x = new PrintPalindromeSubSequences();
        System.out.println(Arrays.toString(x.allPalindromicSubSequence("aabb").toArray()));
    }
    public static List<String> allPalindromicSubSequence(String str){
        List<String> ans = new ArrayList<>();
        int len = str.length();
        int[][] dp = new int[len][len];
        for(int i=0; i<len; i++){
            for(int j=0; j<=i; j++){
                dp[i][j] = 1;
            }
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int left = j;
                int right = j + i;
                if (right < len && str.charAt(left) == str.charAt(right)) {
                    dp[left][right] = dp[left + 1][right - 1];
                }
            }
        }
        Set<String> set = new HashSet<>();

        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                if(dp[i][j]==1 && i<=j){
                    set.add(str.substring(i, j+1));
                }
            }
        }
        ans.addAll(set);

        return ans;
    }

}
