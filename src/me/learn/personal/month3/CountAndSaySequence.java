/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 38 :
 * 
 *  The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence. You can do so recursively, in other words from the previous member read off the digits, counting the number of digits in groups of the same digit.

Note: Each term of the sequence of integers will be represented as a string.

 

Example 1:

Input: 1
Output: "1"
Explanation: This is the base case.

 * 
 * @author bramanarayan
 * @date Jun 26, 2020
 */
public class CountAndSaySequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CountAndSaySequence solution = new CountAndSaySequence();
		System.out.println(solution.countAndSay(5));
		System.out.println(solution.countAndSay(4));

		System.out.println(solution.getNextNumber("1121"));
	}

	public String countAndSay(int n) {

		int count = 1;
		String s = new String("1");
		while (count < n) {
			s = getNextNumber(s);
			count++;
		}
		return s;
	}
	
	
	public String getNextNumber(String s) {
		
		int i = 0, j = 0, tempCount = 0;
		StringBuilder sb = new StringBuilder();
		
		while (j < s.length()) {

			if (s.charAt(i) == s.charAt(j)) {
				tempCount++;
				j++;
			} else {
				sb.append(tempCount);
				sb.append(s.charAt(i));
				tempCount = 0;
				i =j;
			}
		}
		
		if(i !=j) {
			sb.append(tempCount);
			sb.append(s.charAt(i));
		}
		
		return sb.toString();

	}

}
