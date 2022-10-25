package com.leet.LinkedIn.medium;
//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class StartingEndingPointOfElement {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirstElement( nums,  target);
        result[1] = findLastElement( nums,  target);
        return result;
    }

    public int findFirstElement(int[] nums, int target){
        int index = -1;
        int start = 0;
        int end = nums.length -1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] >= target){  // we are checking if mid is "GREATER OR EQUAL" to target
                end = mid -1;
            }else{
                start = mid + 1;
            }
            if(nums[mid] == target) index = mid;
        }
        return index;
    }

    public int findLastElement(int[] nums, int target){
        int index = -1;

        int start = 0;
        int end = nums.length -1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] > target){ // we are checking if mid is " ONLY GREATER" to target
                end = mid -1;
            }else{
                start = mid + 1;
            }
            if(nums[mid] == target) index = mid;
        }
        return index;
    }
}
