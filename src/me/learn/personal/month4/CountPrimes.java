/**
 * 
 */
package me.learn.personal.month4;

import java.util.Arrays;

/**
 * Title 204 : Sieve of Erathosenes
 * 
 * Count the number of prime numbers less than a non-negative number, n.
 * 
 * Example:
 * 
 * Input: 10 Output: 4 Explanation: There are 4 prime numbers less than 10, they
 * are 2, 3, 5, 7.
 * 
 * 
 * 
 * @author bramanarayan
 * @date Aug 21, 2020
 */
public class CountPrimes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		CountPrimes solution = new CountPrimes();
		System.out.println(solution.countPrimes(10));
		System.out.println("Answer : " + solution.countPrimes(16));

		System.out.println(solution.countPrimes(3));

	}

	// Sieve the sieve... !!!
	public int countPrimes(int n) {
		
		if(n ==2 || n ==1) return 0;

		boolean[] prime = new boolean[n+1];
		Arrays.fill(prime, true);
		
		int count = 0;
		for (int i = 2; i * i <= n; i++) {
			
			if(prime[i] == true) {
				for (int j = i * i; j <= n; j += i) {
					prime[j] = false;
				}
			}
		}

		for(int i = 2;i<n;i++) {
			if(prime[i] == true) {
				count++;

			}
		}
		return count;

	}

}
