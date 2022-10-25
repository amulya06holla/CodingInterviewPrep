package com.leet.uber.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

//https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/
public class FinalPrices {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<prices.length; i++) {
            while (!stack.isEmpty()&&prices[stack.peek()]>=prices[i]) {
                prices[stack.pop()]-=prices[i];
            }
            stack.push(i);
        }
        return prices;
    }
}
