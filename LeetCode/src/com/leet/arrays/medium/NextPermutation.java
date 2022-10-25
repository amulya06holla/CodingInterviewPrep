package com.leet.arrays.medium;

import java.util.Arrays;

//https://leetcode.com/problems/next-permutation/submissions/

/**
 * 1. Traverse from right to left.
 * 2. traverse till you find the lower number than the traversed value. (eg: 4,6,9,7,5 -> go till 6. bcz 6 is smaller than 9. )
 * 3. find the number greater than 6 but smallest in the already traversed numbers (btwn 9 and 5 => 7 in this example)
 * 4. swap the pivot number 6 with the smallest number (7)
 * 5. sort the array between pivot+1 and end of the array.
 */

/**
 * The idea here is to first traverse from right to left.
 * while doing so, we must find the number which is smaller than the already travered number.
 * The position of that number becomes i.
 * Now iterate to the right of i till the end. Find the next highest number.
 * swap arr[i] with the next highest number found.
 * After swapping sort the digits from i+1 to end.
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


// is next permutation possible

    static boolean nextPermutationPossible(int[] array) {
        // Find longest non-increasing suffix
        int i = array.length - 1;
        // find the element that is lesser than the already traversed element.
        //eg: 46975 -> 5<7, 7<9 but 9>6. so 6 is the number
        // REMEMBER: WE ARE TRYING TO FIND THE NUMBER WHICH IS SMALLER THAN THE ALREADY TRAVERESED NUMBER.
        //here 6 is smaller than 9.
        while (i > 0 && array[i - 1] >= array[i])
            i--;
        // Now i is the head index of the suffix
        // this is the case that we reach if all the numbers are in descending order.
        // Are we at the last permutation already?
        if (i <= 0)
            return false;

        // Let array[i - 1] be the pivot
        // 5<6 but 7>6. so 7 is the number.
        int j = array.length - 1;
        while (array[j] <= array[i - 1])
            j--;

        // now swap 6 and 7 in the above example.
        int temp = array[i - 1];
        // System.out.println(temp);
        array[i - 1] = array[j];
        array[j] = temp;

        // after swapping, the number now is 47965. so we need to sort the elemetns from 9 to 5.
        // hence output will be 47569.
        j = array.length - 1;
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        System.out.println(Arrays.toString(array));
        // Successfully computed the next permutation
        return true;
    }
}