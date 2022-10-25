package com.leet.graphs.disjoinsets;

    public class QuickUnion {
        private int[] root;

        public QuickUnion(int size) {
            root = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;// This array represents the root vertex. initially the array would hold the value of its index. bcz none of the nodes are connected and in such cases, the node is root of itself
            }
        }

        public int find(int x) {
            while (x != root[x]) {
                x = root[x]; // since each node holds only parent vertex and not the root vertex, we need to go through the path completely to find the root vertex
            }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                root[rootY] = rootX; // we are only changin the parent of the current node to rootX.
            }
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
