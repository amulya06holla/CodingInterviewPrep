package com.leet.august;
//https://leetcode.com/problems/flip-string-to-monotone-increasing/
public class MinFlipsMonoIncr {
    public static void main(String[] args) {

    }
    public int minFlipsMonoIncr(String s) {
        int ones=0, flip=0;
        for(int i=0; i<s.length();i++){
            if(s.charAt(i)=='1') {
                ones++;
            }else{
                flip++;
            }
            flip = Math.min(ones, flip);
        }
        return flip;
    }
}
