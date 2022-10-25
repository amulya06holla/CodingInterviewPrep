package com.leet.dynamicProgramming.easy;

import java.util.Arrays;

public class CountBits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(11)));
    }
    public static int[] countBits(int n) {
        int[] res = new int[n+1];
        if(n==0) return res;
        res[0]=0;
        res[1]=1;
        for(int i=2; i<=n; i++){
            int reminder = i%2;
            int t = i/2;
            res[i] = reminder>0?(res[t]+1):res[t];
        }
        return res;
    }
}
