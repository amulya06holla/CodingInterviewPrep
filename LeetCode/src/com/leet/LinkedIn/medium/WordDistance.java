package com.leet.LinkedIn.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/shortest-word-distance-ii/
public class WordDistance {
    String[] wordsDict;
    HashMap <String, List> map;
    public WordDistance(String[] wordsDict) {
        this.map = new HashMap <>();
        for(int i=0; i<wordsDict.length;i++){
            List<Integer> list = map.getOrDefault(wordsDict[i],new ArrayList());
            list.add(i);
            map.put(wordsDict[i],list );
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> loc1, loc2;
        int l1 = 0, l2 = 0, minDiff = Integer.MAX_VALUE;
        // THIS PART OF CODE IS https://leetcode.com/problems/shortest-word-distance-iii/submissions/
        if(word1.equals(word2)){
            loc1 = this.map.get(word1);
            for(int i=1; i<loc1.size();i++){
                l2=i;
                minDiff = Math.min(minDiff, Math.abs(loc1.get(l1) - loc1.get(l2)));
                l1=l2;
            }
            return minDiff;
        }
        //TILL HERE
        loc1 = this.map.get(word1);
        loc2 = this.map.get(word2);

        while (l1 < loc1.size() && l2 < loc2.size()) {
            minDiff = Math.min(minDiff, Math.abs(loc1.get(l1) - loc2.get(l2)));
            if (loc1.get(l1) < loc2.get(l2)) {
                l1++;
            } else {
                l2++;
            }
        }
        return minDiff;
    }

    public static void main(String[] args) {
        String[] wordsDict = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        WordDistance obj = new WordDistance(wordsDict);
        System.out.println(obj.shortest("coding","practice"));
        System.out.println(obj.shortest("makes","coding"));
    }
}
