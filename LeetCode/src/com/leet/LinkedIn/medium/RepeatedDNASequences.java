package com.leet.LinkedIn.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//https://leetcode.com/problems/repeated-dna-sequences/
public class RepeatedDNASequences {
    public List <String> findRepeatedDnaSequences(String s) {
        int L = 10, n = s.length();
        HashSet <String> seen = new HashSet(), output = new HashSet();

        // iterate over all sequences of length L
        for (int start = 0; start < n - L + 1; ++start) {
            String tmp = s.substring(start, start + L); // L is contant 10
            if (seen.contains(tmp)) output.add(tmp);
            seen.add(tmp);
        }
        return new ArrayList <String>(output);
    }
}
