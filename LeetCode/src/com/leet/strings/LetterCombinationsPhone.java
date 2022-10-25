package com.leet.strings;

import java.util.*;

public class LetterCombinationsPhone {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(letterCombinations("123").toArray()));
    }
    public static List<String> letterCombinations(String digits) {
         Map<Character, String> map= Map.of(
                '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
                '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
         
        return null;
    }
}
