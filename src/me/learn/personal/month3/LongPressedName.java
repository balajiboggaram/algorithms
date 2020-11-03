/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 925 :
 * 
 * Your friend is typing his name into a keyboard. Sometimes, when typing a
 * character c, the key might get long pressed, and the character will be typed
 * 1 or more times.
 * 
 * You examine the typed characters of the keyboard. Return True if it is
 * possible that it was your friends name, with some characters (possibly none)
 * being long pressed.
 * 
 * Example 1:
 * 
 * Input: name = "alex", typed = "aaleex" Output: true Explanation: 'a' and 'e'
 * in 'alex' were long pressed.
 * 
 * Example 2:
 * 
 * Input: name = "saeed", typed = "ssaaedd" Output: false Explanation: 'e' must
 * have been pressed twice, but it wasn't in the typed output.
 * 
 * Example 3:
 * 
 * Input: name = "leelee", typed = "lleeelee" Output: true
 * 
 * Example 4:
 * 
 * Input: name = "laiden", typed = "laiden" Output: true Explanation: It's not
 * necessary to long press any character.
 * 
 * 
 * @author bramanarayan
 * @date Jul 12, 2020
 */
public class LongPressedName {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		LongPressedName solution = new LongPressedName();
		System.out.println(solution.isLongPressedName("pyplrz", "ppyypllr"));

		System.out.println(solution.isLongPressedName("alex", "aaleex"));
		System.out.println(solution.isLongPressedName("saeed", "ssaaedd"));

	}

	
	// TWO POINTERS - 
	// i and j in s1 
	// p and q in s2
	public boolean isLongPressedName(String s1, String s2) {

		int m = s1.length();
		int n = s2.length();
		
		int i = 0, j = 0, p = 0, q = 0;

		while (i < m && p < n) {
			
			char c1 = s1.charAt(i);
			char c2 = s2.charAt(p);

			if (c1 != c2)
				return false; // there is no match found here

			while (j < m && s1.charAt(j) == c1) {
				j++;
			}
			int count1 = j - i;

			while (q < n && s2.charAt(q) == c2) {
				q++;
			}
			int count2 = q - p;
			
			System.out.println("Character : " + c1 + count1 + " ---> " + count2);

			if (count1 > count2)
				return false;

			i = j;
			p = q;
		}
		return i == m && p ==n; // ensure both the pointers reach at the end of strings.

	}

}
