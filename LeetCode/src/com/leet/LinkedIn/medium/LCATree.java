package com.leet.LinkedIn.medium;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
public class LCATree {
    public Node lowestCommonAncestor(Node p, Node q) {
        Set <Integer> visited = new HashSet <>();
        Node node = p;
        while(node!=null){
            visited.add(node.val);
            node = node.parent;
        }
        node = q;
        while(node!=null){
            if(visited.contains(node.val))
                return node;
            node=node.parent;
        }
        return null;
    }
}
