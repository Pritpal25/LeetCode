/*
Say you have an array prices for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 */

public class Solution_122
{
    public int maxProfit(int[] prices) {
        int local_min = Integer.MAX_VALUE;
        int local_profit = 0;
        int net_profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < local_min) {
                local_min = prices[i];
                net_profit += local_profit;
                local_profit = 0;
            }
            else if (prices[i] - local_min > local_profit) {
                local_profit = prices[i] - local_min;
            }
            else if (prices[i] - local_min < local_profit) {
                net_profit += local_profit;
                local_profit = 0;
                local_min = prices[i];
            }
        }

        return net_profit + local_profit;
    }
}
