/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 161 :
 * 
 *  Given two strings s and t, determine if they are both one edit distance apart.

Note: 

There are 3 possiblities to satisify one edit distance apart:

    Insert a character into s to get t
    Delete a character from s to get t
    Replace a character of s to get t

Example 1:

Input: s = "ab", t = "acb"
Output: true
Explanation: We can insert 'c' into s to get t.

Example 2:

Input: s = "cab", t = "ad"
Output: false
Explanation: We cannot get t from s by only one step.
 * 
 * @author bramanarayan
 * @date Jun 30, 2020
 */
public class OneEditDistance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OneEditDistance solution = new OneEditDistance();
		System.out.println(solution.isOneEditDistance("abc", "ab"));
	}
	
	
	/**
	 * Let the input strings be s1 and s2 and lengths of input 
strings be m and n respectively.

1) If difference between m an n is more than 1, 
     return false.
2) Initialize count of edits as 0.
3) Start traversing both strings from first character.
    a) If current characters don't match, then
       (i)   Increment count of edits
       (ii)  If count becomes more than 1, return false
       (iii) If length of one string is more, then only
             possible  edit is to remove a character.
             Therefore, move ahead in larger string.
       (iv)  If length is same, then only possible edit
             is to  change a character. Therefore, move
             ahead in both strings. 
    b) Else, move ahead in both strings. 
	 */

	public boolean isOneEditDistance(String s, String t) {
		int m = s.length();
		int n = t.length();

		int count = 0; // Number of edits required.
		
		// THe difference in length cannot be more than 1
		if (Math.abs(m - n) > 1)
			return false;
		
		int i = 0, j = 0;
		while(i<m && j < n) {
			
			if(s.charAt(i) != t.charAt(j)) {
				// mismatch  - one of 3 cases
				count++;
				if(count > 1) return false;
				
				if(m > n) {
					// first string length is greater than second, assume its remove in first
					i++;
				} else if(n > m) {
					j++; // assume a remove in second string
				} else {
					// if length of both strings match, then its like a replace. 
					// so advance in both the strings
					i++;
					j++;
				}
				
				
			} else {
				// if both the character matches. then advance in both the strings
				i++;
				j++;
			}
			
		}
		
		// if there exists one last character in any of the string. 
		// abcd and abc case...
		if(i < m || j < n) {
			count++;
		}
		
		return count == 1;
	
	}

}
