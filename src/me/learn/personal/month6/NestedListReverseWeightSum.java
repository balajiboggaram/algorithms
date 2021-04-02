/**
 * 
 */
package me.learn.personal.month6;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import me.learn.personal.month6.NestedListWeightSum.NestedInteger;

/**
 * Title 364 :
 * 
 * Date : Jan 10, 2021
 * 
 * @author bramanarayan
 *
 */
public class NestedListReverseWeightSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Get the max depth using : 339
	// then assign level to maxDepth . perform BFS
	public int depthSumInverse(List<NestedInteger> nestedList) {

		int maxDepth = maxDepth(nestedList);
		int level = maxDepth;

		int sum = 0;
		// now again perform BFS
		Queue<NestedInteger> queue = new LinkedList<NestedInteger>(nestedList);

		while (!queue.isEmpty()) {

			int size = queue.size();
			for (int i = 0; i < size; i++) {
				NestedInteger temp = queue.poll();
				if (temp.isInteger()) {
					sum += (level * temp.getInteger());
				} else {
					queue.addAll(temp.getList());
				}
			}
			level--;
		}
		return sum;
	}

	// same as 339 with slight modification
	public int maxDepth(List<NestedInteger> nestedList) {
		if (nestedList == null) {
			return 0;
		}
		int level = 1;
		// Add all the nodes of the input list
		Queue<NestedInteger> queue = new LinkedList<NestedInteger>(nestedList);

		while (queue.size() > 0) {
			int size = queue.size();

			// Process that level
			for (int i = 0; i < size; i++) {
				NestedInteger ni = queue.poll();

				if (ni.isInteger()) {
					// do nothing
				} else {

					queue.addAll(ni.getList());
				}
			}
			level++;
		}

		return level;
	}

	// OR
	// NEVER RESET YOUR LEVEL SUM (Carry forward that to next level thats it !!)
	public int depthSumInverseBEST(List<NestedInteger> nestedList) {
		int sum = 0, levelSum = 0;
		Queue<NestedInteger> queue = new LinkedList();
		queue.addAll(nestedList);

		while (!queue.isEmpty()) {
			int size = queue.size();
			// one level processing
			while (size-- > 0) {
				NestedInteger ni = queue.poll();
				if (ni.isInteger()) {
					levelSum += ni.getInteger(); // never reset level sum here at all
				} else {
					queue.addAll(ni.getList());
				}
			}
			// after one level is complete, add it to sum
			sum += levelSum;
		}
		return sum;
	}

}
