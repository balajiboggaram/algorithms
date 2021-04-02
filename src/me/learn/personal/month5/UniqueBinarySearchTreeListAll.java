/**
 * 
 */
package me.learn.personal.month5;

import java.util.LinkedList;
import java.util.List;

import me.learn.utli.TreeNode;

/**
 * Title 95 :
 * 
 * Given an integer n, generate all structurally unique BST's (binary search
 * trees) that store values 1 ... n.
 * 
 * Example:
 * 
 * Input: 3 Output: [ [1,null,3,2], [3,2,null,1], [3,1,null,null,2], [2,1,3],
 * [1,null,2,null,3] ] Explanation: The above output corresponds to the 5 unique
 * BST's shown below:
 * 
 * 1 3 3 2 1 \ / / / \ \ 3 2 1 1 3 2 / / \ \ 2 1 2 3
 * 
 * Date : Dec 9, 2020
 * 
 * @author bramanarayan
 *
 */
public class UniqueBinarySearchTreeListAll {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<TreeNode> generateTrees(int n) {

		if (n == 0)
			return new LinkedList<TreeNode>();
		return generateTreesUtil(1, n);

	}

	private List<TreeNode> generateTreesUtil(int start, int end) {

		List<TreeNode> result = new LinkedList<TreeNode>();
		if (start > end) {
			result.add(null);
			return result;
		}

		for (int i = start; i <= end; i++) {
			List<TreeNode> leftTrees = generateTreesUtil(start, i - 1);
			List<TreeNode> rightTrees = generateTreesUtil(i + 1, end);

			for (TreeNode left : leftTrees) {
				for (TreeNode right : rightTrees) {
					TreeNode cur = new TreeNode(i);
					cur.left = left;
					cur.right = right;
					result.add(cur);
				}
			}

		}
		return result;

	}
}
