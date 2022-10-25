package com.leet.strings.medium;

import java.util.Arrays;

//https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/637/week-2-september-8th-september-14th/3968/
public class ShiftingLetters {
    public String shiftingLetters(String s, int[] shifts) {
            // calculate the total shifts
            for(int i=shifts.length-1; i>0; --i){
                shifts[i-1] += shifts[i];
                shifts[i-1] %= 26;
            }
            char[] charArr = s.toCharArray();
            for(int i=0; i<s.length(); ++i){
                charArr[i] = (char)('a'+(charArr[i]-'a' + shifts[i])%26);
            }
            return String.valueOf(charArr);
        }
}
