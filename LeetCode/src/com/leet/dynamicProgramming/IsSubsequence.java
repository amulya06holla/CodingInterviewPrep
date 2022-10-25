package com.leet.dynamicProgramming;

public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("axe", "ahbgdc"));
    }
    public static boolean isSubsequence(String s, String t) {
        int i=0, j=0;
        while(i!=t.length()){
            if(j<s.length() && s.charAt(j)==t.charAt(i)){
                j++;
            }
            i++;
        }
        if(j==s.length()) return true;
        return false;
    }
}
