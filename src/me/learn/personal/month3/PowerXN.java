/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 50 :
 * 
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 * 
 * Example 1:
 * 
 * Input: 2.00000, 10 Output: 1024.00000
 * 
 * Example 2:
 * 
 * Input: 2.10000, 3 Output: 9.26100
 * 
 * Example 3:
 * 
 * Input: 2.00000, -2 Output: 0.25000 Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * 
 * 
 * @author bramanarayan
 * @date Jul 16, 2020
 */
public class PowerXN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PowerXN solution = new PowerXN();
		System.out.println(solution.myPow(2.00000, 10));
		System.out.println(solution.myPow(2.00000, 2));
		System.out.println(solution.myPow(2.00000, -2));
		System.out.println(solution.myPow(0.00001, 2147483647));

	}

	// RECURSION
	public double myPow(double x, int n) {

		double ans = myPowUtil(x, n);
		System.out.println("Answer : " + ans);
		if(n < 0) {
			return 1/ans;
		} 
		return ans;
	
	}
	
	public double myPowUtil(double x , int n ) {
		if(x == 0) return 1;
			
		if ( x==1 || n == 0)
			return 1;
		
		double half = myPowUtil(x, n/2);
		
		if(n %2 ==0) {
			return half * half;
		} else {
			return x *  half * half;
		}
	}

}
