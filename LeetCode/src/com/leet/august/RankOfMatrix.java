package com.leet.august;

import java.util.*;

//
public class RankOfMatrix {
    // implement find and union
    public int find(Map <Integer, Integer> UF, int x) {
        if (x != UF.get(x)) {
            UF.put(x, find(UF, UF.get(x)));
        }
        return UF.get(x);
    }

    public void union(Map<Integer, Integer> UF, int x, int y) {
        if (!UF.containsKey(x)) {
            UF.put(x, x);
        }
        if (!UF.containsKey(y)) {
            UF.put(y, y);
        }
        UF.put(find(UF, x), find(UF, y));
    }

    public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // link row and col together
        Map<Integer, Map<Integer, Integer>> UFs = new HashMap<>();
        // UFs.get(v): the Union-Find of value v
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int v = matrix[i][j];
                if (!UFs.containsKey(v)) {
                    UFs.put(v, new HashMap <Integer, Integer>());
                }
                // union i to j
                union(UFs.get(v), i, ~j);
            }
        }

        // put points into `value2index` dict, grouped by connection
        // use TreeMap to help us sort the key automatically
        SortedMap<Integer, Map<Integer, List <int[]>>> value2index = new TreeMap <>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int v = matrix[i][j];
                if (!value2index.containsKey(v)) {
                    value2index.put(v, new HashMap<Integer, List<int[]>>());
                }
                Map<Integer, List<int[]>> indexes = value2index.get(v);
                int f = find(UFs.get(v), i);
                if (!indexes.containsKey(f)) {
                    indexes.put(f, new ArrayList<int[]>());
                }
                indexes.get(f).add(new int[] { i, j });
            }
        }

        int[][] answer = new int[m][n]; // the required rank matrix
        int[] rowMax = new int[m]; // rowMax[i]: the max rank in i row
        int[] colMax = new int[n]; // colMax[j]: the max rank in j col
        for (int v : value2index.keySet()) {
            // update by connected points with same value
            for (List<int[]> points : value2index.get(v).values()) {
                int rank = 1;
                for (int[] point : points) {
                    rank = Math.max(rank, Math.max(rowMax[point[0]], colMax[point[1]]) + 1);
                }
                for (int[] point : points) {
                    answer[point[0]][point[1]] = rank;
                    // update rowMax and colMax
                    rowMax[point[0]] = Math.max(rowMax[point[0]], rank);
                    colMax[point[1]] = Math.max(colMax[point[1]], rank);
                }
            }
        }
        return answer;
    }
}

