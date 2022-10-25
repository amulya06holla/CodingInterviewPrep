package com.leet.graphs.DijkstrasProblems;

import java.util.PriorityQueue;
import java.util.Queue;
//https://leetcode.com/problems/path-with-maximum-minimum-value/submissions/

/**
 * This problem is similar to dijkstra's algorithm. Plz see the explanation in Leetcode. 
 */
public class MaximumMinimumPath {
    private int R, C;

    // 4 directions to a cell's possible neighbors.
    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maximumMinimumPath(int[][] grid) {
        R = grid.length;
        C = grid[0].length;
        // this has this weird comparator bcz we are storing the co-ordinates of the matrix and not the actual value.
        // hence the way we need to use the comparator is different.
        Queue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(grid[b[0]][b[1]], grid[a[0]][a[1]]));

        // Initalize the status of all the cells as false (unvisited).
        boolean[][] visited = new boolean[R][C];

        // Put the top-left cell to the priority queue
        // and mark it as true (visited).
        /**
         * NOTE: here we are saving the location of the co-ordinates and not the value. this is because,
         * whenever we pop out of queue, we want to read the exact values from the index.
         */
        pq.offer(new int[] {0, 0});
        visited[0][0] = true;

        int ans = grid[0][0];

        // While the priority queue is not empty.
        while (!pq.isEmpty()) {
            // Pop the cell with the largest value.
            int[] curGrid = pq.poll();
            int curRow = curGrid[0], curCol = curGrid[1];

            // Update the minimum value we have visited so far.
            ans = Math.min(ans, grid[curRow][curCol]);

            // If we reach the bottom-right cell, stop the iteration.
            if (curRow == R - 1 && curCol == C - 1) {
                break;
            }
            for (int[] dir : dirs) {
                int newRow = curRow + dir[0], newCol = curCol + dir[1];

                // Check if the current cell has any unvisited neighbors.
                if (newRow >= 0 && newRow < R && newCol >= 0 && newCol < C
                        && !visited[newRow][newCol]) {
                    // If so, we put this neighbor to the priority queue
                    // and mark it as true (visited).
                    pq.offer(new int[] {newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }

        // Return the minimum value we have seen,
        // which is the value of this path.
        return ans;
    }
}
