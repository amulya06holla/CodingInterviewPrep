package com.leet.July;

import java.util.Arrays;

public class CustomStringSort {
    public static void main(String[] args) {
        System.out.println(customSortString("we", "sd"));
    }
    public static String customSortString(String order, String str) {
        String res="";
        int[] charArr= new int[26];
        Arrays.fill(charArr, -1);
        for(int i=0; i<str.length();i++){
            int t = str.charAt(i) - 'a';
            if(charArr[t]<0)
                charArr[t]=1;
            else
                charArr[t]=charArr[t]+1;
        }

        for(int i=0; i<order.length();i++) {
            int t = order.charAt(i) - 'a';
            while(charArr[t]>0){
                res = res+order.charAt(i);
                charArr[t]--;
            }
        }
        for(int i=0; i<str.length();i++){
            if (charArr[str.charAt(i)-'a']>0){
                res = res+str.charAt(i);
                charArr[str.charAt(i)-'a']--;
            }
        }
        return res;
    }
}
