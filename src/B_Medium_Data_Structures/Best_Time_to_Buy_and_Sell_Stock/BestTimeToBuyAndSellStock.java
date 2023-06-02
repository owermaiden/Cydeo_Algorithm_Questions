package B_Medium_Data_Structures.Best_Time_to_Buy_and_Sell_Stock;

public class BestTimeToBuyAndSellStock {
    /*
    121. Best Time to Buy and Sell Stock
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.

Constraints:
    1 <= prices.getLength <= 105
    0 <= prices[i] <= 104

https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    */
    public static void main(String[] args) {
        int[] ints = {7, 1, 5, 3, 6, 4};
        System.out.println(withBruteForce(ints));
    }

    // Time Complexity: O (n^2)
    // Space Complexity: O (1)
    static int withBruteForce(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    int diff = prices[j] - prices[i];
                    if (diff > max)
                        max = diff;
                }
            }
        }
        return max;
    }

    // Time Complexity: O (n)
    // Space Complexity: O (1)
    static int withOneLoop(int[] prices) {
        int minBuy = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            minBuy = Math.min(minBuy, prices[i]);
            int tempProfit = prices[i] - minBuy;
            maxProfit = Math.max(maxProfit, tempProfit);
        }
        return maxProfit;
    }



    // other solutions:

    // Time Complexity: O (n)
    // Space Complexity: O (1)
    public int withForEachLoop(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profitSoFar =0;
        int currentProfit;
        for (int price : prices) {
            if (price < min) min = price;
            currentProfit = price - min;
            if (currentProfit > profitSoFar)
                profitSoFar = currentProfit;
        }
        return profitSoFar;
    }
}
