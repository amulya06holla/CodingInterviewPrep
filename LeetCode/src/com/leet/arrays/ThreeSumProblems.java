package com.leet.arrays;

import java.util.*;

//https://leetcode.com/problems/3sum/
//https://leetcode.com/problems/3sum-closest/
//https://leetcode.com/problems/3sum-smaller/

public class ThreeSumProblems {
    public static void main(String[] args) {
        //int[] nums = new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4};
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        ThreeSumProblems ts = new ThreeSumProblems();
        System.out.println(Arrays.toString(ts.threeSum(nums).toArray()));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        int n = nums.length;
        if(n<3) return resList;

        Map<Integer, Integer> mapCount = new HashMap<>();
        for(int i=0; i<n;i++){
            int count =0;
            if(mapCount.containsKey(nums[i])){
                count = mapCount.get(nums[i]);
            }
            mapCount.put(nums[i], count+1);
        }
        List<String> temp = new ArrayList<>();
        for(int i=0; i<n;i++){
            for(int j=0; j<i;j++){
                if(i!=j){
                    int req = 0 -(nums[i]+nums[j]);
                    if(mapCount.containsKey(req)&& (mapCount.get(req)>1 || (nums[i]!=req &&nums[j]!=req)) || (req==nums[i] && req==nums[j] && mapCount.get(req)>2)){

                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(req);
                        Collections.sort(list);
                        String s = Arrays.toString(list.toArray());
                        if(!temp.contains(s)) {
                            temp.add(s);
                            resList.add(list);
                        }
                    }
                }
            }
        }

        return resList;
    }

//https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/611/week-4-july-22nd-july-28th/3828/
    public int threeSumClosest(int[] nums, int target)  {
        int diff = Integer.MAX_VALUE, sz = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < sz && diff != 0; ++i) {
            int lo = i + 1, hi = sz - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (Math.abs(target - sum) < Math.abs(diff))
                    diff = target - sum;
                if (sum < target)
                    ++lo;
                else
                    --hi;
            }
        }
        return target - diff;
    }

}
