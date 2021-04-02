/**
 * 
 */
package me.learn.personal.month5;

import java.util.HashSet;
import java.util.Set;

import me.learn.utli.TreeNode;

/**
 * Title 1214 :
 * 
 * Date : Dec 24, 2020
 * 
 * @author bramanarayan
 *
 */
public class TwoSumTargetGivenTwoBSTs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Find if you can have a target element[first tree] + element[second tree] =
	 * target ?
	 */
	Set<Integer> set = new HashSet<Integer>();

	public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {

		// Traverse first tree - put the target - diff in to a set
		// traverse second tree now - check if the element exists, if it is, then you
		// found the answer.
		util(root1, target);
		return isExist(root2);

	}

	private boolean isExist(TreeNode root2) {
		if (root2 == null)
			return false;
		if (set.contains(root2.val))
			return true;
		return isExist(root2.left) || isExist(root2.right);
	}

	private void util(TreeNode root1, int target) {

		if (root1 == null)
			return;
		set.add(target - root1.val);
		util(root1.left, target);
		util(root1.right, target);
	}

}
