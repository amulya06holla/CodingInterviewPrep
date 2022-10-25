package com.leet.intuit;
//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {

        int start = 0, end = nums.length-1;
        int[] res = new int[] {-1,-1};

        while(start <= end)
        {
            int mid = (start + end) / 2;
            if(target <= nums[mid]) //  when it is equal, even then we are moving end towards left.
            {
                end = mid - 1;
            }else{
                start = mid + 1;
            }
            if(nums[mid] == target)
                res[0] = mid;
        }

        start = 0;
        end = nums.length-1;
        while(start <= end)
        {
            int mid = (start + end) / 2;
            if(target >= nums[mid])//  when it is equal, even then we are moving start towards right.
            {
                start = mid + 1;
            }else{
                end = mid - 1;
            }
            if(nums[mid] == target)
                res[1] = mid;
        }
        return res;
    }

    public static void main(String[] args) {
        SearchRange s = new SearchRange();
        int[] arr = new int[]{0,0};
        int target =8;
        int[] res = s.searchRange(arr, target);
        System.out.println(res[0]+" "+res[1] );
    }
}
