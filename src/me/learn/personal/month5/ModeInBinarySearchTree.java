/**
 * 
 */
package me.learn.personal.month5;

import java.util.ArrayList;
import java.util.List;

import me.learn.utli.TreeNode;

/**
 * Title 501 :
 * 
 * Date : Dec 28, 2020
 * 
 * @author bramanarayan
 *
 */
public class ModeInBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Mode is nothing but the most frequent element.
	// if there are too many frequent elements (i.s with same frequency), then
	// return all of them
	int max = 0;
	List<Integer> list = new ArrayList<Integer>();

	public int[] findMode(TreeNode root) {

		if (root == null)
			return new int[] {};

		util(root);

		return list.stream().mapToInt(i -> i).toArray();

	}

	TreeNode prev = null;
	int count = 0;

	private void util(TreeNode root) {

		if (root == null)
			return;

		util(root.left);
		if (prev != null && prev.val == root.val)
			count++;
		else
			count = 1;
		
		if(count > max) {
			max = count;
			list.clear();
			list.add(root.val);
		} else if(count == max) {
			list.add(root.val);
		} 
		
		prev = root;
		util(root.right);
	}

}
