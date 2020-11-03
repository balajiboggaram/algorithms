package me.learn.personal.month1;

public class PalindromeNumber {

	public static void main(String args[]) {
		System.out.println(isPalindrome(121));
		System.out.println(isPalindrome(-121));
		System.out.println(isPalindrome(-2147483648));

	}

	public static boolean isPalindrome(int x) {

		if (x < 0)
			return false;
		int n = x;
		if (n == Integer.MIN_VALUE || n == Integer.MAX_VALUE)
			return false;

		int reverse = 0;
		while (n != 0) {
			int lastDigit = n % 10;
			reverse = reverse * 10 + lastDigit; // append the last digit
			n = n / 10; // so that we just remove the last digit
		}
		return x == reverse;
	}

	public static boolean isPalindromeMy(int x) {

		if (x == Integer.MIN_VALUE || x == Integer.MAX_VALUE)
			return false;

		String s = ItoA.iToa(x);
		int l = 0;
		int r = s.length() - 1;

		while (l < r) {
			if (s.charAt(l) != s.charAt(r))
				return false;
			l++;
			r--;
		}
		return true;
	}

}
