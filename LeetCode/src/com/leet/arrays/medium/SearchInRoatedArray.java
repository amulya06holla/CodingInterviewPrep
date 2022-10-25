package com.leet.arrays.medium;
//https://leetcode.com/problems/search-in-rotated-sorted-array/
/**
 * Overall logic:
 * 1. Find the pivot point.
 *      a. pivot point is the index where the element next to that index is lesser than index. => num[index]< num[index+1].
 *      b. find this point using binary search.
 *      c. everytime you find the middle, see if the element at the middle is smaller than left most value.
 *      d. bcz if it is smaller, then the index has to be moved towards left. else to the right.
 * 2. once we have the pivot point, again do binary search btwn left and pivotpoint OR between pivot point and right.
 *    this depends on the fact that if the target is smaller or larger than the element at the pivot.
 *
 */
public class SearchInRoatedArray {

    public static void main(String[] args) {

    }

    int [] nums;
    int target;

    public int find_rotate_index(int left, int right) {
        if (nums[left] < nums[right])
            return 0;

        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] > nums[pivot + 1])
                return pivot + 1;
            else {
                if (nums[pivot] < nums[left])
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        return 0;
    }

    public int search(int left, int right) {
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] == target)
                return pivot;
            else {
                if (target < nums[pivot])
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        int n = nums.length;

        if (n == 1)
            return this.nums[0] == target ? 0 : -1;

        int rotate_index = find_rotate_index(0, n - 1);

        // if target is the smallest element
        if (nums[rotate_index] == target)
            return rotate_index;
        // if array is not rotated, search in the entire array
        if (rotate_index == 0)
            return search(0, n - 1);
        if (target < nums[0])
            // search in the right side
            return search(rotate_index, n - 1);
        // search in the left side
        return search(0, rotate_index);
    }
}
