package com.leet.strings.medium;
//https://leetcode.com/problems/palindromic-substrings/solution/
public class CountPalindromicSubstrings {
    public static void main(String[] args) {
        CountPalindromicSubstrings cs = new CountPalindromicSubstrings();
        System.out.println(cs.countSubstrings("xbobx"));
    }
    public int countSubstrings(String s) {

        if(s.length()==1) return 1;
        if(s.length()==0) return 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count =0;
        for(int i=0; i<s.length();i++){
            dp[i][i]=true;
            count++;
        }

        for (int i = 1; i < s.length(); ++i) {
            if(s.charAt(i-1) == s.charAt(i) ){
                dp[i-1][i]=true;
                //System.out.println(i-1+" "+i);
                count++;
            }
        }

        for(int len=3; len<=s.length();len++){
            for(int i=0; i<s.length();i++){
                int j=i+len-1;
              // System.out.println(i+ " "+j);
                if(j<s.length()&& s.charAt(i)==s.charAt(j) && dp[i+1][j-1] ){
                    dp[i][j]=true;
                   // System.out.println(s.charAt(i)+" "+s.charAt(j));
                    count++;
                }
            }
        }
        return count;
    }
}
