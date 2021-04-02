/**
 * 
 */
package me.learn.personal.month5;

import java.util.ArrayList;
import java.util.List;

import me.learn.utli.TreeNode;

/**
 * Title 366 :
 * 
 * Date : Dec 24, 2020
 * 
 * @author bramanarayan
 *
 */
public class CollectLeavesInBinaryTreeInRecursion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// You need to collect the leaves of BT, remove the leaves, Then again collect
	// leaves.
	// Repeat the above procedure until tree is empty
	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> result = new ArrayList<> ();

		if(root == null) return result;
		
		while(root != null) {
			List<Integer> temp = new ArrayList<Integer>();
			root = strip(root, temp);
			result.add(temp);
		}
		return result;
	}

	// Strip off the leaf nodes in this iteration. return all the stripped off leaf nodes
	// this module returns the root of the tree after trimming the trees from it.
	private TreeNode strip(TreeNode root, List<Integer> temp) {
		if(root == null) return null;
		if(root.left == null && root.right == null) {
			temp.add(root.val);
			return null; // This is strip, delete the leaf node
		}
		
		root.left = strip(root.left, temp); // delete leaves in left
		root.right = strip(root.right, temp); // delete leaves in right
		return root;
	}

}
