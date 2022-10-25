package com.leet.dynamicProgramming.medium;
//https://leetcode.com/problems/house-robber/
public class HouseRobber {
    public int rob1(int[] nums) {
        if (nums.length == 1) return nums[0];
        int res=0;
        int skippedHouse = nums[0];
         res = Math.max(nums[0], nums[1]);
        for(int i = 2; i<nums.length; i++) {
            int maxValue = Math.max(skippedHouse + nums[i], res); // skippedhouse is the i-2th house which wasnt considered.
            skippedHouse = res;
            res = maxValue;
        }
        return res;
    }

    /**
     * Since House[1] and House[n] are adjacent, they cannot be robbed together. Therefore, the problem becomes to rob either House[1]-House[n-1] or House[2]-House[n], depending on which choice offers more money.
     * Now the problem has degenerated to the House Robber, which is already been solved.
     * @param nums
     * @return
     */
    //https://leetcode.com/problems/house-robber-ii/
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;

        if (nums.length == 1)
            return nums[0];

        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        int max1 = rob_simple(nums, 0, nums.length - 2);
        int max2 = rob_simple(nums, 1, nums.length - 1);

        return Math.max(max1, max2);
    }

    public int rob_simple(int[] nums, int start, int end) {
        if (start-end == 1) return nums[start];
        int res=0;
        int skippedHouse = nums[start];
        res = Math.max(nums[start], nums[start+1]);
        for(int i = start+2; i<=end; i++) {
            int maxValue = Math.max(skippedHouse + nums[i], res); // skippedhouse is the i-2th house which wasnt considered.
            skippedHouse = res;
            res = maxValue;
        }
        return res;
    }


    public int robWithAdditionalSpace(int[] nums) {
        int[] dp = new int[nums.length];
        if(nums.length==1)
        {
            return nums[0];
        }
        if(nums.length==2)
        {
            return Math.max(nums[0],nums[1]);
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);


        for(int i=2;i<nums.length;i++)
        {
            //store the max value of current value + dp[i-2] and dp[i-1]
            dp[i] = Math.max((nums[i]+dp[i-2]),dp[i-1]);

        }

        return dp[nums.length-1];
    }


}
