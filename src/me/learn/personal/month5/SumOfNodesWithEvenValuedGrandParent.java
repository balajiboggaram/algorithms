/**
 * 
 */
package me.learn.personal.month5;

import me.learn.utli.TreeNode;

/**
 * Title 1315 :
 * 
 * Date : Dec 24, 2020
 * 
 * @author bramanarayan
 *
 */
public class SumOfNodesWithEvenValuedGrandParent {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int sum = 0;

	// sum of even valued grand parent nodes
	public int sumEvenGrandparent(TreeNode root) {
		if (root == null)
			return 0;
		util(root, null, null);
		return sum;
	}

	private void util(TreeNode root, TreeNode parent, TreeNode grandParent) {
		
		if(root == null) return;
		
		if(grandParent != null && grandParent.val %2 == 0) {
			sum+=root.val;
		}
		
		util(root.left, root, parent);
		util(root.right, root, parent);
		
	}

}
