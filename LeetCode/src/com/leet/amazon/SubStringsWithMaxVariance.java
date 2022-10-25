package com.leet.amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * This is for anyone who, like me, had trouble understanding how the solution relates to Kadane's Algorithm. I apologize for the length of the comment!
 *
 * Recall that Kadane's Algorithm ('KA' below) calculates the maximum subarray of some array of numbers, say nums. It is a solution to LC 53: Maximum Subarray, and a great explanation of it can be found here. Below is a simple implementation of KA:
 *
 * public int maxSubArray(int[] nums) {
 *         if(nums==null || nums.length==0) return 0;
 *         int globalMax = Integer.MIN_VALUE;
 *         int localMax = 0;
 *
 *         for(int i = 0; i < nums.length; ++i) {
 *             localMax = Math.max(localMax + nums[i], nums[i]);
 *             globalMax = Math.max(globalMax, localMax);
 *         }
 *
 *         return globalMax;
 * }
 * KA is a dynamic programming procedure, and its key part is its transition function: localMax = Math.max(localMax + nums[i], nums[i]). Roughly, it says that the maximum subarray that ends with nums[i] is either the subarray consisting just of nums[i], or the maximum subarray up to that time, plus nums[i] as an additional last member.
 *
 * If we think about this function a bit more deeply, we can see that the Math.max() method is really a way of resizing the subarray to begin anew at nums[i]. That is, it's a way of discarding a previous partial candidate for the maximum subarray, and considering an entirely new one. It just so happens that the maximum subarray problem is simple enough such that the condition for resizing is simply when nums[i] > localMax + nums[i]. And this can be decided easily by Math.max(localMax + nums[i], nums[i]).
 *
 * With this said, KA's transition function maps onto @learn4Fun's algorithm as below:
 *
 * //This part corresponds to localMax + nums[i]...
 *
 * if(c == c1){
 *     c1Freq++;
 *     c1Remaining--;
 * }
 * if(c == c2)
 *     c2Freq++;
 *
 * //...while this part is responsible for resizing the array, and is
 * //thus similar to Math.max(localMax + nums[i], nums[i]):
 *
 * if(c2Freq < c1Freq && c1Remaining > 0) {
 *     c2Freq = 0;
 *     c1Freq = 0;
 * }
 *
 *
 * //More specifically,
 * //       localMax     +      nums[i]        is like:
 * // -------------------------------------
 * // (c2Freq - c1Freq)  +     1 (if c==c2)
 * // (c2Freq - c1Freq)  +  (-1) (if c==c1)
 *
 * // NOTE: c1Freq++ is equivalent to adding -1, since
 * // eventually we do c2Freq - c1Freq.
 *
 * //As for the subarray resizing, it occurs for us whenever the
 * //frequency of c2 is less than that of c1, since at each
 * //i-th iteration of the innermost for-loop, we are trying to find
 * //the maximum variance between c1 and c2 in s.substring(0,i+1),
 * //but only where the count of c2 is greater than that of c1.
 *
 * //Thus, when c2Freq < c1Freq, we're generally not interested in that
 * //substring. So, we resize our substring by setting c2Freq and
 * //c1Freq to 0. The only exception is where c1Rem == 0.
 * //In this case, e.g., where s=="baa", c1 == b, c2 == a, and we are
 * //on the first 'b', we want to keep the count of c1, though
 * //c1Freq > c2Freq, i.e., 1 (count of b's) > 0 (count of a's)).
 *
 * //This is because we may see further occurrences of c2 down the
 * //road where the count of c2 exceeds the count of c1, as we do in
 * //our example above. There, we eventually meet 2 a's that exceed the
 * //1 b. If we had resized the string prematurely, then we wouldn't be
 * //able to caclulate this variance.
 * One final note is that we update max only when c1Freq > 0 and c2Freq > 0, i.e., only when both characters whose variance we are computing are present in our substring. This is unlike KA, where we update the globalMax at each iteration. But this is simply because, again, our conditions for the maximum variance are more complex than the conditions for the maximum subarray.
 */
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/discuss/39038/Kadane's-Algorithm-Since-no-one-has-mentioned-about-this-so-far-%3A
//https://leetcode.com/problems/substring-with-largest-variance/discuss/2661972/Java-w-Detailed-Comments-Kadane's-Algorithm-w-O(N)-Time-and-O(1)-Space
// READ JS81'S explanation in the comment -> https://leetcode.com/problems/substring-with-largest-variance/discuss/2297768/Java-or-Kadane's-Algorithm-or-Easy-to-understand

public class SubStringsWithMaxVariance {
    // solving this problem based on kadane's algo.
    // Time Complexity:- O(26*26*N) -> Generalized to O(N) NOTE: The O(26*26) would remain same irrespective of the size of the input. hence that can be approximated to O(1)
    // Space Complexity:- O(26) -> Generalized to O(1) NOTE: whenever the space that is utilized doesnt alter based on the input. the space complexity is approximated to O(1).

    public int largestVariance(String s) {
        // Maintain a map of freq of characters in the string (Max of 26 chars)
        Map <Character, Integer> map = new HashMap <>();
        for(char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        int max=0;
        // Check for every possible pair of characters in the map with the assumption that the one char is greater than the other
        // In the following piece of code, assuming c2 count is greater than c1
        for(char c1 : map.keySet()){ //max of 26
            for(char c2 : map.keySet()){ // max of 26
                // If both the characters are same then we don't explore any further
                if(c1 == c2)
                    continue;
                int c1Freq=0, c2Freq=0;
                // we are keeping track of any one of the chars.
                // this will help us to decide if we can find the variance even if we make the currentSum as zero and by looping any forward
                int c1Remaining=map.get(c1); // Keep track of the remaining c1 chars

                // Iterate through all the characters in the string
                for(char c : s.toCharArray()){
                    if(c == c1){
                        c1Freq++;
                        c1Remaining--;
                    }
                    if(c == c2)
                        c2Freq++;

                    // If c2-count < c1-count then we reset the counters, only if we know there are more c1 chars to come in the iteration
                    // c1Remaining check is required for the test case "baa" and c1=b && c2=a. We don't reset the counters if there are no more c1 chars left
                    if(c2Freq < c1Freq && c1Remaining > 0) {
                        c2Freq=0;
                        c1Freq=0;
                    }

                    // Calculate variance of current substring and update max accordingly
                    if(c1Freq > 0 && c2Freq > 0)
                        max = Math.max(max, c2Freq-c1Freq);
                }
            }
        }
        return max;
    }
}

