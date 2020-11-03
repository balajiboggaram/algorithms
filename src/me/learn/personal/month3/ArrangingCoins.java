/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 441 :
 * 
 * You have a total of n coins that you want to form in a staircase shape, where
 * every k-th row must have exactly k coins.
 * 
 * Given n, find the total number of full staircase rows that can be formed.
 * 
 * n is a non-negative integer and fits within the range of a 32-bit signed
 * integer.
 * 
 * Example 1:
 * 
 * n = 5
 * 
 * The coins can form the following rows: ¤ ¤ ¤ ¤ ¤
 * 
 * Because the 3rd row is incomplete, we return 2.
 * 
 * Example 2:
 * 
 * n = 8
 * 
 * The coins can form the following rows: ¤ ¤ ¤ ¤ ¤ ¤ ¤ ¤
 * 
 * Because the 4th row is incomplete, we return 3.
 * 
 * 
 * @author bramanarayan
 * @date Jul 1, 2020
 */
public class ArrangingCoins {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrangingCoins solution = new ArrangingCoins();
		System.out.println(solution.arrangeCoins(5));
		System.out.println(solution.arrangeCoins(8));
		System.out.println(solution.arrangeCoins(6));
		System.out.println(solution.arrangeCoins(2));

	}
	
	// LINEAR TIME
	public int arrangeCoins(int n) {
		if (n < 1)
			return 0;
		for (int i = 1;; i++) {
			n -= i;
			if (n < 0)
				return i - 1;
		}
	}
	

	// BINARY Search
	// 1 + 2 + 3 + ... + k = k(k+1)/2
	// so we need to find a k such that k(k+1)/2 is greater than n
	public int arrangeCoinsBinary(int n) {
		
		int low = 0;
		int high = n;
		
		if(n ==0) return 0;
		while(low <= high) {
					
			int mid = low + (high - low)/2; // same as k
			int sum  = (mid * (mid +1))/2;
			
			if( sum > n) {
				high = mid -1;
			} else {
				low = mid + 1;
			}
			
		}
		
		return low -1;
		
	}

}
