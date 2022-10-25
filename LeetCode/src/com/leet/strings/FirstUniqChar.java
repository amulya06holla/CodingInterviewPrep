package com.leet.strings;

public class FirstUniqChar {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }
    public static int firstUniqChar(String s) {
        char[] c = new char[256];
        int res =-1;
        for(int i=0; i<s.length();i++){
            c[s.charAt(i)]++;
        }
        for(int i=0; i<s.length();i++){
            if(c[s.charAt(i)]==1){
                System.out.println(s.charAt(i));
                return i;
            }
        }
        return res;
    }
}
