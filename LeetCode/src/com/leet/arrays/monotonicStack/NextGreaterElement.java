package com.leet.arrays.monotonicStack;

import java.util.Arrays;
import java.util.Stack;

//https://www.geeksforgeeks.org/next-greater-element/
public class NextGreaterElement {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack <>();
        for(int i=0; i< nums.length;i++){
            if (!stack.isEmpty()) {
                while (!stack.isEmpty()&&nums[stack.peek()]<nums[i]) {
                    res[stack.peek()]=nums[i];
                    stack.pop();
                }
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            res[stack.peek()]=-1;
            stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,2,25};
        NextGreaterElement n = new NextGreaterElement();
        System.out.println(Arrays.toString(n.nextGreaterElements(arr)));
    }
}
