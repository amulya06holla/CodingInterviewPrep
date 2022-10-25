package com.leet.august;

import java.util.*;

//https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3887/
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        groupAnagrams(strs);
    }
    public static List<List <String>> groupAnagrams(String[] strs) {
        List<List <String>> res = new ArrayList <>();
        Map <String, List<String>> ans = new HashMap <String, List<String>>();
        for(int i=0; i<strs.length;i++){
            String s = strs[i];
            char[] cArr = s.toCharArray();
            Arrays.sort(cArr);
            String key = Arrays.toString(cArr);
            List<String> list =  new ArrayList();
            if(ans.containsKey(key)){
                list = ans.get(key);
            }
            list.add(strs[i]);
            ans.remove(key);
            ans.put(key, list);
        }

        for(Map.Entry<String, List<String>> entry:ans.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
}
