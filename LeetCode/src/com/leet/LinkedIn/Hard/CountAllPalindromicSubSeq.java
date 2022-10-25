package com.leet.LinkedIn.Hard;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
//https://www.youtube.com/watch?v=fvYlinirmFg&t=182s
//https://leetcode.com/problems/count-different-palindromic-subsequences/
public class CountAllPalindromicSubSeq {
    public static void main(String[] args) {
        CountAllPalindromicSubSeq t = new CountAllPalindromicSubSeq();
        System.out.println(t.countPalindromicSubsequences("bbbab"));
    }
    public int countAllPalindromicSubsequences(String str) {
        int N = str.length();

        // create a 2D array to store the count
        // of palindromic subsequence
        int[][] cps = new int[N][N];

        // palindromic subsequence of length 1
        for (int i = 0; i < N; i++)
            cps[i][i] = 1;

        // check subsequence of length L is
        // palindrome or not
        for (int L = 2; L <= N; L++) {
            for (int i = 0; i <= N-L; i++) {
                int k = L + i - 1;
                if (str.charAt(i) == str.charAt(k)) {
                    cps[i][k] = cps[i][k - 1]
                            + cps[i + 1][k] + 1;
                }else{
                    cps[i][k] = cps[i][k - 1]
                            + cps[i + 1][k]
                            - cps[i + 1][k - 1];
                }
            }
        }

        // return total palindromic subsequence
        return cps[0][N - 1];
    }

    // count "DISTINCT" palindromic subsequences
    //https://youtu.be/fvYlinirmFg?t=1400
    public int countPalindromicSubsequences(String str) {
        int[][] dp = new int[str.length()][str.length()];
        int[] prev = new int[str.length()];
        HashMap<Character, Integer> map = new HashMap <>(); // stores chacter and its next location for filling up prev array and stores character and prev location for storing next array.
        for(int i=0; i<str.length();i++){
            // eg: abbabba prev[0]=-1, prev[3]=0, prev[6]=3. we are trying to save the previous location of the character occurance.
            if(map.containsKey(str.charAt(i))){
                prev[i]=map.get(i);
            }else{
                prev[i]=-1;
            }
            map.put(str.charAt(i), i);
        }

        int[] next = new int[str.length()];
        map.clear();
        for(int i=str.length()-1; i>=0;i--){
            // eg: abbabba next[6]=-1, next[3]=6, next[0]=3. we are trying to save the next location of the character occurance.
            if(map.containsKey(str.charAt(i))){
                next[i]=map.get(i);
            }else{
                next[i]=-1;
            }
            map.put(str.charAt(i), i);
        }

        for(int gap = 0; gap<str.length();gap++){
            for(int i=0, j=gap; j<str.length(); i++,j++){
                if(gap==0){
                    // fill this with 1. bcz when there is only one character, the total palidrome is 1.
                    dp[i][j] = 1;
                }else if(gap==2){
                    // fill this with 2. bcz if it is "aa", then total distinct palidromes are "a" and "aa"
                    // or if it is "ab", total distinct palidromes are "a" and "b".
                    //so total is always 2.
                    dp[i][j]=2;
                }else{
                    char startingChar = str.charAt(i);
                    char endingChar = str.charAt(j);

                    if(startingChar!=endingChar){
                        // if the starting and ending characters are not same, it is easy.
                        dp[i][j]= dp[i+1][j]+ dp[i][j-1] - dp[i+1][j-1];
                    }
                    else{
                        int n = next[startingChar]; // always get next location where the starting character is present.
                        int p = prev[endingChar]; // always get prev location where the ending character is present.
                        // this value n and p will help in knowing if there are any location where this character has been repeated
                        // and hence helps in removing the duplicates.
                        if(n>p){
                            // implies there is no repeated character. bcz eg: abbbbba
                            // in this example, n[0] is 6, and p[6] =0. so n>p. => no repeated character
                            dp[i][j] = 2*dp[i+1][j-1] +2;
                        }else if(n==p){
                            // implies there is 1 repeated character same as starting charac / ending
                            // eg: abbabba here n[0] = 3 and p[6]=3. => 1 repeated character
                            dp[i][j] = 2*dp[i+1][j-1] +1;

                        }else{
                            // implies there are more than 1 repeated characters btwn start and end.
                            // eg: abbabbabba here n[0] = 3 and p[9]=6. => n<p
                            dp[i][j] = 2*dp[i+1][j-1] -dp[n+1][p-1];
                        }
                    }


                }
            }
        }
        return dp[0][str.length()-1];
    }

}
