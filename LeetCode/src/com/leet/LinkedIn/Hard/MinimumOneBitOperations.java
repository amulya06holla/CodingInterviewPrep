package com.leet.LinkedIn.Hard;
//https://leetcode.com/problems/minimum-one-bit-operations-to-make-integers-zero/
public class MinimumOneBitOperations {
    public int minimumOneBitOperations(int n) {
        if (n<=1)
            return n;
        int d = 1;
        while ((1<<d) <= n) {
            d++;
        }
        return ((1<<d)-1) - minimumOneBitOperations(n - (1<<(d-1)));
    }
}
