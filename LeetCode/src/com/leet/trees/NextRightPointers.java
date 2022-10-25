    package com.leet.trees;

    import java.util.LinkedList;
    import java.util.Queue;

    //https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/994/
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public class NextRightPointers {
        public Node connect(Node root) {
            if (root == null)
                return null;
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty())
            {
                int n = queue.size();
                for (int i = 0; i < n; i++) {
                    Node temp = queue.poll();
                    if(i<n-1)
                        temp.next=queue.peek();
                    if (temp.left != null)
                        queue.add(temp.left);
                    if (temp.right != null)
                        queue.add(temp.right);
                }
            }
            return root;
        }
    }
