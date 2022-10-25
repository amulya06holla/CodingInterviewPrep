package com.leet.strings.medium;
//https://leetcode.com/problems/decode-ways/

/**
 * Basically this problem is same as climbing stairs problem. ref: https://leetcode.com/problems/climbing-stairs/solution/
 * dp[i] = dp[i-1]+dp[i-2].
 *
 * But before adding the dp[i-1] and dp[i-2], we need to check for certain conditions. thats all is the difference.
 * Also, instead of taking the entire array of dp[], we can take 2 variables for i-1 and i-2 values and solve this problem.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[0]=1;
        dp[1] = s.charAt(0)=='0'?0:1;

        for(int i=2; i<=s.length();i++){
            if(s.charAt(i-1)!='0')
                dp[i]=dp[i-1];
            int t = Integer.parseInt(s.substring(i-2,i)); // note that we are trying to see 2 digits at a time here.
            if(t>=10 && t<=26){
                dp[i]= dp[i]+dp[i-2];
            }
        }
        return dp[s.length()];
    }
}
