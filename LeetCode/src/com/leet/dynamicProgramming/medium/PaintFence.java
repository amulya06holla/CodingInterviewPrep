package com.leet.dynamicProgramming.medium;
//https://www.youtube.com/watch?v=ju8vrEAsa3Q
//https://leetcode.com/problems/paint-fence/submissions/
public class PaintFence {
    public int numWays(int n, int k) {

        int same =k*1;
        int different = k*(k-1);
        int total =same+different;
        for(int i=3; i<=n;i++){
            same = different*1;
            different = total*(k-1);
            total = same+different;
            System.out.println(total);
        }
        return total;
    }
}
