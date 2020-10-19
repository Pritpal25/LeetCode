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
