package me.learn.personal.month1;

/**
 * 
 * Title : Convert a given integer to ASCII
 * 
 * @author bramanarayan
 * @date Apr 21, 2020
 */
public class ItoA {

	public static void main(String args[]) {
		iToa(42);
		iToa(6454);
		iToa(-12344);
		iToa(-1);
	}
	
	public static String iToa(int n) {
	
		StringBuilder sb = new StringBuilder();
		String result ;
		int sign = 1;
		if( n < 0) {
			sign = -1;
			n = n * sign;
		}
		
		while (n > 0) {
			sb.append(n % 10);
			n = n / 10;
		}
		result =  sign == -1 ? "-" + sb.reverse().toString() : sb.reverse().toString();
		System.out.println("String is : " + result);
		return result;
	}
	
}
