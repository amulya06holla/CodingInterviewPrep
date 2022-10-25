package com.leet.trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GetLonelyNodes {
    public static void main(String[] args) {
        TreeNode tn = new TreeNode();
        TreeNode root = tn.newTree(3,5,1,6,2,0,8,null,null,7,4);
        System.out.println(Arrays.toString(getLonelyNodes(root).toArray()));
    }

    public static List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if(root.left==null && root.right==null)
            return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if((node.right==null && node.left!=null)){
                list.add(node.left.val);
            }else if(node.right!=null && node.left==null){
                list.add(node.right.val);
            }
            if(node.left!=null)
                q.offer(node.left);
            if(node.right!=null)
                q.offer(node.right);
        }
        return list;
    }

}
