package com.leet.april;

import java.util.Arrays;
import java.util.List;

public class HalvesAreAlike {
    public static void main(String[] args) {
        System.out.println(halvesAreAlike("textbook"));
    }
    public static boolean halvesAreAlike(String s) {
        int n = s.length(); int count1=0; int count2=0;
        Character[] c = new Character[]{'a','e','i','o','u', 'A', 'E', 'I', 'O', 'U'};
        List<Character> list = Arrays.asList(c);
        for(int i=0; i<n/2; i++){
            if(list.contains(s.charAt(i))){
                count1++;
            }
        }
        for(int i=n/2; i<n; i++){
            if(list.contains(s.charAt(i))){
                count2++;
            }
        }
        if(count1==count2) return true;
        return false;
    }
}
