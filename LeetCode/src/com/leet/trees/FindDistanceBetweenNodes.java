package com.leet.trees;

public class FindDistanceBetweenNodes {
    public static void main(String[] args) {
        TreeNode tn = new TreeNode();
        TreeNode root = tn.newTree(3);
        root.right = tn.newTree(1);
        root.left = tn.newTree(5);
        root.left.right= tn.newTree(2);
        root.right.left = tn.newTree(0);
        root.right.right = tn.newTree(8);
        root.left.left = tn.newTree(6);
        FindDistanceBetweenNodes t = new FindDistanceBetweenNodes();
        System.out.println(t.findDistance(root, 5,3));

    }
    public int findDistance(TreeNode root, int p, int q) {
        if(p==q) return 0;
        root = findLCA(root, p, q);
        int val=0; int valp= 0, valq=0;
        if(root.val==p) valq = findDistanceBetweenTwoNodes(root, q,0);
        else if(root.val==q) valp = findDistanceBetweenTwoNodes(root, p,0);
        else{
            valp = findDistanceBetweenTwoNodes(root, p,0);
            valq = findDistanceBetweenTwoNodes(root, q,0);
        }
        return valp+valq;
    }

    private int findDistanceBetweenTwoNodes(TreeNode root, int val, int len) {
        if(root==null) return 0;
        if(root.val==val) {
            return len;
        }
        return findDistanceBetweenTwoNodes(root.left, val, len+1) | findDistanceBetweenTwoNodes(root.right, val, len+1);
    }

    private TreeNode findLCA(TreeNode root, int p, int q) {
        if(root==null) return null;
        if(root.val==p || root.val==q) return root;
        TreeNode leftLCA = findLCA(root.left, p,q);
        TreeNode rightLCA = findLCA(root.right, p,q);
        if(leftLCA!=null && rightLCA!=null) return root;
        if(leftLCA!=null && rightLCA==null) return leftLCA;
        if(rightLCA!=null && leftLCA==null) return rightLCA;
        return null;
    }
}
