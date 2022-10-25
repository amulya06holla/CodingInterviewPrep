package com.leet.amazon;
/**
 * Note: nums.clone() to clone the input array.
 *
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SmallerNumbersThanCurrent {
    public static void main(String[] args) {
        int[] nums = new int[]{8, 1, 2, 2, 3};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        int[] temp = nums.clone();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Arrays.sort(temp);
        for (int i = 0; i < temp.length; i++) {
            if(map.containsKey(temp[i])){
                continue;
            }
                map.put(temp[i],i);
        }

        for (int j= 0; j < nums.length; j++) {
           res[j] = map.get(nums[j]);
        }
        return res;
    }
}
