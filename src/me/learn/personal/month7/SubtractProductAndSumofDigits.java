/**
 * 
 */
package me.learn.personal.month7;

/**
 * Title 1281 :
 * 
 * Date : Feb 25, 2021
 * 
 * @author bramanarayan
 *
 */
public class SubtractProductAndSumofDigits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SubtractProductAndSumofDigits solution = new SubtractProductAndSumofDigits();
		System.out.println(solution.subtractProductAndSum(234));
	}

	public int subtractProductAndSum(int n) {

		int product = 1;
		int sum = 0;
		while (n > 0) {
			int rem = n % 10;
			product *= rem;
			sum += rem;
			n = n/10;
		}
		return product - sum;

	}

}
