package com.leet.strings.medium;

public class LongestPalindromicSubSequence {
    public static void main(String[] args) {
        String test = "bbbab";
        LongestPalindromicSubSequence lp = new LongestPalindromicSubSequence();
        System.out.println(lp.longestPalindromeSubseq(test));
    }
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i=0; i<s.length(); i++){
            dp[i][i]=1;
        }

        for(int l=2; l<=s.length();l++){
            for(int i=0; i<s.length()-l+1;i++){
                int j = i + l - 1;
                if(i!=j){
                    if(s.charAt(i)==s.charAt(j))
                        {
                            dp[i][j]=dp[i+1][j-1]+2;
                        }else{
                            dp[i][j]=Math.max(dp[i+1][j], dp[i][j-1]);
                        }
                    }

            }
        }

//        for(int i=0; i<s.length();i++){
//           for(int j=0; j<s.length(); j++){
//               System.out.print(dp[i][j]+ " ");
//           }
//            System.out.println();
//        }
        return dp[0][s.length()-1];
    }
}
