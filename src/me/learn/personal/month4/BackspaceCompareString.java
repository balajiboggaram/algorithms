///**
// * 
package me.learn.personal.month4;

//
///**
// * Title 844 :
// * 
// *  Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
//
//Note that after backspacing an empty text, the text will continue empty.
//
//Example 1:
//
//Input: S = "ab#c", T = "ad#c"
//Output: true
//Explanation: Both S and T become "ac".
//
//Example 2:
//
//Input: S = "ab##", T = "c#d#"
//Output: true
//Explanation: Both S and T become "".
//
//Example 3:
//
//Input: S = "a##c", T = "#a#c"
//Output: true
//Explanation: Both S and T become "c".
//
//Example 4:
//
//Input: S = "a#c", T = "b"
//Output: false
//Explanation: S becomes "c" while T becomes "b".
//
// * 
// * @author bramanarayan
// * @date Jul 29, 2020
// */
public class BackspaceCompareString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BackspaceCompareString solution = new BackspaceCompareString();
		System.out.println(solution.backspaceCompare("a#c", "b"));
		System.out.println(solution.backspaceCompare("a##c", "#a#c"));
	}

	// // Without Stacks, TWO POINTER
	public boolean backspaceCompare(String s, String t) {

		char[] c1 = s.toCharArray();
		char[] c2 = t.toCharArray();

		int s1 = -1, s2 = -1;

		// use the array as stack for string s
		for (int i = 0; i < c1.length; i++) {
			if (c1[i] != '#') {
				s1++;
				c1[s1] = c1[i];
			} else {
				s1 = s1 >= 0 ? s1 - 1 : -1;
			}
		}

		// use the array as stack for string t
		for (int i = 0; i < c2.length; i++) {
			if (c2[i] != '#') {
				s2++;
				c2[s2] = c2[i];
			} else {
				s2 = s2 >= 0 ? s2 - 1 : -1;
			}
		}
		
		if (s1 != s2)
			return false;

		// compare until s1 number of characters
		for (int i = 0; i <= s1; i++) {
			if (c1[i] != c2[i])
				return false;
		}

		return true;
	}
	
	// With stacks is easy 
	// if you see a  # pop it
	// if you see other, push it
	// compare the two stacks now. 

}
