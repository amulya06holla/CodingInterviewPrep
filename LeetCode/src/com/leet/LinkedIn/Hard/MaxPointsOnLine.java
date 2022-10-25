package com.leet.LinkedIn.Hard;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/max-points-on-a-line/
//https://www.youtube.com/watch?v=DTeFavNYkLk
// concept here is, slope of the points lying on same line will always be same.

// Calculate slope of every two points
// Store slope as key of hashmap; value is the number of points.
// Note: Vertical line doesn't have slope (We can define it as Double.MAX_VALUE)
// Check the straight lines point by point

public class MaxPointsOnLine {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2)
            return n;
        int result = 0;

        Map<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x1=points[i][0];
            int y1=points[i][1];

            for (int j = 0 ; j < n; j++) {
                if (i == j)
                    continue;
                int x2=points[j][0];
                int y2=points[j][1];
                double slope = 0.0;
                if (x1 == x2) // line is parallel is y access (vertical lines)and slope is infinity.
                    slope = Double.MAX_VALUE;
                else
                    slope = (double)(y2-y1) / (double)(x2-x1);
                map.put(slope, map.getOrDefault(slope, 0) + 1);
                result = Math.max(result, map.get(slope));
            }
            map.clear(); // do not forget to clear the map
            /**
             * (0,0), (1,1), (0,1), (1,2), (2.3)
             *
             * If you plot them out on a graph, you will find that (0,0) and (1,1) lie on one line, and (0,1), (1,2) and (2,3) lie on another parallel line. Both have a slope of 1. Here, the answer must be 3.
             *
             * When we complete i=0, the hashmap will say that slope 1 has 1 point.
             *
             * If we do not clear the hashmap, when all iterations are complete, the hashmap will say that slope 1 has 4 points (1 from i=0 + 2 from i=2 +1 from i=3).
             * That's because the slope is the same, and it will give us an incorrect answer of 5 (1 gets added at the end).
             */
        }
        return result+1;
    }
}
