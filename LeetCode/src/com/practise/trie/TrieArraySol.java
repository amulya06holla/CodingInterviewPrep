package com.practise.trie;
class TNode {

    // R links to node children
    // the ASCI value of the characters is considered as the index of the children. Hence always access the children using "ch - 'a'". this will make it fit in the 26 array index.
    public TNode[] children;

    private final int R = 26;

    public boolean isEnd;

    public TNode() {
        children= new TNode[R];
    }
}
public class TrieArraySol {
    private TNode root;

    public TrieArraySol() {
        root = new TNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (node.children[currentChar-'a']==null) {
                node.children[currentChar-'a'] = new TNode();
            }
            node = node.children[currentChar-'a'];
        }
        node.isEnd=true;
    }

    public boolean startsWith(String prefix) {
        TNode temp = root;
        for(Character w: prefix.toCharArray()) {
            if(temp.children!=null && temp.children[w-'a']!=null){
               temp = temp.children[w-'a'];
            }else{
                return false;
            }
        }
        return !temp.isEnd;
    }

    public boolean search(String word) {
        TNode temp = root;
        for(Character w: word.toCharArray()) {
            if(temp.children!=null && temp.children[w-'a']!=null){
                temp = temp.children[w-'a'];
            }else{
                return false;
            }
        }
        return temp.isEnd;
    }
}
