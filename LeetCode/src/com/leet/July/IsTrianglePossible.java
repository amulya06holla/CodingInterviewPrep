package com.leet.July;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * For a triangle, its sides should follow these constraints,
 *
 *
 * A + B > C    and
 * B + C > A    and
 * C + A > B
 * where A, B and C are length of sides of the triangle.
 *
 * https://www.geeksforgeeks.org/possible-form-triangle-array-values/
 */
public class IsTrianglePossible {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,3,4};
    }
    int binarySearch(int nums[], int l, int r, int x) {
        while (r >= l && r < nums.length) {
            int mid = (l + r) / 2;
            if (nums[mid] >= x)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }
    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                k = binarySearch(nums, k, nums.length - 1, nums[i] + nums[j]);
                count += k - j - 1;
            }
        }
        return count;
    }
}
