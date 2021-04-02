/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 309 :
 * 
 * Date : Dec 22, 2020
 * 
 * @author bramanarayan
 *
 */
public class BuySellStockWithCoolDown {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// ends with buy ?
	// ends with sell ?
	// Maximum profit obtained. you cannot buy anything on a day after you sell the
	// stock
	public int maxProfit(int[] prices) {
		
		

		int n = prices.length;
		
		if(n <= 1) return 0;
		
		
		int[] buy = new int[n];
		int[] sell = new int[n];

		// init. Negative is here because - imagine like the amount of money you have on
		// hand.
		// if you buy stock at price[0], that means you gave that money to buy
		// something. its a like net cash on hand
		buy[0] = -prices[0];
		buy[1] = -Math.min(prices[0], prices[1]); // you buy minimum of two.
		sell[1] = Math.max(0, buy[0] + prices[1]); // profit on day1 = buy price on day 0 and sell on day 1

		for (int i = 2; i < n; i++) {
			buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
			sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
		}

		return sell[n - 1];

	}

}
