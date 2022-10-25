package com.leet.Apple.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
//https://leetcode.com/problems/count-the-number-of-consistent-strings
public class CountConsistentStrings {
    public int countConsistentStrings(String allowed, String[] words) {
        int res=0;
        Set <Character> set = new HashSet();
        for(int i=0; i<allowed.length();i++){
            set.add(allowed.charAt(i));
        }
        for(int i=0; i<words.length;i++){
            boolean found=false;
            for(int j=0; j<words[i].length();j++){
                if(set.contains(words[i].charAt(j))){
                    found=true;
                }else{
                    found=false;
                    break;
                }
            }
            if(found) res++;
        }
        return res;
    }
}
