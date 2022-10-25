package com.leet.LinkedIn;
//https://leetcode.com/problems/find-smallest-letter-greater-than-target/
public class NextGreatestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        char c =Character.MAX_VALUE;
        for(int i=0; i<letters.length;i++){
            if(letters[i]>target && letters[i]<c){
                c=letters[i];
            }
        }
        return c;
    }
}
