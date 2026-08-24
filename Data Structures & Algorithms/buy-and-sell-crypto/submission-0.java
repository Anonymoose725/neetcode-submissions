class Solution {
    public int maxProfit(int[] prices) {
        // buy low, sell high after!
        int lowDay = 0; // indices
        int highDay = 1;
        int maxProfit = 0;
        
        while (highDay < prices.length) {
            if (prices[highDay] > prices[lowDay]) {
                // calculate potential profit
                int profit = prices[highDay] - prices[lowDay];
                maxProfit = Math.max(profit, maxProfit);
            }
            else {
                // found a cheaper price, so buy on the new day
                lowDay = highDay;
            }
            // try next
            highDay++;
        }
        return maxProfit;
    }    
}
