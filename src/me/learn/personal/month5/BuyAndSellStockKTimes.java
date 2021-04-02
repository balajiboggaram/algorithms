/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 188 :
 * 
 * Date : Dec 22, 2020
 * 
 * @author bramanarayan
 *
 */
public class BuyAndSellStockKTimes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// k -> atmost number of transactions that you can complete
	// Kick as* DP problem
	public int maxProfit(int k, int[] prices) {
		
		

		// profit[t,i] = profit[t,i-1] // I dont do i'th transaction
		// profit[t,i] = Max( profit[t-1,j] + price[i] - price[j]) , such that j ranges
		// from 0 to i.
		int n = prices.length;

		
		if(n <=1) return 0;
		
		int[][] profit = new int[k + 1][n + 1];

		// For day 0, you can't earn money
		// irrespective of how many times you trade
		for (int i = 0; i <= k; i++) {
			profit[i][0] = 0;
		}

		// profit is 0 if we don't do any
		// transation (i.e. k =0)
		for (int j = 0; j <= n; j++) {
			profit[0][j] = 0;
		}
		// fill the table in  
        // bottom-up fashion 
        for (int i = 1; i <= k; i++)  // atmost transactionsal allowed
        { 
            for (int j = 1; j < n; j++)  // days of transactions
            { 
                int max_so_far = 0; 
  
                for (int m = 0; m < j; m++) 
                	// i-1 transactions profit + ith transaction profit. For ith -> you cnned  
                max_so_far = Math.max(max_so_far, prices[j] - prices[m] + profit[i - 1][m]); // You do jth transaction. i.e sell on j'th day, buy on mth day
  
                profit[i][j] = Math.max(profit[i] [j - 1], max_so_far); // You don't do jth transaction
            } 
        } 
  
		return profit[k][n - 1];

	}

}
