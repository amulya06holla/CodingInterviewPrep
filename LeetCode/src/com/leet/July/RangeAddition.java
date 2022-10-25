package com.leet.July;

import java.util.Arrays;

//https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/610/week-3-july-15th-july-21st/3814/
public class RangeAddition {
    public static void main(String[] args) {
        int[][] updates = {{1,3,2},{2,4,3},{0,2,-2}};
        System.out.println(Arrays.toString(getModifiedArray(5, updates)));
    }
    public static int[] getModifiedArray(int length, int[][] updates) {
       int[] res = new int[length];
       for(int i=0; i<updates.length; i++){
           int arr[] = updates[i];
           for(int j=arr[0]; j<=arr[1];j++){
               res[j]= res[j]+arr[2];
           }
          // System.out.println(Arrays.toString(res));
       }
       return res;
    }
}
