package com.leet.trees;

import java.util.*;

public class TraversalsOfTrees {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        res = preOrderTraversalRec(root, res);
        return res;
    }

    // refer https://stackoverflow.com/a/27886144 for recrrsive method explanation
    private static List<Integer> preOrderTraversalRec(TreeNode root, List<Integer> res) {
        if (root == null) {
            return res;
        }
        res.add(root.val);
        preOrderTraversalRec(root.left, res);
        preOrderTraversalRec(root.right,res);
        return res;
    }

    // iterative method of solving
    private static List<Integer> preOrderTraversalStack(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        if(root==null) return res;

        res.add(root.val);
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return res;
    }

    // morris preorder
    public List<Integer> preorderTraversalMorris(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();

        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) { // same as inorder.
                res.add(curr.val);
                curr = curr.right;
            }
            else {
                TreeNode pre = curr.left;
                while ((pre.right != null) && (pre.right != curr)) {
                    pre = pre.right;
                } // same as inorder

                if (pre.right == null) {
                    res.add(curr.val);
                    pre.right = curr;
                    curr = curr.left;
                }
                else{
                    pre.right = null;
                    curr = curr.right;
                }
            }
        }
        return res;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return inOrderRec(root, list);
    }

    private static List<Integer> inOrderRec(TreeNode root, List<Integer> list) {
        if(root==null) return list;
        inOrderRec(root.left,list);
        list.add(root.val);
        inOrderRec(root.right,list);
        return list;
    }

    public List < Integer > inorderTraversalIterative(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        Stack < TreeNode > stack = new Stack < > ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    // Morris tree : it is based on threaded binary tree concept.

    public List < Integer > inorderTraversalMorris(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        TreeNode curr = root;
        TreeNode pre;
        while (curr != null) {
            // there can be only 2 cases. either the left child is null or it is not null.
            if (curr.left == null) {
                res.add(curr.val); /////////////This is where the value gets printed or gets added to output list.
                curr = curr.right; // move to next right node
            } else { // has a left subtree
                pre = curr.left;
                while (pre.right != null) { // find rightmost
                    pre = pre.right;
                }
                pre.right = curr; // put cur after the pre node
                TreeNode temp = curr; // store cur node
                curr = curr.left; // move cur to the top of the new tree
                temp.left = null; // original cur left be null, avoid infinite loops
            }
        }
        return res;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        return postOrderTraversalRec(root, res);
    }

    private static List<Integer> postOrderTraversalRec(TreeNode root, List<Integer> res) {
        if (root == null) {
            return res;
        }
        postOrderTraversalRec(root.left, res);
        postOrderTraversalRec(root.right,res);
        res.add(root.val);
        return res;
    }
    // iterative method of solving
    private static List<Integer> postOrderTraversalStack(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        if(root==null) return res;

        res.add(root.val);
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.addFirst(node.val); // this solution is same as preordertraversal. but (addFIRST) here we are adding the values to the front of the list.
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right); // ALSO, WE ARE ADDING LEFT AND THEN RIGHT ELEMENTS INTO THE STACK WHICH IS OPPOSITE IN PREORDER
            }
        }
        return res;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.offer(root);
        }
        TreeNode cur;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> subAns = new LinkedList<Integer>();
            for (int i = 0; i < size; ++i) {        // traverse nodes in the same level
                cur = q.poll();
                subAns.add(cur.val);                // visit the root
                if (cur.left != null) {
                    q.offer(cur.left);              // push left child to queue if it is not null
                }
                if (cur.right != null) {
                    q.offer(cur.right);             // push right child to queue if it is not null
                }
            }
            ans.add(subAns);
        }
        return ans;
    }

    // reverse level order
    public void reverseLevelOrder(TreeNode node){
        if(node==null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            TreeNode n = q.poll();
            System.out.print(n.val+" ");
            if(n.right!=null){
                q.offer(n.right);
            }
            if(n.left!=null){
                q.offer(n.left);
            }
        }
        System.out.println();
    }

    // spiral level order
    public void spiralLevelOrder(TreeNode node){
        if(node==null) return;
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s1.push(node);
        while(!s1.isEmpty() || !s2.isEmpty()){
            List<Integer> temp = new LinkedList<Integer>();
            while(!s1.isEmpty()){
                TreeNode t = s1.pop();
                //System.out.print(t.val+" ");
                temp.add(t.val);
                if(t.left!=null)
                    s2.push(t.left);
                if(t.right!=null)
                    s2.push(t.right);
            }
            res.add(temp);
            //System.out.println();
            temp = new LinkedList<Integer>();
            while(!s2.isEmpty()){
                TreeNode t = s2.pop();
                //System.out.print(t.val+" ");
                temp.add(t.val);
                if(t.right!=null)
                    s1.push(t.right);
                if(t.left!=null)
                    s1.push(t.left);
            }
            res.add(temp);
            // System.out.println();
        }
    }

    // level order traversal and print values at each level and also print the level number
    public void levelOrderPrintAtEachLevelAlongWithLevelNumber(TreeNode node){
        if(node==null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);
        q.offer(null);
        int level=0;
        List<Integer> output = new LinkedList<>();
        while(!q.isEmpty()){
            TreeNode n = q.poll();
            if(n==null && !output.isEmpty()){
                System.out.println(Arrays.toString(output.toArray())+" level="+level++);
                output = new LinkedList<>();
                q.offer(null);
            }
            else{
                if(n!=null) {
                    if (n.left != null) {
                        q.offer(n.left);
                    }
                    if (n.right != null) {
                        q.offer(n.right);
                    }
                    output.add(n.val);
                }
            }
        }
        System.out.println();
    }
    public int closestValue(TreeNode root, double target) {
        int val, closest = root.val;
        while (root != null) {
            val = root.val;
            closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest;
            root =  target < root.val ? root.left : root.right;
        }
        return closest;
    }

    //https://leetcode.com/explore/featured/card/july-leetcoding-challenge-2021/608/week-1-july-1st-july-7th/3798/
    // level order in bottom up fashion.
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> findLeaves(TreeNode root) {
        levels(root);
        return res;
    }

    private static int levels(TreeNode root){
        if(root == null) return -1;

        int depth = Math.max(levels(root.left), levels(root.right)) +1; // we are setting the levels of a tree in descending order. i.e. leaf nodes will have its levels set as 0.
        // so the level of the root or any node is determined by the max depth between right and left.
        if(depth >= res.size()){
            res.add(new ArrayList<>()); // basically if there are no list available for a specific node, then a new list is added.
        }

        res.get(depth).add(root.val);  // now add the element to the respective level's list.
        return depth;
    }

}
