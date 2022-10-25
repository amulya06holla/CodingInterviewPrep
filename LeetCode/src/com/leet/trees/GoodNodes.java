package com.leet.trees;

import java.util.*;

//https://leetcode.com/problems/count-good-nodes-in-binary-tree/
public class GoodNodes {
    public static void main(String[] args) {
        TreeNode tn = new TreeNode();
        TreeNode root = tn.newTree(1,4,5,4,4,5);
        GoodNodes gn = new GoodNodes();
        System.out.println(gn.longestUnivaluePath(root));
    }
    public static int goodNodes(TreeNode root) {
        List<Integer> goodNodes = new ArrayList<>();
        findRootToLeafPaths(root, root.val, goodNodes);
       // System.out.println(Arrays.toString(goodNodes.toArray()));
        return goodNodes.size();
    }

    private static void findRootToLeafPaths(TreeNode root,int maxVal, List<Integer> goodNodes) {
        if(root==null) return;
        if(root.val>= maxVal) {
            maxVal = root.val;
            goodNodes.add(root.val);
        }
        findRootToLeafPaths(root.left, maxVal, goodNodes);
        findRootToLeafPaths(root.right, maxVal, goodNodes);
    }
    static int val =0;
    private void findRootToLeafPathMax(TreeNode root,Map<Integer, Integer>map) {
        if(root==null) return;
        int count =0;
        if(map.containsKey(root.val)){
            count = map.get(root.val)+1;
            map.put(root.val, count);

        }
        else{
            map.put(root.val,1);
            count =1;
        }
        if(count>val) val=count;
        findRootToLeafPathMax(root.left,  new HashMap<Integer, Integer>(map));
        findRootToLeafPathMax(root.right, new HashMap<Integer, Integer>(map));
    }

    public int longestUnivaluePath(TreeNode root) {
        GoodNodes gn = new GoodNodes();
        gn.findRootToLeafPathMax(root, new HashMap<>());
        return val-1;
    }
}
