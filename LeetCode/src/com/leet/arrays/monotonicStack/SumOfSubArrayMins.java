package com.leet.arrays.monotonicStack;

//https://leetcode.com/problems/sum-of-subarray-minimums/

/**
 * https://leetcode.com/problems/sum-of-subarray-minimums/solution/
 * The above leetcode link has better animation to understand this problem's solution.
 * But in short, the soln is
 * 1. Find out the subarray for which the given ith element will be the smallest / minimum.
 * 2. once you have the subarray, it basically has 2 parts.
 *      eg: give arr[] =  [0, 3, 4, 5, 2, 3, 4, 1, 4]
 *         2 is min for  [3, 4, 5, 2, 3, 4]
 *       the 2 parts are [3,4,5,2] [2, 3,4]
 *       if you know this, we know the before size = 4 and after size is 3. => 3*4=12 subarrays contains 2 as min.
 *       Result = summation of (element * count of subarrays where it is smallest)
 */
public class SumOfSubArrayMins {
}
