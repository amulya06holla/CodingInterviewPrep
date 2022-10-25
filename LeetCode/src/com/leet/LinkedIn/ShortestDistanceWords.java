package com.leet.LinkedIn;
//https://leetcode.com/problems/shortest-word-distance/
public class ShortestDistanceWords {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int dist =Integer.MAX_VALUE;
        int pos1 =-1, pos2=-1;
        for(int i=0;i<wordsDict.length;i++){
            if(wordsDict[i].equals(word1)){
                pos1=i;
            }else if(wordsDict[i].equals(word2)){
                pos2=i;
            }

            if(pos1!=-1 && pos2!=-1)
                dist = Math.min(dist, Math.abs(pos1-pos2));
        }
        return dist;
    }
}
