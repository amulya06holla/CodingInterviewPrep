package com.leet.Apple.easy;
//https://leetcode.com/problems/find-common-characters
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindCommonLetters {
    class Solution {
        public List<String> commonChars(String[] words) {
            Map <Character, Integer> map = new HashMap();
            List <String> res =new ArrayList();
                for(int i=0; i<words[0].length(); i++){
                    map.put(words[0].charAt(i),map.getOrDefault(words[0].charAt(i),0)+1);
                }
            if(words.length==1) {
                for(Map.Entry entries: map.entrySet()){
                    int val=(Integer)entries.getValue();
                        while(val!=0) {
                            res.add(entries.getKey()+"");
                            val--;
                        }
                }
                return res;
            }


            for(int i=1; i<words.length; i++){
                Map <Character, Integer> temp = new HashMap();
              for(int j=0; j<words[i].length();j++){
                  char curr = words[i].charAt(j);
                  if(map.containsKey(curr)){
                      temp.put(curr, Math.min(map.get(curr), temp.getOrDefault(curr, 0)+1));
                  }
              }
              map=temp;
            }

            for(char c : map.keySet()){
                for(int i = 0; i < map.get(c); i++)
                    res.add(c + "");
            }
            return res;
        }
    }
}
