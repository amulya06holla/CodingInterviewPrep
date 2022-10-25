package com.leet.strings.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/find-common-characters/
public class CommonCharacters {
    public List<String> commonChars(String[] words) {
        ArrayList<String> result = new ArrayList<>();
        int[] count = new int[26];
        for (int i = 0; i < words[0].length(); i++) {
            count[words[0].charAt(i) - 'a']++;
        }
        for (int i = 1; i < words.length; i++) {
            int[] temp = new int[26];
            for (int j = 0; j < words[i].length(); j++) {
                temp[words[i].charAt(j) - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                if (temp[j] <= count[j] && temp[j] != 0) count[j] = temp[j];
                if (temp[j] == 0) count[j] = 0;
            }
        }
        for (int i = 0; i < 26; i++) {
            while (count[i]-- > 0) {
                result.add("" + (char) ('a' + i));
            }
        }
        return result;
    }
}
