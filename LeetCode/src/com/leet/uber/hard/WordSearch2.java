package com.leet.uber.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class TrieNode {
    HashMap <Character, TrieNode> children = new HashMap<Character, TrieNode>();
    String word = null;
    public TrieNode() {}
}
public class WordSearch2 {
        char[][] board= null;
        ArrayList<String> result= new ArrayList <String>();

        public List <String> findWords(char[][] board, String[] words) {

            // Step 1). Construct the Trie
                TrieNode root= constructTrieNode(words);

            this.board= board;
            // Step 2). Backtracking starting for each cell in the board
            for (int row = 0; row < board.length; ++row) {
                for (int col = 0; col < board[row].length; ++col) {
                    if (root.children.containsKey(board[row][col])) {
                        backtracking(row, col, root);
                    }
                }
            }

            return this.result;
        }

    private TrieNode constructTrieNode(String[] words) {
        TrieNode root = new TrieNode();
        for(String word: words){
            TrieNode currentNode = root;
            for(int i=0; i<word.length(); i++){
                Character c = word.charAt(i);
                TrieNode node = currentNode.children.get(c);
                if(node==null){
                    node = new TrieNode();
                    currentNode.children.put(c,node);
                }
                currentNode=node;
            }
            currentNode.word=word;
        }
        return root;
    }

    private void backtracking(int row, int col, TrieNode node) {

        if(row >= board.length || row < 0 || col >= board[row].length || col < 0 || !node.children.containsKey(this.board[row][col]) || this.board[row][col]=='#'){
            return;
        }
            Character currentLetter = this.board[row][col];
            TrieNode currNode = node.children.get(currentLetter);

            // check if there is any match
            if (currNode.word != null) {
                this.result.add(currNode.word);
                currNode.word = null;
            }

            // mark the current letter before the EXPLORATION
            this.board[row][col] = '#';

            // explore neighbor cells in around-clock directions: up, right, down, left
                backtracking(row-1, col, currNode);
                backtracking(row+1, col, currNode);
                backtracking(row, col-1, currNode);
                backtracking(row, col+1, currNode);


            // End of EXPLORATION, restore the original letter in the board.
            this.board[row][col] = currentLetter;

            // Optimization: incrementally remove the leaf nodes
            if (currNode.children.isEmpty()) {
                node.children.remove(currentLetter);
            }
        }
    }
