package com.leet.dds;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Idea is to find the position of the current location and put that into queue.
 * Follow BFS method and run it till you find the food. Because it is BFS, the first time you reach food will be the shortest path.
 * during BFS, we are keeping the stepCount along with x and y coordiate of the current position in the array and putting that into queue.
 * ALso, we are marking each of the visited node as 'X' so that we dont traverse the same location again.
 *
 * NOTE: here we are doing BFS from currentlocation to food and not from food to the current location.
 * this is because what we want is the shortest distance from currentlocation to food.
 * if we do it around food, then we find the shortest distance from food to any location. and there are more than one place where food is present. so that would be too tedious.
 *
 */
public class ShortestPathFood {
    public int getFood(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return -1;
        }

        int rowLength = grid.length;
        int colLength = grid[0].length;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();

        // add the current location to the queue.
        for(int i = 0; i < rowLength; i++) {
            for(int j = 0; j < colLength; j++) {
                if(grid[i][j] == '*') {
                    queue.add(new int[]{i, j, 0}); // taking 0 as the number of steps from food in the beginning.
                    break;
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] currentCell = queue.poll();
            int step = currentCell[2]; // the oth index gives x coordinate, 1st gives the y and 2nd gives the step count.

            for(int[] direction : directions) {
                int row = currentCell[0] + direction[0];// the oth index gives x coordinate, use this for the direction calc.
                int col = currentCell[1] + direction[1];// the 1st gives the y coordinate,use this for the direction calc.

                if(row < 0 || row >= rowLength || col < 0 || col >= colLength || grid[row][col] == 'X') {
                    continue; // dont consider for the edge cases and if there is an obstacle.
                }

                if(grid[row][col] == '#') {
                    return step + 1; // we are returning as soon as we find the first place of food.
                }
                grid[row][col] = 'X'; // marking the visited locations with x. so that we wont revisit same spot again.
                queue.add(new int[]{row, col, step + 1}); // keep adding the current location to queue by incrementing the step counts.
            }
        }

        return -1;
    }
}
