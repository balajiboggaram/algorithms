/**
 * 
 */
package me.learn.personal.month4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Title 315 : 
 * 
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example 1:

Input: nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.

 * 
 * @author bramanarayan
 * @date Aug 6, 2020
 */
public class CountOfSmallerNumberAfterSelf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Transform to a BST
	// whenever you turn right, then increment it
	public List<Integer> countSmaller(int[] a) {
		int n = a.length;
		
		if( n == 0) return new ArrayList<>();
		TreeNodeSpecial root= new TreeNodeSpecial(a[n-1]);
		int[] res = new int[n];
		for(int i =n-1;i>=0;i--) {
			res[i] = insertNode(root, a[i]);
		}
		
		return Arrays.stream(res).boxed().collect(Collectors.toList());
	}

	// returns the number of nodes left of node with value x
	private int insertNode(TreeNodeSpecial root, int x) {
		TreeNodeSpecial cur = root;
		int sum = 0;

		// loop until your number or exhausted the whole tree
		while (cur.val != x) {
			if (x < cur.val) {
				if (cur.left == null)
					cur.left = new TreeNodeSpecial(x);
				cur.lCount++;
				cur = cur.left;
			} else {
				sum = sum + cur.dCount + cur.lCount;
				if (cur.right == null) {
					cur.right = new TreeNodeSpecial(x);
				}
				cur = cur.right;

			}
		}

		cur.dCount++;
		return cur.lCount + sum;
	}		
	}


	
	class TreeNodeSpecial {
		 int val;
		 TreeNodeSpecial left;
		 TreeNodeSpecial right;
		 int lCount;  // count of # of nodes on left side, In other words - smaller than me
		 int dCount; // duplicate count;
		 public TreeNodeSpecial(int val) {
			 this.val = val;
			 left = null;
			 right = null;
		 }
	}
