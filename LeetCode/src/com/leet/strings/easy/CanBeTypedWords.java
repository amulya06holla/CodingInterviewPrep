package com.leet.strings.easy;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/maximum-number-of-words-you-can-type/
public class CanBeTypedWords {
    public static void main(String[] args) {
        CanBeTypedWords cw = new CanBeTypedWords();
        System.out.println(cw.canBeTypedWords("leet code", "ld"));
    }
    public int canBeTypedWords(String text, String brokenLetters) {
        Set <Character> set = new HashSet();
        for(char i : brokenLetters.toCharArray())set.add(i);
        int res = 0,flag = 0;

        for(char i : text.toCharArray()){
            if(i == ' '){
                if(flag == 0)res++;
                flag = 0;
            }else{
                if(set.contains(i))flag = 1;
            }
        }

        return res += flag == 0 ? 1 : 0;
    }
}
