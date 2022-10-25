package com.leet.LinkedIn.medium;
//https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/solution/
// READ: https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3878/

public class NumberOfConnectedComponents {
    public int countComponents(int n, int[][] edges) {
        DisjointSet set = new DisjointSet(n);

        for(int[] edge : edges) {
            set.union(edge[0], edge[1]);
        }

        return set.getNumberOfComponents();
    }

    static class DisjointSet {
        private int numComponents;
        private int[] parent;
        private int[] rank;

        DisjointSet(int n) {
            numComponents = n;
            rank = new int[n];
            parent = new int[n];
            initialiseParents(n);
        }

        public void union(int x, int y) {
            int pX = find(x);
            int pY = find(y);

            if(pX == pY) {
                return;
            }
            if(rank[pX] < rank[pY]) {
                parent[pX] = parent[pY];
            }else {
                parent[pY] = parent[pX];
                if(rank[pY] == rank[pX]) {
                    rank[pX]++;
                }
            }
            numComponents--;
        }


        public int find(int x) {
            if(x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public int getNumberOfComponents() {
            return numComponents;
        }

        private void initialiseParents(int n) {
            for(int i=0;i<n;i++) {
                parent[i] = i;
            }
        }
    }
}
