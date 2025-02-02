/**
 * You are given an array prices where prices[i] is the price of a given stock
 * on the ith day.
 * 
 * Find the maximum profit you can achieve. You may complete as many
 * transactions as you like (i.e., buy one and sell one share of the stock
 * multiple times) with the following restrictions:
 * 
 * After you sell your stock, you cannot buy stock on the next day (i.e.,
 * cooldown one day).
 * Note: You may not engage in multiple transactions simultaneously (i.e., you
 * must sell the stock before you buy again).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: prices = [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 * Example 2:
 * 
 * Input: prices = [1]
 * Output: 0
 * 
 * 
 * Constraints:
 * 
 * 1 <= prices.length <= 5000
 * 0 <= prices[i] <= 1000
 * Accepted
 * 280,687
 * Submissions
 * 533,323
 * Seen this question in a real interview before?
 */
class Solution {
    public int maxProfit(int[] prices) {
        int buy = -prices[0], sell = 0, cooldown = 0;
        for (int i = 1; i < prices.length; i++) {
            int newBuy = cooldown - prices[i];
            int newSell = buy + prices[i];
            cooldown = Math.max(cooldown, sell);
            buy = Math.max(buy, newBuy);
            sell = Math.max(sell, newSell);
        }
        return sell;
    }
}