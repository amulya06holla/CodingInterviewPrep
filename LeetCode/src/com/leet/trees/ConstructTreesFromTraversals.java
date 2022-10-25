package com.leet.trees;
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
import java.util.HashMap;
import java.util.Map;

public class ConstructTreesFromTraversals {

    int preorderIndex; // this value cant be sent in the recursive call. bcz it must be incremented in every recursive call.
    Map<Integer, Integer> inorderIndexMap;
    int postorderIndex;
    public static void main(String[] args) {
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        ConstructTreesFromTraversals ct = new ConstructTreesFromTraversals();
        TreeNode root = ct.buildTreeFromInorderPostorderTraversals(postorder, inorder);
        System.out.println(root.val);
    }


    public TreeNode buildTreeFromInorderPreorderTraversals(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        // build a hashmap to store value -> its index relations
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildTreeFromInorderPreorder(preorder, 0, preorder.length - 1);
    }

    private TreeNode buildTreeFromInorderPreorder(int[] preorder, int left, int right) {
        // if there are no elements to construct the tree
        if (left > right) return null;

        // select the preorder_index element as the root and increment it
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // build left and right subtree
        // excluding inorderIndexMap[rootValue] element because it's the root
        root.left = buildTreeFromInorderPreorder(preorder, left, inorderIndexMap.get(rootValue) - 1);
        root.right = buildTreeFromInorderPreorder(preorder, inorderIndexMap.get(rootValue) + 1, right);
        return root;
    }


    public TreeNode buildTreeFromInorderPostorderTraversals(int[] postorder, int[] inorder) {
        postorderIndex = postorder.length-1;
        // build a hashmap to store value -> its index relations
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildTreeFromInorderPostorder(postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTreeFromInorderPostorder(int[] postorder, int left, int right) {
        if(left>right) return null;
        System.out.println(postorderIndex+" "+left+" "+right);
        int rootValue = postorder[postorderIndex];

        TreeNode root = new TreeNode(rootValue);
        postorderIndex--;
        int rootVal = inorderIndexMap.get(rootValue);
        root.right=buildTreeFromInorderPostorder(postorder,rootVal+1, right);
        root.left=buildTreeFromInorderPostorder(postorder, left, rootVal-1);

        return root;
    }


}
