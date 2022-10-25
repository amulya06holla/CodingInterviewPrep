package com.leet.Backtracking;

import java.util.*;

//https://leetcode.com/problems/word-ladder/
public class WordLadder {
    public static void main(String[] args) {

    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int res =0;
        Queue<String> queue = new LinkedList<>();
        Set<String> words = new HashSet<>(wordList);
        queue.add(beginWord);
        words.remove(beginWord);
        while(!queue.isEmpty()){
            res++;
            int size =queue.size();
            for(int i=0; i<size; i++){
                String currentWord = queue.poll();
                if(currentWord.equals(endWord)) return res;
                List<String> neighbours = findNeighbours(currentWord);
                for(String neigh: neighbours){
                    if(words.contains(neigh)){
                        words.remove(neigh);
                        queue.add(neigh);
                    }
                }
            }
        }
        return res;
    }

    private List<String> findNeighbours(String currentWord) {
        List<String> neighbours = new ArrayList<>();
        char[] chars = currentWord.toCharArray();
        for(int i=0; i<chars.length;i++){
            char temp =chars[i];
            for(char c='a';c<='z';c++){
                chars[i]=c;
                String n = new String(chars);
                neighbours.add(n);
            }
            chars[i]=temp;
        }
        return neighbours;
    }
}
