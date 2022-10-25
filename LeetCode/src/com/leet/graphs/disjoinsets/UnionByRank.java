package com.leet.graphs.disjoinsets;
//https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3879/

public class UnionByRank {
        private int[] root;
        private int[] rank;

        public UnionByRank(int size) {
            root = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;//// This array represents the root vertex. initially the array would hold the value of its index. bcz none of the nodes are connected and in such cases, the node is root of itself
                rank[i] = 1; // initally height of all the nodes is just 1 when they are not yet connected.
            }
        }
        // TC: O(logn)
        public int find(int x) {
            while (x != root[x]) {
                x = root[x];// since each node holds only parent vertex and not the root vertex, we need to go through the path completely to find the root vertex
            }
            return x;
        }

    // TC: O(logn)
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) { // if rootX and rootY are same, then that means they are already connected and needn't do anything.
                if (rank[rootX] > rank[rootY]) { // whichever rank(height) is greater, choose that to be the root node.
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1; // increment the rank only incase when the ranks of both were same.
                }
            }
        }

    // TC: O(logn)
        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
