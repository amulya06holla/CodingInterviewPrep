package com.leet.LinkedIn.medium;
//https://leetcode.com/problems/sort-transformed-array/
public class SortTransformedArray {
    /**
     * It is parabolic relation.
     * After convert nums to a*x^2 + bx + c.
     * If a > 0, there will be bottom in the arr; if a < 0, there it top in the arr.
     * Find the bottom or top then go left and right.
     *
     * https://leetcode.com/problems/sort-transformed-array/discuss/515447/Java-Code-with-Graph-showing-both-agreater0-and-aless0
     *
     */
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int result[] = new int[nums.length];
        int i = 0, j = nums.length - 1;
        if(a > 0){ // if a>0, then fill the res array from left to right. hence index = res.length-1
            int index = result.length - 1;
            while(i <= j){
                int left = a*nums[i]*nums[i] + b*nums[i] + c;
                int right = a*nums[j]*nums[j] + b*nums[j] + c;
                // whichever is greater put that value. since we are going from index = result.length-1.
                if(left < right){
                    result[index--] = right;
                    j--;
                }
                else{
                    result[index--] = left;
                    i++;
                }
            }
        }
        else{
            int index = 0;// if a<=0, then fill the res array from right to left. hence index = 0
            while(i <= j){
                int left = a*nums[i]*nums[i] + b*nums[i] + c;
                int right = a*nums[j]*nums[j] + b*nums[j] + c;
                // whichever is smaller put that value. since we are going from index = 0.
                if(left < right){
                    result[index++] = left;
                    i++;
                }
                else{
                    result[index++] = right;
                    j--;
                }
            }
        }
        return result;
    }
}
