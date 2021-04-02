/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 1134 :
 * 
 * Date : Jan 6, 2021
 * 
 * @author bramanarayan
 *
 */
public class ArmstrongNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArmstrongNumber solution = new ArmstrongNumber();
		System.out.println(solution.isArmstrong(153));
	}

	/**
	 * Input: 153 Output: true Explanation: 153 is a 3-digit number, and 153 = 1^3 +
	 * 5^3 + 3^3.
	 */
	public boolean isArmstrong(int N) {
		
		String s = String.valueOf(N);
		int n = s.length();
		int sum = 0;
		for(char c : s.toCharArray()) {
			sum += (int) Math.pow(c-'0', n);
		}
		return sum == N;

	}

}
