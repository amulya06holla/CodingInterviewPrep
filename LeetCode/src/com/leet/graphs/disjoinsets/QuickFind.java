package com.leet.graphs.disjoinsets;

// UnionFind.class
// TC: Union: O(N), find: O(1), Union: O(N), connect: O(1)
public class QuickFind {
    private int[] root;

    public QuickFind(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i; // This array represents the root vertex. initially the array would hold the value of its index. bcz none of the nodes are connected and in such cases, the node is root of itself
        }
    }

    public int find(int x) {
        return root[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            for (int i = 0; i < root.length; i++) {
                if (root[i] == rootY) {
                    root[i] = rootX; // changing the root of all the nodes whose parent vertex was rootY.
                }
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}

