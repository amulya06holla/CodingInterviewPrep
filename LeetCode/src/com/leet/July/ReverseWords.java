package com.leet.July;

import java.util.Arrays;

public class ReverseWords {
    public static void main(String[] args) {
        char[] s = new char[]{'a'};
        reverseWords(s);
    }

    public static void reverseWords(char[] s) {
        String res = "";
        for(int i=0; i<s.length; i++){
            res = res+ s[i];
        }
        //res = "this is test";
        String[] resArr = res.split("\\s+");
        int t=0;
        for(int i=resArr.length-1; i>=0; i--){
            for(int j=0; j<resArr[i].length(); j++){
                s[t++]=resArr[i].charAt(j);
            }
            if(i!=0)
            s[t++]=' ';
        }
        System.out.println(Arrays.toString(s));
    }
}
