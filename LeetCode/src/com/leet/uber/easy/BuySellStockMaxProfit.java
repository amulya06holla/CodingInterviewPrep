package com.leet.uber.easy;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BuySellStockMaxProfit {
    public static void main(String[] args) {
        BuySellStockMaxProfit t = new BuySellStockMaxProfit();
        int[] prices = new int[]{1,1,1};
        System.out.println(t.maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        if(prices.length<2) return 0;
        int maxprofit =0;
        int max=Integer.MIN_VALUE; int min =Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){

            if(prices[i]>max)
                max=prices[i];
            if(prices[i]<min) {
                min=prices[i];
                max=Integer.MIN_VALUE;
            }
            if(max!=Integer.MIN_VALUE && min!=Integer.MAX_VALUE)
            maxprofit = Math.max(maxprofit, max-min);
        }
        return maxprofit;
    }
}
