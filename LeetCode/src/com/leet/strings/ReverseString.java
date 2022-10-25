package com.leet.strings;

import java.util.Arrays;

//https://leetcode.com/problems/reverse-string/
public class ReverseString {
    public static void main(String[] args) {
        char[] s= new char[] {'h', 'e', 'l', 'l', 'o'};
        //reverseString(s);
        reverseStringRec(s,0 , s.length-1);
        System.out.println(Arrays.toString(s));
    }
    public static void reverseString(char[] s) {
        int i=0, j=s.length-1;
        while(i<j){
            char t = s[i];
            s[i++] = s[j];
            s[j--]= t;
        }
        System.out.println(Arrays.toString(s));
    }

    public static void reverseStringRec(char[] s, int first, int last) {
            if(s==null || first> last) return;
            reverseStringRec(s, first+1, last-1);
        char t = s[first];
        s[first] = s[last];
        s[last]= t;
    }
}
