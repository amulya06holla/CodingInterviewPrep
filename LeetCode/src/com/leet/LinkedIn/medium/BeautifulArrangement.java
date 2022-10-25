package com.leet.LinkedIn.medium;

//https://leetcode.com/problems/beautiful-arrangement/
public class BeautifulArrangement {
    int count = 0;
    public int countArrangement(int N) {
        int[] nums = new int[N];
        for (int i = 1; i <= N; i++)
            nums[i - 1] = i;
        permute(nums, 0);
        return count;
    }
    public void permute(int[] nums, int j) {
        if (j == nums.length) {
            count++;
        }
        for (int i = j; i < nums.length; i++) {
            swap(nums, i, j);
            if (nums[j] % (j + 1) == 0 || (j + 1) % nums[j] == 0)
                permute(nums, j + 1);
            swap(nums, i, j);
        }
    }
    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}


