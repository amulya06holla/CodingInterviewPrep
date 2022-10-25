package com.leet.intuit;
//https://leetcode.com/problems/interleaving-string
public class InterleaveString {
    /**
     * Given strings s1, s2, and s3, return true if s3 is formed by an interleaving of s1 and s2, false otherwise.
     * Time Complexity: O(2 ^ (n1 + n2)).
     * Space Complexity: O(n1 + n2).
     *
     * @param s1 A String.
     * @param s2 A String.
     * @param s3 A String.
     * @return true if s3 is an interleaving of s1 and s2, false otherwise.
     */
    public boolean isInterleavingWithRecursion(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        return isInterleavingWithRecursion(s1, s2, s3, 0, 0);
    }

    private boolean isInterleavingWithRecursion(String s1, String s2, String s3, int i, int j) {
        if (i == s1.length() && j == s2.length()) {
            return i + j == s3.length();
        }

        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)
                && isInterleavingWithRecursion(s1, s2, s3, i + 1, j)) {
            return true;
        }

        return (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)
                && isInterleavingWithRecursion(s1, s2, s3, i, j + 1));
    }
    /**
     * Given strings s1, s2, and s3, return true if s3 is formed by an interleaving of s1 and s2, false otherwise.
     * Time Complexity: O(n1 * n2).
     * Space Complexity: O(n1 * n2).
     *
     * @param s1 A String.
     * @param s2 A String.
     * @param s3 A String.
     * @return true if s3 is an interleaving of s1 and s2, false otherwise.
     */
    // follow image on this page: https://leetcode.com/problems/interleaving-string/discuss/2252482/Java-or-5-methods-or-Explained
    public boolean isInterleavingWithBottomUpDynamicProgramming(String s1, String s2, String s3) {
        var m = s1.length();
        var n = s2.length();
        if (m + n != s3.length())
            return false;

        var matched = new boolean[m + 1][n + 1];
        matched[0][0] = true;

        for (var i = 0; i < m && matched[i][0]; i++)
            matched[i + 1][0] = s1.charAt(i) == s3.charAt(i) && matched[i][0];

        for (var j = 0; j < n && matched[0][j]; j++)
            matched[0][j + 1] = s2.charAt(j) == s3.charAt(j) && matched[0][j];

        for (var i = 1; i <= m; i++)
            for (var j = 1; j <= n; j++)
                matched[i][j] = matched[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)
                        || matched[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);

        return matched[m][n];
    }

    /**
     * Given strings s1, s2, and s3, return true if s3 is formed by an interleaving of s1 and s2, false otherwise.
     * Time Complexity: O(n1 * n2).
     * Space Complexity: O(n1 * n2).
     *
     * @param s1 A String.
     * @param s2 A String.
     * @param s3 A String.
     * @return true if s3 is an interleaving of s1 and s2, false otherwise.
     */
    public boolean isInterleavingWithTopDownDynamicProgramming(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        Boolean[][] matched = new Boolean[s1.length() + 1][s2.length() + 1];
        return isInterleavingWithTopDownDynamicProgramming(s1, s2, s3, 0, 0, matched);
    }

    private boolean isInterleavingWithTopDownDynamicProgramming(String s1, String s2, String s3, int i, int j, Boolean[][] memo) {
        if (i == s1.length() && j == s2.length()) {
            return true;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        boolean way1 = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
            way1 = isInterleavingWithTopDownDynamicProgramming(s1, s2, s3, i + 1, j, memo);
        }
        boolean way2 = false;
        if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
            way2 = isInterleavingWithTopDownDynamicProgramming(s1, s2, s3, i, j + 1, memo);
        }
        memo[i][j] = way1 || way2;
        return memo[i][j];
    }

    public static void main(String[] args) {
        InterleaveString i = new InterleaveString();
        //System.out.println(i.isInterleaveMemo("aabcc", "dbbca", "aadbbcbcac"));
    }
}
