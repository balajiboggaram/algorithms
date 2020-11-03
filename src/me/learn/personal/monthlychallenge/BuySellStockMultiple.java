/**
 * 
 */
package me.learn.personal.monthlychallenge;

/**
 * Title : Best Time to Buy and Sell Stock II (Multiple times)
 * 
 * @author bramanarayan
 * @date May 1, 2020
 */
public class BuySellStockMultiple {

	public static void main(String[] args) {
		BuySellStockMultiple solution = new BuySellStockMultiple();
		solution.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 });
		solution.maxProfit(new int[] { 1,2,3,4,5 });

	}

	 public int maxProfit(int[] prices) {
			int n = prices.length;
			if (n < 2)
				return 0;
			int i = 0, localMinima = 0, localMaxima = 0, result = 0;
			while (i < n-1) {
				// Find local minima
				while (i < n-1) {
					if (prices[i] >= prices[i + 1]) {
						i++;
					} else {
						break;
					}
				}
				localMinima = i;

				// Find local maxima
				while (i < n-1) {
					if (prices[i + 1] > prices[i]) {
						i++;
					} else {
						break;
					}
				}
				localMaxima = i;
				result += (prices[localMaxima] - prices[localMinima]);
				i++;
			}
			System.out.println(result);
			return result;
		}

}
