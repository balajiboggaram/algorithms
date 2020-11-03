/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 415 :
 * 
 * Given two non-negative integers num1 and num2 represented as string, return
 * the sum of num1 and num2.
 * 
 * Note:
 * 
 * The length of both num1 and num2 is < 5100. Both num1 and num2 contains only
 * digits 0-9. Both num1 and num2 does not contain any leading zero. You must
 * not use any built-in BigInteger library or convert the inputs to integer
 * directly.
 * 
 * 
 * @author bramanarayan
 * @date Jul 16, 2020
 */
public class AddStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		AddStrings solution = new AddStrings();
		System.out.println(solution.addStrings("88", "964"));
		
	}

	public String addStrings(String s1, String s2) {
		int n1 = s1.length()-1;
		int n2 = s2.length()-1;
		 
		int sum = 0, carry = 0;
		StringBuilder sb = new StringBuilder();
		while(n1 >= 0 || n2 >= 0) {
			
			int x1 = n1 >= 0 ? Integer.parseInt(String.valueOf(s1.charAt(n1))) : 0;
			int x2 = n2 >= 0 ? Integer.parseInt(String.valueOf(s2.charAt(n2))) : 0;
			
			
			sum = x1 + x2 + carry;
			sb.append(sum % 10);
			carry = sum / 10;
			n1--;
			n2--;
		}
		
		if(carry != 0) {
			sb.append(carry);
		}
		
		return sb.reverse().toString();
	}

}
