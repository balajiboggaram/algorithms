package me.learn.personal.month2;

/**
 * 
 * Title 186 : Given an input string , reverse the string word by word. 

Example:

Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]

Note: 

    A word is defined as a sequence of non-space characters.
    The input string does not contain leading or trailing spaces.
    The words are always separated by a single space.

Follow up: Could you do it in-place without allocating extra space?
 
 * 
 * @author bramanarayan
 * @date May 27, 2020
 */
public class ReverseWordsString2 {
	
	public static void main(String args[]) {
		ReverseWordsString2 solution = new ReverseWordsString2();
		solution.reverseWords("the sky is blue".toCharArray());
	}
	
	public void reverseWords(char[] s) {
		int n = s.length;
		int i = 0, k = 0;
		boolean startFound = true; // since there are no leading/trailing white spaces
		while (k < n) {
			if (Character.isWhitespace(s[k]) && startFound) {
				// we have already found the start of the word
				reverseRange(s, i, k - 1);
				startFound = false;
			} else if (!Character.isWhitespace(s[k]) && !startFound) {
				// we have found the first non-white space i.e start of the word
				startFound = true;
				i = k;
			}
			k++;
		}
		reverseRange(s, i, k-1);
		reverseRange(s, 0, n-1);
		System.out.println(s);
	}
	
	
	private void reverseRange(char[] a , int i , int j) {
		while(i<j) {
			char temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
	}
}
