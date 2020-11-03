/**
 * 
 */
package me.learn.personal.month4;

/**
 * Title 744 :
 * 
 *   Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.

Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.

Examples:

Input:
letters = ["c", "f", "j"]
target = "a"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "c"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "d"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "g"
Output: "j"

Input:
letters = ["c", "f", "j"]
target = "j"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "k"
Output: "c"

 * 
 * @author bramanarayan
 * @date Aug 6, 2020
 */
public class FindSmallestLetterGreaterThanTarget {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		FindSmallestLetterGreaterThanTarget solution = new FindSmallestLetterGreaterThanTarget();
		System.out.println(solution.nextGreatestLetter(new char[] {'c', 'f','j'}, 'j'));
		System.out.println(solution.nextGreatestLetter(new char[] {'c', 'f','j'}, 'c'));
		System.out.println(solution.nextGreatestLetter(new char[] {'c', 'f','j'}, 'd'));

	}
	public char nextGreatestLetter(char[] letters, char target) {

		int l = 0;
		int h = letters.length-1 ;
		while(l<=h) {
			int mid = l + (h-l)/2;
			
			
			if(target >= letters[mid]) {
				l = mid + 1;
			} else {
				h = mid -1 ;
			}
		}
		return letters[l% letters.length];
	}
}
