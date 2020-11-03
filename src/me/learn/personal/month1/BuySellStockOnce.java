package me.learn.personal.month1;

/**
 * 
 * Title : Say you have an array for which the ith element is the price of a
 * given stock on day i.
 * 
 * If you were only permitted to complete at most one transaction (i.e., buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 * 
 * Note that you cannot sell a stock before you buy one.
 * 
 * @author bramanarayan
 * @date May 15, 2020
 */
public class BuySellStockOnce {

	public static void main(String args[]) {
		BuySellStockOnce solution = new BuySellStockOnce();
		System.out.println(solution.maxProfit(new int[] {7,1,5,3,6,4}));
		System.out.println(solution.maxProfit(new int[] {7,6,4,3,1}));

	}

	// try to find the best day to buy.
	// Simulatenously, try to see the profit on every day if you sell the stock 
	// you acquired on best day 
	public int maxProfit(int[] prices) {
		
		if(prices.length < 2) return 0;
		int minima = prices[0];
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			if(prices[i] < minima) {
				minima = prices[i];
			}
			if(prices[i] - minima > profit) {
				profit = prices[i] - minima;
			}
		}
		return profit;
	}

}
