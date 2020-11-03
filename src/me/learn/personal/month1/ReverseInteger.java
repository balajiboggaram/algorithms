package me.learn.personal.month1;

/**
 * 
 * Title : Reverse an integer
 * 
 * @author bramanarayan
 * @date Apr 24, 2020
 */
public class ReverseInteger {

	public static void main(String[] args) {

		ReverseInteger solution = new ReverseInteger();
		solution.reverse(123);
		solution.reverse(636);
		solution.reverse(-12345);
		solution.reverse(1534236469);

		System.out.println(solution.reverse(-2147483412));
		System.out.println(solution.reverse(-1563847412));

	}

	public int reverse(int n) {
		boolean isNegative = false;
		if (n < 0) {
			isNegative = true;
			n = -1 * n;
		}
		int result = 0, newresult =0;
		while (n != 0) {
			int rem = n % 10;
			newresult = result * 10 + rem;
			if(result != (newresult - rem) /10) {
				//  overflow detector from positive to negative or negative to positive
				return 0;
			}
			result = newresult;
			n = n / 10;
		}
		result = isNegative ? -1 * result : result;
		return result;
	}

}
