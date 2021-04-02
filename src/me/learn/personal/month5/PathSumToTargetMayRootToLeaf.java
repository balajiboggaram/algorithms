/**
 * 
 */
package me.learn.personal.month5;

import java.util.HashMap;
import java.util.Map;

import me.learn.utli.TreeNode;

/**
 * Title 437 :
 * 
 * Date : Dec 29, 2020
 * 
 * @author bramanarayan
 *
 */
public class PathSumToTargetMayRootToLeaf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// The problem is to find the number of paths which has sum eaual to target.
	// the path may or may not pass via root node
	// not a BST
	int count = 0;
	int k;
	HashMap<Integer, Integer> map = new HashMap();

	public void preorder(TreeNode node, int sum) {
		if (node == null)
			return;

		// current prefix sum
		sum += node.val;

		// here is the sum we're looking for
		if (sum == k)
			count++;

		// number of times the curr_sum − k has occured already,
		// determines the number of times a path with sum k
		// has occured upto the current node
		count += map.getOrDefault(sum - k, 0);

		// add the current sum into hashmap
		// to use it during the child nodes processing
		map.put(sum, map.getOrDefault(sum, 0) + 1);

		// process left subtree
		preorder(node.left, sum);
		// process right subtree
		preorder(node.right, sum);

		// remove the current sum from the hashmap
		// in order not to use it during
		// the parallel subtree processing
		
		// you will never hit this left node again as there would not be any path. 
		// hence decrement this sum,while going to back to root
		map.put(sum, map.get(sum) - 1);
	}

	public int pathSum(TreeNode root, int sum) {
		k = sum;
		preorder(root, 0);
		return count;
	}

}
