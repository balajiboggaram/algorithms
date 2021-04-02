/**
 * 
 */
package me.learn.personal.month6;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Title 339 :
 * 
 * Date : Jan 10, 2021
 * 
 * @author bramanarayan
 *
 */
public class NestedListWeightSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NestedListWeightSum solution = new NestedListWeightSum();
	}

	int sum = 0;

	public int depthSum(List<NestedInteger> nestedList) {
		depthSumUtil(nestedList, 1);
		return sum;
	}

	public void depthSumUtil(List<NestedInteger> nestedList, int open) {

		if (nestedList == null)
			return;
		if (nestedList.size() == 0)
			return;

		for (NestedInteger nestedInteger : nestedList) {
			if (nestedInteger.isInteger()) {
				sum += open * nestedInteger.getInteger();
			} else {
				// this is a list
				depthSumUtil(nestedInteger.getList(), open++);

			}
		}

	}

	// OR
	// BFS solution more straight forward
	public int depthSumBEST(List<NestedInteger> nestedList) {
		if (nestedList == null) {
			return 0;
		}

		int sum = 0;
		int level = 1;

		// Add all the nodes of the input list
		Queue<NestedInteger> queue = new LinkedList<NestedInteger>(nestedList);
		
		while (queue.size() > 0) {
			int size = queue.size();

			// Process that level 
			for (int i = 0; i < size; i++) {
				NestedInteger ni = queue.poll();

				if (ni.isInteger()) {
					sum += ni.getInteger() * level; // process as is if its an integer
				} else {
					queue.addAll(ni.getList());
				}
			}

			level++;
		}

		return sum;
	}

	abstract interface NestedInteger {
		// Constructor initializes an empty nested list.
		// public NestedInteger();

		// Constructor initializes a single integer.
		// public NestedInteger(int value);

		// @return true if this NestedInteger holds a single integer, rather than a
		// nested list.
		public boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds a
		// single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger();

		// Set this NestedInteger to hold a single integer.
		public void setInteger(int value);

		// Set this NestedInteger to hold a nested list and adds a nested integer to it.
		public void add(NestedInteger ni);

		// @return the nested list that this NestedInteger holds, if it holds a nested
		// list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}
}
