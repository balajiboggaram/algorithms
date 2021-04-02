/**
 * 
 */
package me.learn.personal.month5;

import java.util.HashMap;

import me.learn.utli.TreeNode;

/**
 * Title 470 :
 * 
 * Date : Dec 15, 2020
 * 
 * @author bramanarayan
 *
 */
public class HouseRobberinBinarytree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	
		
	}



	public int rob(TreeNode root) {
		
		if(root == null) return 0;
		int[] res = robHelper(root);
		return Math.max(res[0], res[1]);
		

	}
	
	public int[] robHelper(TreeNode root) {
		if(root == null) return new int[] {0,0};
		
		int left[] = robHelper(root.left);
		int right[] = robHelper(root.right); // here 0 index -> rob, 1 -> not rob

		int rob = root.val + left[1] + right[1];  // rob this + dont rob rob left + dont rob right
		int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		
		return new int[] {rob, notRob};
		
	}

}
