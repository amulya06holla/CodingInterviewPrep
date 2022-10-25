package com.leet.trees;

import java.util.*;

public class ViewsOfTrees {
    public static void main(String[] args) {
        TreeNode tn = new TreeNode();
        TreeNode root = tn.newTree(1);
        root.right = tn.newTree(3);
        root.left = tn.newTree(2);
        root.left.left= tn.newTree(4);
        root.left.right= tn.newTree(5);
        root.right.left= tn.newTree(6);
        root.right.right= tn.newTree(7);
//        root.right=tn.newTree(2);
//        root.right.left = tn.newTree(3);
//        root.right.right =tn.newTree(4);
       // System.out.println(boundaryOfBinaryTree(root));
        ViewsOfTrees vt = new ViewsOfTrees();
        vt.verticalTraversal(root);

    }
    List<Integer> nodes = new ArrayList<>(1000);
    public List<Integer> boundaryOfBinaryTrees(TreeNode root) {

        if(root == null) return nodes;

        nodes.add(root.val);

        leftBoundary(root.left);
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);

        return nodes;
    }
    public void leftBoundary(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return;
        nodes.add(root.val);
        if(root.left == null) leftBoundary(root.right);
        else leftBoundary(root.left);
    }
    public void rightBoundary(TreeNode root) {
        if(root == null || (root.right == null && root.left == null)) return;
        if(root.right == null)rightBoundary(root.left);
        else rightBoundary(root.right);
        nodes.add(root.val); // add after child visit(reverse)
    }
    public void leaves(TreeNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            nodes.add(root.val);
            return;
        }
        leaves(root.left);
        leaves(root.right);
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            int n = queue.size();
            for (int i = 0; i <n; i++) {
                TreeNode temp = queue.poll();
                if (i == n-1)
                    list.add(temp.val); // add the data only if it is the last object in that level.
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }

        return list;
    }

    public static List<Integer> LeftSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode temp = queue.poll();
                if (i == 0)
                    list.add(temp.val); // add the data only if it is the first object in that level.
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }

        return list;
    }

    //https://leetcode.com/problems/binary-tree-upside-down/
    public TreeNode upsideDownBinaryTreeIter(TreeNode root) {

        TreeNode prev = null;
        TreeNode temp = null; //use additional variable temp

        while(root != null){
            TreeNode next = root.left;

            //swap
            root.left = temp;
            temp = root.right;

            //steps similar to reverse a linkedList
            root.right = prev;
            prev = root;
            root=next;
        }

        return prev;

    }

    //backtracking way
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null)
            return null;
        return upsideDownTree(root, null);
    }

    private TreeNode upsideDownTree(TreeNode cur, TreeNode parent){
        TreeNode newRoot = cur;
        if(cur.left != null){
            newRoot = upsideDownTree(cur.left, cur);
        }
        if(parent != null){
            cur.left = parent.right;
            cur.right = parent;
            parent.left = null;
            parent.right = null;
        }
        return newRoot;
    }

    public boolean isLeaf(TreeNode t) {
        return t.left == null && t.right == null;
    }

    public void addLeaves(List<Integer> res, TreeNode root) {
        if (isLeaf(root)) {
            res.add(root.val);
        } else {
            if (root.left != null) {
                addLeaves(res, root.left);
            }
            if (root.right != null) {
                addLeaves(res, root.right);
            }
        }
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (!isLeaf(root)) {
            res.add(root.val);
        }
        TreeNode t = root.left;
        while (t != null) {
            if (!isLeaf(t)) {
                res.add(t.val);
            }
            if (t.left != null) {
                t = t.left;
            } else {
                t = t.right;
            }

        }
        addLeaves(res, root);
        Stack<Integer> s = new Stack<>();
        t = root.right;
        while (t != null) {
            if (!isLeaf(t)) {
                s.push(t.val);
            }
            if (t.right != null) {
                t = t.right;
            } else {
                t = t.left;
            }
        }
        while (!s.empty()) {
            res.add(s.pop());
        }
        return res;
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,ArrayList<Integer>> m = new TreeMap<>();
        getVerticalOrder(root, 0, m);
        List<List<Integer>> res = new ArrayList<>();
        for(Map.Entry<Integer,ArrayList<Integer>> entry : m.entrySet()){
            ArrayList<Integer> l = entry.getValue();
            System.out.println(Arrays.toString(l.toArray()));
        }
        return res;
    }
    static void getVerticalOrder(TreeNode root, int hd,
                                 TreeMap<Integer,ArrayList<Integer>> m)
    {
        if(root == null)
            return;
        ArrayList<Integer> list =  m.get(hd);
        if(list == null)
        {
            list = new ArrayList<>();
            list.add(root.val);
        }
        else
            list.add(root.val);
        m.put(hd, list);
        getVerticalOrder(root.left, hd-1, m);
        getVerticalOrder(root.right, hd+1, m);
    }

}
