Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
Brute Force Approach
Intuition:
The problem requires us to find the maximum profit possible from a series of 
stock prices where you can buy and sell once. Using a brute force approach, we 
can try all possible combinations of buying and selling days and compute the profit
 for each combination. The maximum of these profits will be our answer.
 Time Complexity: O(n^2) due to the two nested loops. Space Complexity: O(1) as no extra space is used.

public class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        // Iterate through each day as buy day
        for (int i = 0; i < prices.length; i++) {
            // Iterate through each day after the buy day as sell day
            for (int j = i + 1; j < prices.length; j++) {
                // Calculate the profit by selling on the jth day after buying on ith day
                int profit = prices[j] - prices[i];
                // Update maxProfit if this profit is greater than seen before
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }
}

Optimized One Pass Approach
Intuition:

Instead of trying all possible pairs of buy and sell days, 
we can iterate through the list of prices once while keeping track 
of the minimum price encountered so far. At each step, we calculate 
what the profit would be if we sold at the current price, and update the 
maximum profit correspondingly.
Time Complexity: O(n) since we only pass through the prices array once. Space Complexity: O(1) as no additional space is required beyond a few variables.

public class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            // Update the minimum price so far
            if (price < minPrice) {
                minPrice = price;
            }
            // Calculate the potential profit
            int profit = price - minPrice;
            // Update the maximum profit found so far
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
}