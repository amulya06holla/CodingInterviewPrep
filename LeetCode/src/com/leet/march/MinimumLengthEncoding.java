package com.leet.march;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinimumLengthEncoding {
    public static void main(String[] args) {
        System.out.println("print");
    }

    public static int minimumLengthEncoding(String[] words) {

        Set<String> validWords = new HashSet(Arrays.asList(words));
        for (String word: words) {
            for (int k = 1; k < word.length(); ++k)
                validWords.remove(word.substring(k));
        }

        int res = 0;
        for (String word: validWords) {
            res = res + word.length() + 1;
        }
        return res;
    }
}
