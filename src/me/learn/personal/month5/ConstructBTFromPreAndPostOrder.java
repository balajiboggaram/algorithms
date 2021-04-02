/**
 * 
 */
package me.learn.personal.month5;

import me.learn.utli.TreeNode;

/**
 * Title 889 :
 * 
 * Date : Dec 28, 2020
 * 
 * @author bramanarayan
 *
 */
public class ConstructBTFromPreAndPostOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// we need all the pre and post start and ends for this problem

	public TreeNode constructFromPrePost(int[] pre, int[] post) {
		return util(pre, 0, pre.length - 1, post, 0, post.length - 1);
	}

	private TreeNode util(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd) {

		if (preStart > preEnd)
			return null;

		TreeNode root = new TreeNode(pre[preStart]); // pick the element at preStart as root.

		if (preStart == preEnd)
			return root;

		// Now try to find the postIndex in post array (i.e search for next element of preStart in post array)
		int postIndex = postStart;
		while (post[postIndex] != pre[preStart + 1]) {
			postIndex++;
		}
		int length = postIndex - postStart + 1; // THIS IS THE TRICK HERE, DO NOT FORGET THIS (unlike inorder/preorder+ postorder combination problems)
		
		root.left = util(pre, preStart + 1, preStart + length, post, postStart, postIndex);
		root.right = util(pre, preStart + length + 1, preEnd, post, postIndex+1, postEnd);
		return root;
	}

}
