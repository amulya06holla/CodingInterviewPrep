package com.leet.arrays.monotonicStack;
//https://leetcode.com/problems/sum-of-total-strength-of-wizards/
//https://www.youtube.com/watch?v=89SWkwpT8fo&ab_channel=ThinkCode
//https://leetcode.com/problems/sum-of-total-strength-of-wizards/discuss/2530049/JAVA-Easy-to-understand-Time-%3A-O(n)-Space-O(n)
//https://leetcode.com/problems/sum-of-total-strength-of-wizards/discuss/2634028/Java-or-O(N)-Solution-or-Prefix-Sum-of-Prefix-Sum-%2B-Mono-Stack
//https://leetcode.com/problems/sum-of-subarray-minimums/solution/

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * NOTE:
 * Subarray + sum -> prefix sum
 * Subarray + minimum -> mono stack
 *
 *
 * To solve this problem its helpful to take a look at the below two problems.
 * 1. Prefix sum: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/610/week-3-july-15th-july-21st/3814/
 * 2. Monotonic stack approach: https://www.geeksforgeeks.org/next-greater-element/
 *
 * LOGIC:
 * Step1:
 * find the smallest element for an element in the index i at both left and right side.
 * eg: if the given array is arr = [2,4,5,6,3,6,4,1,5,7]
 *                                  ^       ^     ^
 *                       indexes=  [0,1,2,3,4,5,6,7,8,9]
 * the smallest element for the index 4, i.e. arr[4]=3 is
 *                                            right: it is index 7 i.e. arr[7]=1
 *                                            left : it is index 0 i.e. arr[0]=2
 * now if I want to find sum of all the subarrays which has 3 as the minimum
 * i.e. sum of all the subarray elements between index 0 and 7 => [4,5,6,3,6,4]
 * To do this, we need prefixSum of the above array.
 *                      prefixSum = [2,6,11,17,20,26,30,31,36,43]
 *                      indexes=    [0,1, 2, 3,4, 5, 6, 7, 8, 9]
 *  What we want is :
 *                  arr = [2,{4,5,6,3,6,4},1,5,7]
 *                         |        |      |
 *                         left     i     right
 *The reason we use < on left but <= on right is to avoid duplicates.
 * Here is an example array: 1 2 3 4 2 3 4 2 1
 * For the highlighted subarray 2 3 4 2, we want to calculate the strength using the 2nd 2 but not the first 2.
 *
 *      leftSum= (pref[i]-pref[left] + pref[i]-pref[left+1] + pref[i]-pref[left+2]+ pref[i]-pref[left+3])
 *    leftsum = pref[3]-pref[0] + pref[3]-pref[1] + pref[3]-pref[2] -> based on above example.
 *              which is nothing but, pref[3] - (sum of 4+5+6+3) + pref[3] -(sum of 5+6+3) + pref[3]-(sum of 6+3) +pref[3]-(sum of 3)
 *              this gives the left sum.
 *    similarly, rightsumforfirstElement = pref[i+1] - pref[left] +pref[i+1] - pref[left+1]+pref[i+1] - pref[left+2]
 *                                         ==> this gives sum of all subarrays till index 5.
 *               rightsumforsecondElement = pref[i+2] - pref[left] +pref[i+2] - pref[left+1]+pref[i+2] - pref[left+2]
 *                                          ==> this gives sum of all subarrays till index 6.
 *
 *     So, if we generalise leftsum and all rightsums then it is something like below.
 *     4*(pref[i]+pref[i+1]+pref[i+2]) - 3*(pref[left]+pref[left+1]+pref[left+2]+pref[left+3])
 *     now what is this 4 and 3?
 *     before = i-left = 4-0 = 4
 *     after = right-i = 7-4= 3
 *
 *     if you see, the i has been incremented till i+2 -> i+(after-1)
 *     and left has been incremented till 3 -> i+(before-1)
 *
 *     therefore the final formula to calculate this would look like
 *
 *   ||==================================================================================================================================||
 *   ||  [before*(pref[i]+pref[i+1]+.....+pref[i+(after-1)])]-[after*(pref[left]+pref[left+1]+pref[left+2]+....+pref[left+(before-1)])]  ||
 *   ||==================================================================================================================================||
 *
 *
 * The above formula needs to be used with min values to achieve the ask of this problem.
 *
 * inorder to get pref[i]+pref[i+1]......+pref[i+(after-1)] ==> we need to calculate prefixSum of prefix array.
 * this helps in simplifying the caclculation
 *
 * so before*(prefpref[i
 *
 */
public class TotalStrengthWizards {
    private static final int MOD = (int) 1e9 + 7;;

    public int totalStrength(int[] strength) {
        int len = strength.length;
        // prefix sum of prefix sum
        // O(N)
        long[] prefix = new long[len + 1];
        long[] prefixofPrefix = new long[len + 1];
        for (int i = 0; i < len; ++i) {
            prefix[i+1] = (prefix[i] + strength[i]) % MOD;
            prefixofPrefix[i+1] = (prefixofPrefix[i] + prefix[i+1]) % MOD;
        }
        // mono stack to find the immediate right smaller element
        int[] rSmall = new int[len];
        Arrays.fill(rSmall, len);
        Deque <Integer> monoStk = new ArrayDeque <>();
        for (int i = 0; i < len; ++i) {
            while (!monoStk.isEmpty() && strength[monoStk.peek()] > strength[i]) {
                rSmall[monoStk.pop()] = i;
            }
            monoStk.push(i);
        }
        // mono stack to find the immediate left smaller (or equal) element
        int[] lSmall = new int[len];
        Arrays.fill(lSmall, -1);
        monoStk.clear();
        for (int i = len - 1; i >= 0; --i) {
            while (!monoStk.isEmpty() && strength[monoStk.peek()] >= strength[i]) {
                lSmall[monoStk.pop()] = i;
            }
            monoStk.push(i);
        }
        // compute & combine contributions of each element
        // rCount * (prefixofPrefix[i] - prefixofPrefix[Math.max(0, lSmall[i])]) - lCount * (prefixofPrefix[rSmall[i]] - prefixofPrefix[i])
        long ans = 0;
        for (int i = 0; i < len; ++i) {
            int s = strength[i];
            int before = i - lSmall[i];
            int after = rSmall[i] - i;
            long total = before * (prefixofPrefix[rSmall[i]] + MOD - prefixofPrefix[i]) % MOD + MOD
                       - after * (prefixofPrefix[i] + MOD - prefixofPrefix[Math.max(0, lSmall[i])]) % MOD;
            ans = (ans + (s * total) % MOD) % MOD;
        }
        return (int) ans;
    }
}
