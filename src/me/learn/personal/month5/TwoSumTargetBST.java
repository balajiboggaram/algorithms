/**
 * 
 */
package me.learn.personal.month5;

import java.util.HashSet;
import java.util.Set;

import me.learn.utli.TreeNode;

/**
 * Title 653 :
 * 
 * Date : Dec 24, 2020
 * 
 * @author bramanarayan
 *
 */
public class TwoSumTargetBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Set<Integer> set = new HashSet<Integer>();

	public boolean findTarget(TreeNode root1, int target) {

		if (root1 == null)
			return false;

		if (set.contains(root1.val))
			return true;

		set.add(target - root1.val);
		return findTarget(root1.left, target) || findTarget(root1.right, target);

	}

}
