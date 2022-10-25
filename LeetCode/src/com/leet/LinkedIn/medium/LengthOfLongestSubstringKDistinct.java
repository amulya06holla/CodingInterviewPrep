package com.leet.LinkedIn.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
public class LengthOfLongestSubstringKDistinct {
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            int n = s.length();
            if (n * k == 0) {
                return 0;
            }
            int left = 0;
            int right = 0;

            // NOTE: IT IS IMPORTANT TO USE LINKEDHASHMAP SO THAT WE CAN INSERT, DELETE GET AND RETURN THE LAST ADDED OR FIRST ADDED ELEMENT IN O(1) time
            Map <Character, Integer> latestCharacterPosMap = new LinkedHashMap <>();
            // map saves the character and the latest location of that character eg: lool -> pos of l is 3 in the map.

            int maxLength = 1;

            while (right < n) {
                Character character = s.charAt(right);
                if (latestCharacterPosMap.containsKey(character)) { // removing the character if already found bcz we want to maintain the order in which the characters are seen
                    latestCharacterPosMap.remove(character);
                }
                latestCharacterPosMap.put(character, right++);

                if (latestCharacterPosMap.size() == k + 1) {
                    Map.Entry<Character, Integer> leftmost =
                            latestCharacterPosMap.entrySet().iterator().next(); // this gives the first letter in the order of insertion
                    latestCharacterPosMap.remove(leftmost.getKey()); // remove that element from map
                    left = leftmost.getValue() + 1; // get the location of the element in the leftmost position. that helps to determine the maxlength.
                }

                maxLength = Math.max(maxLength, right - left);
            }
            return maxLength;
        }
}
