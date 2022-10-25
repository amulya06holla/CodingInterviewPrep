package com.leet.Trie;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/implement-trie-prefix-tree/solution/
class TrieNode{
    Map <Character, TrieNode> children;
    boolean endOfWord;
    int wordCount;
    int prefixCount;
    public TrieNode() {
        children = new HashMap<>();
        endOfWord = false;
    }
}
public class Trie {

        /** Root of the trie*/
        private TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie.
         *  make current as root
         *  iterate through every letter in the word
         *  and see if the current is null. if yes, create a new trieNode for this character
         *  make current as the new trienode or move the current to point to the next node whcihever is true
         *  */
        public void insert(String word) {
            TrieNode current = root;   // start from root.
            for(int i=0; i<word.length();i++){
                Character ch = word.charAt(i);
                TrieNode n =current.children.get(ch); // check if current trienode has the map corresponding to "ch" character.
                if(n==null){ // if not, put that as the item in the children map.
                    n= new TrieNode();
                    current.children.put(ch,n);
                }
                current = n; // move on to the next node if already present.
                current.prefixCount++;
            }
            current.endOfWord =true;
            current.wordCount++;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode current = root;
            for(int i=0; i<word.length();i++){
                Character ch = word.charAt(i);
                TrieNode n =current.children.get(ch); // check if current trienode has the map corresponding to "ch" character.
                if(n==null){ // if not, then that means the letter in the word is not present in trie. hence return false;
                    return false;
                }
                current = n; // move on to the next node if already present.
            }
            if(current.endOfWord) return true;
            return false;
        }

    public TrieNode searchPrefix(String word) {
        TrieNode current = root;
        for(int i=0; i<word.length();i++){
            Character ch = word.charAt(i);
            TrieNode n =current.children.get(ch); // check if current trienode has the map corresponding to "ch" character.
            if(n==null){ // if not, then that means the letter in the word is not present in trie. hence return null;
                return null;
            }
            current = n; // move on to the next node if already present.
        }
        return current;
    }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            if(searchPrefix(prefix)!=null) return true;
            return false;
        }

        /** deletes the word from trie */
        public void deleteWords(String word) {
            delete(root, word, 0);
        }

    public void erase(String word) {
        TrieNode node=root;
        for(char c : word.toCharArray()){
            if(node.children.get(c)==null){
                return;
            }
            node=node.children.get(c);
            node.prefixCount--;
        }
        node.wordCount--;
    }

    public int countWordsEqualTo(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
            if(node.children.get(c) == null) return 0;
            node = node.children.get(c);
        }
        return node.wordCount;
    }

    public int countWordsStartingWith(String prefix) {
        TrieNode node = root;
        for(char c : prefix.toCharArray()){
            if(node.children.get(c) == null) return 0;
            node = node.children.get(c);
        }
        return node.prefixCount;
    }

    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            //if current.endOfWord is false, then that means the word is not found in the trie and hence no need to delete anything.
            if (!current.endOfWord) {
                return false;
            }
            // if current.endOfWord is true, implies the word is found in trie. so first make it false.
            current.endOfWord = false;
            //after making it false, we can delete the word only if current has no other mapping.
            // so return true if there are no other child.
            // check https://youtu.be/AXjmTQ8LEoI?t=774
            return current.children.size() == 0;
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

        //if true is returned then delete the mapping of character and trienode reference from map.
        if (shouldDeleteCurrentNode) {
            current.children.remove(ch); // removing map with ch as key from children map
            //return true if no mappings are left in the map.
            return current.children.size() == 0;
        }
        return false;
    }

}
