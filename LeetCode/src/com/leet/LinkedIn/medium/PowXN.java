package com.leet.LinkedIn.medium;
//https://leetcode.com/problems/powx-n/
//TC: O(log n)
//SC: O(1)
public class PowXN {
    public static void main(String[] args) {
        PowXN t = new PowXN();
        System.out.println(t.myPow(2,4));
    }
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double current_product = x;
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) { // if it is odd, then multiply one time by curr_product.
                ans = ans * current_product; // at the end if N was even, ans would still be 1 before multiplication
                // and hence comes out as 1*(curr_product).
            }
            current_product = current_product * current_product; // if it is even it multiplies itself
        }
        return ans;
    }
}
