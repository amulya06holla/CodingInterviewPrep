package com.leet.arrays.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class AllPermutation {
    public void backtrack(ArrayList<Integer> numList,
                          List<List <Integer>> output,
                          int n,int j) {
        // if all integers are used up, make a deep copy of the arraylist. otherwise it will get altered during backtracking
        if (j == n)
            output.add(new ArrayList<Integer>(numList));
        // we are keeping one value as constant and swapping the rest.
        // eg: in the first attempt, keep j=0. now iterate from i=j -> n and keep swapping.
        // in the second attempt, keep j=1. now iterate from i=j-> n. keep swapping.
        // look at the animation https://leetcode.com/problems/permutations/solution/
        for (int i = j; i < n; i++) {
            Collections.swap(numList, j, i);
            backtrack(numList, output, n, j + 1);
            Collections.swap(numList, j, i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        // init output list
        List<List<Integer>> res = new LinkedList();

        // convert nums into list since the output is a list of lists
        ArrayList<Integer> numList = new ArrayList <Integer>();
        for (int num : nums)
            numList.add(num);

        int n = nums.length;
        backtrack(numList, res, n,0);
        return res;
    }

    public static void main(String[] args) {
        AllPermutation ap = new AllPermutation();
        int[] nums = new int[]{1,2,3};
        ap.permute(nums);
    }
}
