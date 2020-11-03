/**
 * 
 */
package me.learn.personal.month4;

import java.util.Stack;

/**
 * Title 255 :
 * 
 *  Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

You may assume each number in the sequence is unique.

Consider the following binary search tree: 

     5
    / \
   2   6
  / \
 1   3

Example 1:

Input: [5,2,6,1,3]
Output: false

Example 2:

Input: [5,2,1,3,6]
Output: true

Follow up:
Could you do it using only constant space complexity?

 * 
 * @author bramanarayan
 * @date Jul 28, 2020
 */
public class VerifyPreOrderSequenceBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// revision candidate
	public boolean verifyPreorder(int[] preorder) {
		Stack<Integer> st = new Stack<Integer>();
		int low = Integer.MIN_VALUE;
		int n = preorder.length;
		
		
		for (int i = 0; i < n; i++) {
			
			// already considered lowest can never bet by any other element in preorder.
			if(low > preorder[i]) 
				return false;
			
			// indicates if we need to process right side
			while(!st.isEmpty() && preorder[i] > st.peek() ) {
				low = st.pop();
			}
			
			st.push(preorder[i]);
		}
		return true;

	}
	
	// other divide and conquer o(n log n )
	// lets say start and end. 
	// start is always root, find the first element bigger than a[start]
	// now, repeat the recursion with start+1 to big, big to end
	// if no big, then start+1 to end. 
	// 

}
