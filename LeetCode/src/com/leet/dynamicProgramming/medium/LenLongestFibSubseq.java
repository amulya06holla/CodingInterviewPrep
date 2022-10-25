package com.leet.dynamicProgramming.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/solution/
public class LenLongestFibSubseq {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,7,11,12,14,18,29};
        System.out.println(lenLongestFibSubseq(arr));
    }
    public static int lenLongestFibSubseq(int[] arr) {
        Set <Integer> s=new HashSet <Integer>();
        for(int i : arr){
            s.add(i);
        }
        int res=0;
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int a=arr[i];
                int b=arr[j];
                int c=a+b;
                int count=2;
                while(s.contains(c)){
                    count++;
                    res=Math.max(res,count);
                    a=b;
                    b=c;
                    c=a+b;
                }
            }
        }
        if(res>2){
            return res;
        }else{
            return 0;
        }
    }
}
