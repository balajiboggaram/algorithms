/**
 * 
 */
package me.learn.personal.month4;

/**
 * Title 29 :
 * 
 * Divide two integers without using any * / or mod operator
 * 
 * @author bramanarayan
 * @date Aug 2, 2020
 */
public class DivideTwoIntegers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DivideTwoIntegers solution = new DivideTwoIntegers();
		System.out.println(solution.divide(10, 3));
		System.out.println(solution.divide(75, 3));
		System.out.println(solution.divide(-75, 3));
		System.out.println(solution.divide(-75, -3));

	}

	public int divide(int dividend, int divisor) {
		
		if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
		
		int a = Math.abs(dividend);
		int b = Math.abs(divisor);
		int res = 0;

		while (a - b >= 0) {
			int x = 0;
			while (a - (b << 1 << x) >= 0) {
				x++;
			}
			res += (1 << x); // power(2,x) times
			a = a - (b << x); // decrease a by power(2,b) times
		}
		return ((dividend >= 0) && (divisor >= 0)) || (  dividend < 0 && divisor < 0) ? res : -res;
	}
	

}
