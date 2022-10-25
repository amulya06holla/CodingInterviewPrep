package com.leet.LinkedIn.Hard;
//https://leetcode.com/problems/word-ladder/solution/

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        WordLadder t = new WordLadder();
        String[] arr = new String[]{"ymann","yycrj","oecij","ymcnj","yzcrj","yycij","xecij","yecij","ymanj","yzcnj","ymain"};
        System.out.println(t.ladderLength("ymain", "oecij", Arrays.asList(arr)));
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> word=new HashSet(wordList);//it will be easy to check if wordlist contains that word
        Queue<String> q=new LinkedList<>();
        Set<String> visited=new HashSet<>();//to keep track of visited words;
        q.add(beginWord);
        visited.add(beginWord);

        int level=0;
        while(!q.isEmpty())
        {
            level++;//moving to the next level
            for(int i=q.size();i>0;i--)
            {
                String currWord=q.poll();
                if(currWord.equals(endWord))
                    return level;

                char[] c=currWord.toCharArray();
                for(int j=0;j<c.length;j++)//to replace every character of that word and check if it is present in wordlist
                {
                    char temp=c[j];
                    for(char ch='a'; ch<='z'; ch++)
                    {
                        c[j]=ch;
                        String wordFormed=String.valueOf(c);//if this newly formed word isnt visited and also present in the wordlist add it to the queue
                        if(!visited.contains(wordFormed) && word.contains(wordFormed))
                        {
                            q.add(wordFormed);
                            visited.add(wordFormed);
                        }
                    }
                    c[j]=temp;
                }
            }

        }

        return 0; // note: if none of the word matches, thats when it will reach this point. hence 0 should be returned.
    }
        }
