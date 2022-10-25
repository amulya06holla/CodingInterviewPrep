package com.leet.august;

import com.leet.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List <Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
public class NAryLevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue <Node> q = new LinkedList <>();
        if (root != null) {
            q.offer(root);
        }
        Node cur;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> subAns = new LinkedList<Integer>();
            for (int i = 0; i < size; ++i) {        // traverse nodes in the same level
                cur = q.poll();
                subAns.add(cur.val);
                for(int j=0; j<cur.children.size();j++)
                    q.offer(cur.children.get(j));
            }
            ans.add(subAns);
        }
        return ans;
    }
}
