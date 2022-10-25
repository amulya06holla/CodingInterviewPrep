package com.leet.arrays.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * Monotonic stack approach
 * A monotonic stack is a stack whose elements are monotonically increasing or decreasing.
 * It contains all qualities that a typical stack has and its elements are all monotonic decreasing or increasing.
 */
//https://leetcode.com/problems/daily-temperatures/
public class DailyTemps {
    public static void main(String[] args) {
        int[] temperatures = new int[] {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }
    public static int[] dailyTemperatures(int[] temperatures) {

        int[] res = new int[temperatures.length];
        if(temperatures.length==1) return res;

        Stack<Integer> s = new Stack <>();
        s.push(0);
        int count=0;
        for(int i=1; i<temperatures.length; i++){
            while(!s.isEmpty()&&temperatures[i]>temperatures[s.peek()]){
                int t = s.pop();
                res[t]=i-t;
            }
            s.push(i);
        }
        return res;
    }
}
