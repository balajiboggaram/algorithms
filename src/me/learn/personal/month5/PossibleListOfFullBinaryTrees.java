/**
 * 
 */
package me.learn.personal.month5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.learn.utli.TreeNode;

/**
 * Title 894 :
 * 
 * Date : Dec 28, 2020
 * 
 * @author bramanarayan
 *
 */
public class PossibleListOfFullBinaryTrees {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// integer -> its tree (so that we do not recompute again and again)

	// Note : as per problem all the nodes will have the value '0'
	public List<TreeNode> allPossibleFBT(int n) {

		if (n <= 0 || n % 2 == 0)
			return new ArrayList<>(); // we can never make Full BT with even number of nodes.

		List<TreeNode> res = new ArrayList<TreeNode>();

		if (n == 1) {
			res.add(new TreeNode(0));
			return res;
		}

		for (int i = 1; i < n; i += 2) {
			List<TreeNode> leftTrees = allPossibleFBT(i);
			List<TreeNode> rightTrees = allPossibleFBT(n - 1 - i);
			
			//l -> r.....r
			for (TreeNode l : leftTrees) {
				for (TreeNode r : rightTrees) {
					TreeNode root = new TreeNode(0);
					root.left = l;
					root.right = r;
					res.add(root);
				}
			}
		}
		return res;
	}

}
