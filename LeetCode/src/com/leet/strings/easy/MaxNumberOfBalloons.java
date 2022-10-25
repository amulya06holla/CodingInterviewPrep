package com.leet.strings.easy;
//https://leetcode.com/problems/maximum-number-of-balloons/
public class MaxNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        int[] charArr = new int[256];
        for(char s: text.toCharArray()){
            charArr[s]++;
        }
        int min =Integer.MAX_VALUE; String s="balloon";
        for(int i=0; i<s.length(); i++){
            int t =charArr[s.charAt(i)];
            if(t==0) return 0;
            if(s.charAt(i)== 'l' || s.charAt(i)=='o')
                t=t/2;
            if(t!=0 && min>t){
                min =t;
            }
        }
        return min;
    }
}
