/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 848 : 
 * 
 * We have a string S of lowercase letters, and an integer array shifts.

Call the shift of a letter, the next letter in the alphabet, (wrapping around so that 'z' becomes 'a'). 

For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.

Now for each shifts[i] = x, we want to shift the first i+1 letters of S, x times.

Return the final string after all such shifts to S are applied.

Example 1:

Input: S = "abc", shifts = [3,5,9]
Output: "rpl"
Explanation: 
We start with "abc".
After shifting the first 1 letters of S by 3, we have "dbc".
After shifting the first 2 letters of S by 5, we have "igc".
After shifting the first 3 letters of S by 9, we have "rpl", the answer.

Note:

    1 <= S.length = shifts.length <= 20000
    0 <= shifts[i] <= 10 ^ 9

 *  
 * 
 * @author bramanarayan
 * @date Jun 30, 2020
 */
public class ShiftingLetters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ShiftingLetters solution = new ShiftingLetters();
		//System.out.println(solution.shiftingLetters("abc",new int[] {3,5,9}));
		System.out.println(solution.shiftingLetters("ruu",new int[] {26,9,17}));

	}

	/**
	 * RIGHT SUM and TWO PASS, ASCII VALUE
	 */
	public String shiftingLetters(String s, int[] shifts) {

		int n = shifts.length;

		// Compute the right shift sum
		int[] rightSum = new int[n];
		rightSum[n - 1] = shifts[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			rightSum[i] = (rightSum[i + 1] + shifts[i]) % 26;

		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (i < n) {
				sb.append( (char) (( (s.charAt(i) - 'a' + rightSum[i]) % 26) + 'a'));
			} else {
				sb.append((char) s.charAt(i));
			}
		}

		return sb.toString();

	}

}
