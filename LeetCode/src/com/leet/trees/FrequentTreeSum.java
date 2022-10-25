package com.leet.trees;

import java.util.*;

public class FrequentTreeSum {
    static Map<Integer, Integer> map = new HashMap<>();
    static int max = 0;
    public static void main(String[] args) {
        TreeNode tn = new TreeNode();
        TreeNode root = tn.newTree(5,2,-3);
        findFrequentTreeSum(root);

    }

    public static int[] findFrequentTreeSum(TreeNode root) {
        //return findFrequentTreeSums(root).stream().mapToInt(i->i).toArray();
        List<Integer> listres= findFrequentTreeSums(root);
        int[] res = new int[listres.size()];
        for(int i=0; i<res.length; i++){
            res[i] = listres.get(i);
        }
        return res;
    }


    public static List<Integer> findFrequentTreeSums(TreeNode root) {
        findSum(root,map);
        List<Integer> resultList = new ArrayList<Integer>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue()==max){
                resultList.add(entry.getKey());
            }
        }
        return resultList;
    }

    private static int findSum(TreeNode treeNode, Map<Integer, Integer> map) {
        if (treeNode == null)
            return 0;
        //if(treeNode.right==null && treeNode.left==null) return treeNode.val;
        int lsum= findSum (treeNode.left,map);
        int rsum= findSum (treeNode.right,map);
        int sum=treeNode.val+lsum+rsum;
        //System.out.println(treeNode.val+ " " +sum);
        int val = 1;
        if(map.containsKey(sum)){
            val = map.get(sum)+1;
        }
        map.put(sum, val);
        max=Math.max(val,max);
        return sum;
    }
}
