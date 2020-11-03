package me.learn.personal.month1;

/**
 * 
 * Title : Convert the given integer in range of 1 to 3999 to a Roman numeral.
 * 
 * @author bramanarayan
 * @date Apr 27, 2020
 */
public class IntegerToRoman {

	public static void main(String args[]) {
		IntegerToRoman solution = new IntegerToRoman();
		solution.intToRoman(1);
		solution.intToRoman(4);
		solution.intToRoman(3);
		solution.intToRoman(6);
		solution.intToRoman(9);
		solution.intToRoman(10);
		solution.intToRoman(15);
		solution.intToRoman(39);
		solution.intToRoman(50);
		solution.intToRoman(58);
		solution.intToRoman(1994);

	}

	public String intToRoman(int n) {
		if (n <= 0)
			return null;

		int input = n;
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			if (n > 1000 && n <= 3999) {
				sb.append(append('M', n / 1000));
				n = n % 1000;
			} else if (n == 1000) {
				sb.append('M');
				n = n % 1000;
			} else if (n >= 900 && n < 1000) {
				sb.append("CM");
				n = n % 100;
			} else if (n > 500 && n < 900) {
				sb.append('D');
				n = n % 500;
			} else if (n == 500) {
				sb.append('D');
				n = n % 500;
			} else if (n >= 400 && n < 500) {
				sb.append("CD");
				n = n % 100;
			} else if (n > 100 && n < 400) {
				sb.append(append('C', n / 100));
				n = n % 100;
			} else if (n == 100) {
				sb.append("C");
				n = n % 100;
			} else if (n >= 90 && n < 100) {
				sb.append("XC");
				n = n % 10;
			} else if (n > 50 && n < 90) {
				sb.append(append('L', n / 50));
				n = n % 50;
			} else if (n == 50) {
				sb.append("L");
				n = n % 50;
			} else if (n >= 40 && n < 50) {
				sb.append("XL");
				n = n % 10;
			} else if (n > 10 && n < 40) {
				sb.append(append('X', n / 10));
				n = n % 10;
			} else if (n == 10) {
				sb.append("X");
				break;
			} else if (n == 9) {
				sb.append("IX");
				break;
			} else if (n > 5 && n < 9) {
				sb.append("V");
				n = n % 5;
			} else if (n == 5) {
				sb.append("V");
				n = n % 5;
			} else if (n == 4) {
				sb.append("IV");
				break;
			} else if (n > 0 && n < 4) {
				sb.append(append('I', n));
				break;
			}
		}

		System.out.println(String.format("The result of %d is %s", input, sb.toString()));
		return sb.toString();
	}

	private String append(char c, int x) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < x; i++) {
			sb.append(c);
		}
		return sb.toString();
	}

}
