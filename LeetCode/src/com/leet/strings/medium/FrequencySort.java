package com.leet.strings.medium;

import java.util.*;

//https://leetcode.com/problems/sort-characters-by-frequency/
public class FrequencySort {
    public static void main(String[] args) {
        FrequencySort fs = new FrequencySort();
        System.out.println(fs.frequencySort(""));
    }
    public String frequencySort(String s) {
        char[] temp = s.toCharArray();
        Arrays.sort(temp);
        List <String> stringGroups = new ArrayList <>();
        StringBuilder sb = new StringBuilder();
        sb.append(temp[0]);
        for(int i=1; i<temp.length;i++){
            if(sb.charAt(i-1)==temp[i]){
                sb.append(temp[i]);
            }else{
                stringGroups.add(sb.toString());
                sb = new StringBuilder();
                sb.append(temp[i]);
            }
        }
        Collections.sort(stringGroups, new Comparator <String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        sb = new StringBuilder();
        for (String str : stringGroups) sb.append(str);
        return sb.toString();
    }
}
