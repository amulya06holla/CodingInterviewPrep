package com.leet.uber.hard;
//https://www.youtube.com/watch?v=PcYCkgYu6uc
//https://leetcode.com/problems/number-of-islands-ii/

import java.util.ArrayList;
import java.util.List;

class UnionFind {
    int count; // # of connected components
    int[] parent;
    int[] rank;

    public UnionFind(char[][] grid) { // for problem 200
        count = 0;
        int m = grid.length;
        int n = grid[0].length;
        parent = new int[m * n];
        rank = new int[m * n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    parent[i * n + j] = i * n + j;
                    ++count;
                }
                rank[i * n + j] = 0;
            }
        }
    }

    public UnionFind(int N) { // for problem 305 and others
        count = 0;
        parent = new int[N];
        rank = new int[N];
        for (int i = 0; i < N; ++i) {
            parent[i] = -1;
            rank[i] = 0;
        }
    }

    public boolean isValid(int i) { // for problem 305
        return parent[i] >= 0;
    }

    public void setParent(int i) {
        if (parent[i] == -1) { // need to have this check so that if there are any duplicates, it would still work
            parent[i]=i;
            ++count;
        }
    }

    public int find(int i) { // path compression
        if (parent[i] != i) parent[i] = find(parent[i]);
        return parent[i];
    }

    public void union(int x, int y) { // union with rank
        int rootx = find(x);
        int rooty = find(y);
        if (rootx != rooty) {
            if (rank[rootx] > rank[rooty]) {
                parent[rooty] = rootx;
            } else if (rank[rootx] < rank[rooty]) {
                parent[rootx] = rooty;
            } else {
                parent[rooty] = rootx; rank[rootx] += 1;
            }
            --count; // decrement count of islands only if the two islands are not in same set.
        }
    }

    public int getCount() {
        return count;
    }
}
public class NumberOfIslands2 {
        public List <Integer> numIslands2(int m, int n, int[][] positions) {
            List<Integer> ans = new ArrayList <>();
            UnionFind uf = new UnionFind(m * n); // initally mark all parents as -1 and rank as 0

            for (int[] pos : positions) { // now consider each position.
                int r = pos[0], c = pos[1];
                List<Integer> overlap = new ArrayList<>();

                // see if there are any islands adjacent to the current position. which is right, left, top and botttom
                // how do we know if there is island? if the parent[i]!=0 or u can also check in the original grid.
                // if there is any island, then add that position (equivalent in array) to the arraylist
                if (r - 1 >= 0 && uf.isValid((r-1) * n + c)) overlap.add((r-1) * n + c);
                if (r + 1 < m && uf.isValid((r+1) * n + c)) overlap.add((r+1) * n + c);
                if (c - 1 >= 0 && uf.isValid(r * n + c - 1)) overlap.add(r * n + c - 1);
                if (c + 1 < n && uf.isValid(r * n + c + 1)) overlap.add(r * n + c + 1);

                int index = r * n + c; // calculate the current position's index.
                uf.setParent(index); // set the parent[i] to i first and first increment the count of island
                for (int i : overlap)
                    uf.union(i, index); // now see if there are any set avaialble already usign union method. if there is any island, then decrement the count.

                ans.add(uf.getCount()); // finally get the currentcount of island and add that to answer.
            }

            return ans;
        }

    public static void main(String[] args) {
        NumberOfIslands2 t = new NumberOfIslands2();
        int[][] positions = new int[][]{{0,0},{0,1},{1,2},{2,1}};
        int m=3;
        int n=3;
        System.out.println(t.numIslands2(m,n,positions));
    }

}
