package com.leet.July;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg","add"));
    }
    public static boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        Map<Character, String> sMap = new HashMap<>();
        Map<Character, String> tMap = new HashMap<>();
        for(int i=0; i<s.length();i++){
            if(!sMap.containsKey(s.charAt(i)))
                sMap.put(s.charAt(i), Integer.toString(i));
            else{
                String temp = sMap.get(s.charAt(i));
                sMap.put(s.charAt(i), temp+","+Integer.toString(i));
            }
            if(!tMap.containsKey(t.charAt(i)))
                tMap.put(t.charAt(i), Integer.toString(i));
            else{
                String temp = tMap.get(t.charAt(i));
                tMap.put(t.charAt(i), temp+","+Integer.toString(i));
            }
        }
        boolean flag=true;
        for(int i=0; i<sMap.size();i++){
           // System.out.println(sMap.get(s.charAt(i)) +" "+tMap.get(t.charAt(i)));
            if(!sMap.get(s.charAt(i)).equals(tMap.get(t.charAt(i)))) {
                flag = false;
            }
        }
        return flag;
    }
}
