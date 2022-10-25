package com.leet.arrays.medium;

import java.util.*;

public class PermutateUnique {
    public static void main(String[] args) {
        PermutateUnique pu=new PermutateUnique();
        int[] nums = new int[]{1,1,2};
        System.out.println(pu.permuteUnique(nums));
    }

    public List<List <Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> results = new ArrayList <>();

            // count the occurrence of each number
            HashMap <Integer, Integer> counter = new HashMap<>();
            for (int num : nums) {
                counter.put(num, counter.getOrDefault(num,0) + 1);
            }

            LinkedList<Integer> comb = new LinkedList <>();
            this.backtrack(comb, nums.length, counter, results);
            return results;
    }

        protected void backtrack(
                LinkedList<Integer> comb,
                Integer N,
                HashMap<Integer, Integer> counter,
                List<List<Integer>> results) {

            if (comb.size() == N) {
                // make a deep copy of the resulting permutation,
                // since the permutation would be backtracked later.
                results.add(new ArrayList<Integer>(comb));
                return;
            }

            for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
                Integer num = entry.getKey();
                Integer count = entry.getValue();
                // because of backtracking, and updating the countervalue in each backtrack, this is necessary to avoid duplicates
                if (count == 0)
                    continue;
                // add this number into the current combination
                comb.addLast(num);
                counter.put(num, count - 1);

                // continue the exploration
                backtrack(comb, N, counter, results);

                // revert the choice for the next exploration
                comb.removeLast();
                counter.put(num, count);
            }
        }

}
