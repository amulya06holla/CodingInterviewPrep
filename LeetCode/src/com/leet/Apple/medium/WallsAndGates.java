package com.leet.Apple.medium;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/walls-and-gates/discuss/72745/Java-BFS-Solution-O(mn)-Time
public class WallsAndGates {
/**
 Push all gates into queue first. Then for each gate update its neighbor cells and push them to the queue.
 Repeating above steps until there is nothing left in the queue.
 */
        public void wallsAndGates(int[][] rooms) {
            if (rooms.length == 0 || rooms[0].length == 0) return;

            Queue <int[]> queue = new LinkedList <>();
            // add all the gate coordinates into the queue
            for (int i = 0; i < rooms.length; i++) {
                for (int j = 0; j < rooms[0].length; j++) {
                    if (rooms[i][j] == 0) queue.add(new int[]{i, j});
                }
            }
            while (!queue.isEmpty()) {
                int[] top = queue.remove();
                int row = top[0], col = top[1];

                // keep checking if there are empty rooms in any 4 direction of the current gate.
                // if yes, keep adding those coordinates into the queue
                // also save the room value as (value at gate coordinate +1).
                if (row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE) {
                    rooms[row - 1][col] = rooms[row][col] + 1;
                    queue.add(new int[]{row - 1, col});
                }
                if (row < rooms.length - 1 && rooms[row + 1][col] == Integer.MAX_VALUE) {
                    rooms[row + 1][col] = rooms[row][col] + 1;
                    queue.add(new int[]{row + 1, col});
                }
                if (col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE) {
                    rooms[row][col - 1] = rooms[row][col] + 1;
                    queue.add(new int[]{row, col - 1});
                }
                if (col < rooms[0].length - 1 && rooms[row][col + 1] == Integer.MAX_VALUE) {
                    rooms[row][col + 1] = rooms[row][col] + 1;
                    queue.add(new int[]{row, col + 1});
                }
            }
        }

}
