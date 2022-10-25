package com.leet.arrays.medium;

import java.util.Arrays;

//https://leetcode.com/problems/sort-colors/

/**
 * dutch flag problem
 */
public class SortColors {
    public static void main(String[] args) {
        SortColors sc = new SortColors();
        int[] nums = new int[]{1,0,2};
        sc.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while(mid <= high) {
            if(nums[ mid ] == 0){
                int temp = nums[ mid ];
                nums[ mid ] = nums[ low ];
                nums[ low ] = temp;
                mid++;
                low++;   //NOTE: BOTH LOW AND MID ARE INCREMENTED
            }
            else if(nums[ mid ] == 1) {
                mid++;  // NOTE ONLY MID IS INCREMENTED.
            }
            else {
                int temp = nums[ mid ];
                nums[ mid ] = nums[ high ];
                nums[ high ] = temp;
                high--;  // NOTE ONLY HIGH IS DECREMENTED.
            }
        }
    }
}
