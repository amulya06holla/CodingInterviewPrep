package com.leet.strings.easy;
//https://leetcode.com/problems/reverse-words-in-a-string-iii/
public class ReverseWords3 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for(int i=s.length()-1; i>=0;i--){
            if(s.charAt(i)==' '){
                sb.insert(0,temp);
                sb.insert(0, ' ');
                temp = new StringBuilder();
            }else
                temp.append(s.charAt(i));
        }
        sb.insert(0,temp);
        return sb.toString();
    }
}
