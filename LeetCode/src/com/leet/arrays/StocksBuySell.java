package com.leet.arrays;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

public class StocksBuySell {
    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    // can buy and sell only once.
        public static int maxProfit(int prices[]) {
            int minprice = Integer.MAX_VALUE;
            int maxprofit = 0;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < minprice)
                    minprice = prices[i];
                else if (prices[i] - minprice > maxprofit)
                    maxprofit = prices[i] - minprice;
            }
            return maxprofit;
        }

    public static int maxProfit2(int prices[]) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1] )
                maxprofit+= prices[i] - prices[i-1];
        }
        return maxprofit;
    }
}
