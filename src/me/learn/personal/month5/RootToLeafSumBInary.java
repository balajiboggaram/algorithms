/**
 * 
 */
package me.learn.personal.month5;

import me.learn.utli.TreeNode;

/**
 * Title 1022 : 
 * 
 * Date : Dec 13, 2020
 * 
 * @author bramanarayan
 *
 */
public class RootToLeafSumBInary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int ans = 0;
	 public int sumRootToLeaf(TreeNode root) {
	        dfs(root, 0);
	        return ans;
	    }

	private void dfs(TreeNode root, int cursum) {

        if(root == null) return;
        cursum = cursum * 2 + root.val;
        if(root.left == null && root.right == null) {
        	
        	ans += cursum;
        }
        dfs(root.left, cursum);
        dfs(root.right, cursum);
		
	}
	
}
