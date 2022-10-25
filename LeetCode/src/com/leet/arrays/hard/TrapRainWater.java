package com.leet.arrays.hard;

// rain water trapped = minimum of maximum height of bars on both the sides minus its own height.
// implies rainwater = min(leftmax,rightmax) - heightofitsown
//https://www.geeksforgeeks.org/trapping-rain-water/

public class TrapRainWater {

    // O(n) space and time complexity solution

    static int arr[] = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

    // Method for maximum amount of water
    static int findWater(int n)
    {
        // left[i] contains height of tallest bar to the
        // left of i'th bar including itself
        int left[] = new int[n];

        // Right [i] contains height of tallest bar to
        // the right of ith bar including itself
        int right[] = new int[n];

        // Initialize result
        int water = 0;

        // Fill left array
        left[0] = arr[0];
        for (int i = 1; i < n; i++)
            left[i] = Math.max(left[i - 1], arr[i]);

        // Fill right array
        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--)
            right[i] = Math.max(right[i + 1], arr[i]);

        // Calculate the accumulated water element by element
        // consider the amount of water on i'th bar, the
        // amount of water accumulated on this particular
        // bar will be equal to min(left[i], right[i]) - arr[i] .
        for (int i = 0; i < n; i++)
            water += Math.min(left[i], right[i]) - arr[i];

        return water;
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // O(n) time complexity but O(1) space complexity solution
    static int findWater(int arr[], int n)
    {
        // initialize output
        int result = 0;

        // maximum element on left and right
        int left_max = 0, right_max = 0;

        // indices to traverse the array
        int lo = 0, hi = n - 1;

        while (lo <= hi) {
            if (arr[lo] < arr[hi]) {
                if (arr[lo] > left_max)

                    // update max in left
                    left_max = arr[lo];
                else

                    // water on curr element =
                    // max - curr
                    result += left_max - arr[lo];
                lo++;
            }
            else {
                if (arr[hi] > right_max)

                    // update right maximum
                    right_max = arr[hi];

                else
                    result += right_max - arr[hi];
                hi--;
            }
        }

        return result;
    }


    // solution similar to longest valid parenthesis problem
    public int trap(int[] height) {
        int total = 0, curMax = 0, prov = 0, last = 0;
        for (int i = 0; i < height.length; i++) {
            int h = height[i];
            if (h >= curMax) {
                total += prov;
                prov = 0;
                curMax = h;
                last = i;
            } else prov += curMax - h;
        }
        prov = 0;
        curMax = 0;
        // from right to left.. move only till last known greater value => max from left side.
        for (int i = height.length - 1; i >= last; i--) {
            int h = height[i];
            if (h >= curMax) {
                total += prov;
                prov = 0;
                curMax = h;
            } else prov += curMax - h;
        }
        return total;
    }
}
